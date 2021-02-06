package softuni_game_store.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import softuni_game_store.domain.dtos.*;
import softuni_game_store.domain.entities.Role;
import softuni_game_store.services.interfaces.GameService;
import softuni_game_store.services.interfaces.UserService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class UserController implements CommandLineRunner {
    private static final String REGISTER_USER = "registeruser";
    private static final String LOGIN_USER = "loginuser";
    private static final String LOGOUT_USER = "logout";
    private static final String ADD_GAME = "addgame";
    private static final String DELETE_GAME = "deletegame";
    private static final String ALL_GAMES = "allgame";
    private static final String DETAIL_GAME = "detailgame";
    private static final String OWNED_GAMES = "ownedgame";

    private String loggedInUserEmail = null;

    private final UserService userService;
    private final GameService gameService;

    @Autowired
    public UserController(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
    }

    //TODO STOP THE PROGRAM MANUALLY BECAUSE THE LOOP IS INFINITE!
    @Override
    public void run(String... args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.print("Enter input: ");
            String[] input = reader.readLine().split("\\|");

            String command = input[0].toLowerCase();
            List<String> data = Arrays.stream(input)
                    .skip(1)
                    .collect(Collectors.toList());

            switch (command) {
                case REGISTER_USER:
                    this.registerUser(data);
                    break;
                case LOGIN_USER:
                    this.loginUser(data);
                    break;
                case LOGOUT_USER:
                    this.logoutUser();
                    break;
                case ADD_GAME:
                    this.addGame(data);
                    break;
                case DELETE_GAME:
                    this.deleteGame(data);
                    break;
                case DETAIL_GAME:
                    this.printGameDetail(data);
                    break;
                case ALL_GAMES:
                    this.printAllGames();
                    break;
                case OWNED_GAMES:
                    this.printOwnedGames();
                    break;
                default:
                    System.out.println("Invalid input try again!");
            }
        }
    }

    public void printOwnedGames() {
        if (!isLoggedInUser()) {
            System.out.println("No user is currently logged in!");
            return;
        }

        List<OwnedGameDto> ownedGames = this.gameService
                .fetchOwnedGames(this.loggedInUserEmail);

        if (ownedGames.isEmpty()) {
            UserLogoutDto userWithEmail = this.userService.getUserWithEmail(this.loggedInUserEmail);
            System.out.printf("%s you have not got any games!%n", userWithEmail.getFullName());
        }

        ownedGames.forEach(game -> System.out.println(game.getTitle()));
    }

    public void printGameDetail(List<String> data) {
        String title = data.get(0).trim();
        try {
            GameDetailDto gameDetailDto = this.gameService
                    .fetchGameByTitle(title);


            System.out.printf("Title: %s%nPrice: %.2f%nDescription: %s%nRelease date: %s%n",
                    gameDetailDto.getTitle(),
                    gameDetailDto.getPrice(),
                    gameDetailDto.getDescription(),
                    gameDetailDto.getLocalDate()
                            .format(DateTimeFormatter.ofPattern("d-MM-yyyy")));
        } catch (IllegalArgumentException iae) {
            System.out.println(String.format("%s with message: %s",
                    iae.getClass().getSimpleName(),
                    iae.getMessage()));
        }
    }

    public void printAllGames() {
        this.gameService
                .fetchAllGames()
                .forEach(game -> System.out.printf("%s %s%n",
                        game.getTitle(),
                        game.getPrice()));
    }

    public void addGame(List<String> data) {
        if (!this.isLoggedInUser()) {
            System.out.println("No user is currently logged in!");
            return;
        }

        try {
            UserRoleDto userRoleDto = this.userService.getUserRoleByEmail(this.loggedInUserEmail);
            if (!isAdmin(userRoleDto)) {
                System.out.println("Non admin user can not add games!");
                return;
            }
        } catch (IllegalArgumentException iae) {
            System.out.println(String.format("%s with message: %s",
                    iae.getClass().getSimpleName(),
                    iae.getMessage()));
        }

        String title = data.get(0);
        BigDecimal price = new BigDecimal(data.get(1));
        Double size = Double.parseDouble(data.get(2));
        String trailer = data.get(3);
        String imageThumbnail = data.get(4);
        String description = data.get(5);
        LocalDate releaseDate = LocalDate.parse(data.get(6), DateTimeFormatter.ofPattern("d-M-yyyy"));

        GameCreateDto gameCreateDto =
                new GameCreateDto(title, price, size, trailer, imageThumbnail, description, releaseDate);

        String message = this.gameService.addGame(gameCreateDto);
        System.out.println(message);
    }

    public void deleteGame(List<String> data) {
        if (!this.isLoggedInUser()) {
            System.out.println("No user is currently logged in!");
            return;
        }

        try {
            UserRoleDto userRoleDto = this.userService.getUserRoleByEmail(this.loggedInUserEmail);
            if (!isAdmin(userRoleDto)) {
                System.out.println("Non admin user can not add games!");
                return;
            }
        } catch (IllegalArgumentException iae) {
            System.out.println(String.format("%s with message: %s",
                    iae.getClass().getSimpleName(),
                    iae.getMessage()));
        }

        GameDeleteDto gameDeleteDto = new GameDeleteDto(data.get(0));
        try {
            String message = this.gameService.deleteGame(gameDeleteDto);
            System.out.println(message);
        } catch (IllegalStateException ise) {
            System.out.println(String.format("%s with message: %s",
                    ise.getClass().getSimpleName(),
                    ise.getMessage()));
        }
    }

    public void registerUser(List<String> userData) {
        UserRegisterDto userRegisterDto =
                new UserRegisterDto(userData.get(0), userData.get(1), userData.get(2), userData.get(3));

        try {
            String message = this.userService.registerUser(userRegisterDto);
            System.out.println(message);
        } catch (IllegalArgumentException iae) {
            System.err.println(String.format("%s with message: %s",
                    iae.getClass().getSimpleName(),
                    iae.getMessage()));
        }
    }

    public void loginUser(List<String> userData) {
        UserLoginDto userLoginDto = new UserLoginDto(userData.get(0), userData.get(1));
        if (this.isLoggedInUser()) {
            System.out.println("Can not log in two users at same time!");
            return;
        }

        try {
            String message = this.userService
                    .loginUser(userLoginDto);
            System.out.println(message);

            this.loggedInUserEmail = userLoginDto.getEmail();
        } catch (IllegalArgumentException iae) {
            System.err.println(String.format("%s with message: %s",
                    iae.getClass().getSimpleName(),
                    iae.getMessage()));
        }
    }

    public void logoutUser() {
        if (this.loggedInUserEmail == null) {
            System.out.println("Cannot log out. No user was logged in.");
            return;
        }

        UserLogoutDto userLogoutDto = this.userService.getUserWithEmail(this.loggedInUserEmail);
        System.out.println(String.format("User %s successfully logged out!", userLogoutDto.getFullName()));
        this.loggedInUserEmail = null;
    }

    private boolean isLoggedInUser() {
        if (this.loggedInUserEmail != null) {
            return true;
        }

        return false;
    }

    private boolean isAdmin(UserRoleDto userRoleDto) {
        if (userRoleDto.getRole().equals(Role.ADMIN)) {
            return true;
        }

        return false;
    }
}

package softuni_game_store.domain.dtos;

import org.modelmapper.ModelMapper;
import softuni_game_store.domain.entities.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserRegisterDto {
    private String email;
    private String password;
    private String confirmPassword;
    private String fullName;

    public UserRegisterDto(String email, String password, String confirmPassword, String fullName) {
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.fullName = fullName;
    }

    @NotNull(message = "Email can not be null.")
    @Email(regexp = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?!-)(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$",
            message = "Incorrect email.")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * REGEX FOR PASSWORD WITH AT LEAST 1 CAPITAL LETTER 1 LOWER CASE LETTER AND 1 DIGIT AND NO LESS THAN 6 SYMBOLS!!!
     */
    @Size(min = 6, message = "Password should be at least 6 symbols.")
    @NotNull(message = "Password can not be null.")
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,}$",
            message = "Password should contain one upper case letter one lower case letter and one digit at least!")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public static void initMappings(ModelMapper modelMapper) {
        modelMapper
                .createTypeMap(UserRegisterDto.class, User.class)
                .addMapping(UserRegisterDto::getFullName,
                        (destination, value) -> destination.setFullName((String) value))
                .addMapping(UserRegisterDto::getEmail,
                        (destination, value) -> destination.setEmail((String) value))
                .addMapping(UserRegisterDto::getPassword,
                        (destination, value) -> destination.setPassword((String) value))
                .addMappings(mapper -> {
                    mapper.skip(User::setRole);
                    mapper.skip(User::setId);
                    mapper.skip(User::setGames);
                });
//                .addMapping(source -> {
//                    if (true) {
//                        return Role.ADMIN;
//                    }
//                    return Role.USER;
//                }, (destination, value) -> destination.setRole((Role) value));
    }
}
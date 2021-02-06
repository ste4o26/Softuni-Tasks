package softuni_game_store.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni_game_store.domain.dtos.*;
import softuni_game_store.domain.entities.Role;
import softuni_game_store.domain.entities.User;
import softuni_game_store.reposiotries.UserRepository;
import softuni_game_store.services.interfaces.UserService;
import softuni_game_store.utils.ValidatorUtil;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;


@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ValidatorUtil validatorUtil) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
    }

    @Override
    public String registerUser(UserRegisterDto userRegisterDto) throws IllegalArgumentException {
        boolean isPasswordMatchConfirmPassword = userRegisterDto
                .getPassword()
                .equals(userRegisterDto.getConfirmPassword());

        if (!isPasswordMatchConfirmPassword) {
            throw new IllegalArgumentException("Password does not match!");
        }

        if (!this.validatorUtil.isValid(userRegisterDto)) {
            Set<ConstraintViolation<UserRegisterDto>> violations = this.validatorUtil.violations(userRegisterDto);
            StringBuilder sb = new StringBuilder();

            violations.forEach(constraint -> sb.append(constraint.getMessage())
                    .append(System.lineSeparator()));

            throw new IllegalArgumentException(sb.toString());
        }

        User user = this.modelMapper
                .map(userRegisterDto, User.class);

        this.setUserRole(user);

        this.userRepository
                .saveAndFlush(user);

        return String.format("%s was registered successfully!", user.getFullName());
    }

    @Override
    public String loginUser(UserLoginDto userLoginDto) throws IllegalArgumentException {
        if (!this.validatorUtil.isValid(userLoginDto)) {
            Set<ConstraintViolation<UserLoginDto>> violations = this.validatorUtil.violations(userLoginDto);
            StringBuilder sb = new StringBuilder();

            violations.forEach(constraint -> sb.append(constraint.getMessage())
                    .append(System.lineSeparator()));

            throw new IllegalArgumentException(sb.toString());
        }

        User user = this.userRepository
                .findByEmail(userLoginDto.getEmail())
                .orElse(null);

        if (user == null || !user.getPassword().equals(userLoginDto.getPassword())) {
            throw new IllegalArgumentException("Incorrect username / password!");
        }

        return String.format("Successfully logged in %s", user.getFullName());
    }

    @Override
    public UserLogoutDto getUserWithEmail(String userEmail) {
        User user = this.userRepository.findByEmail(userEmail)
                .orElse(null);

        if (user == null) {
            throw new IllegalArgumentException(String.format("User with email %s does not exists!", userEmail));
        }

        return this.modelMapper.map(user, UserLogoutDto.class);
    }

    @Override
    public UserRoleDto getUserRoleByEmail(String userEmail) {
        User user = this.userRepository.findByEmail(userEmail)
                .orElse(null);

        if (user == null) {
            throw new IllegalArgumentException(String.format("User with email %s does not exists!", userEmail));
        }

        return this.modelMapper.map(user, UserRoleDto.class);
    }

    private void setUserRole(User user) {
        if (true) {
            user.setRole(Role.ADMIN);
        } else {
            user.setRole(Role.USER);
        }
    }
}


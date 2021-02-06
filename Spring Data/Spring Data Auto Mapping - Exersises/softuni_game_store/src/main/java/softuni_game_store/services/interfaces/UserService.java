package softuni_game_store.services.interfaces;

import softuni_game_store.domain.dtos.*;

public interface UserService {
    String registerUser(UserRegisterDto userRegisterDto) throws IllegalArgumentException;

    String loginUser(UserLoginDto userLoginDto) throws IllegalArgumentException;

    UserLogoutDto getUserWithEmail(String email);

    UserRoleDto getUserRoleByEmail(String userEmail);

}

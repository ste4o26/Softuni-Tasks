package softuni_game_store.domain.dtos;

import javax.validation.constraints.NotNull;

public class UserLoginDto {
    private String email;
    private String password;

    public UserLoginDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @NotNull(message = "Email can not be empty(null value)!")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @NotNull(message = "Password can not be empty(null value)!")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

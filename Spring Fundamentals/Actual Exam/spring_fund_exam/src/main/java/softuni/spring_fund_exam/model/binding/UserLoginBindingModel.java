package softuni.spring_fund_exam.model.binding;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserLoginBindingModel {

    @Size(min = 3, max = 20, message = "Username length must be between 3 and 20 characters (inclusive 3 and 20).")
    @NotNull
    private String username;

    @Size(min = 5, max = 20, message = "Password length must be between 5 and 20 characters (inclusive 5 and 20).")
    @NotNull
    private String password;
}

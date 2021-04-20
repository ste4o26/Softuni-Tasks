package softuni.spring_fund_exam.model.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserServiceModel extends BaseServiceModel {
    private String username;

    private String fullName;

    private String password;

    private String email;
}

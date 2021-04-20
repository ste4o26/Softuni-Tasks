package softuni.spring_fund_exam.services.interfaces;

import softuni.spring_fund_exam.model.service.UserServiceModel;

public interface UserService {
    UserServiceModel fetchByUserName(String username);

    UserServiceModel persist(UserServiceModel userServiceModel);
}

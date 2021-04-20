package softuni.spring_fund_exam.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.spring_fund_exam.model.entities.UserEntity;
import softuni.spring_fund_exam.model.service.UserServiceModel;
import softuni.spring_fund_exam.repositories.UserRepository;
import softuni.spring_fund_exam.services.interfaces.UserService;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserServiceModel fetchByUserName(String username) {
        UserEntity userEntity = this.userRepository
                .findByUsername(username)
                .orElse(null);

        if (userEntity == null){
            return null;
        }

        return this.modelMapper.map(userEntity, UserServiceModel.class);
    }

    @Override
    public UserServiceModel persist(UserServiceModel userServiceModel) {
        UserEntity userEntity = this.userRepository
                .findByUsername(userServiceModel.getUsername())
                .orElse(null);

//        TODO USER is registered already!!
        if (userEntity != null){
            return null;
        }

        userEntity = this.modelMapper.map(userServiceModel, UserEntity.class);

        return this.modelMapper.map(this.userRepository.saveAndFlush(userEntity), UserServiceModel.class);
    }
}

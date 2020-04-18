package user_permissions;

import user_permissions.repositories.ResourceRepository;
import user_permissions.resources.Resource;
import user_permissions.users.User;

//izpolzvam Composition
public class UserService {
    //vzemam edno repozitori bez znachenie kakvo stiga da implementira ResourceRepository
    private ResourceRepository repository;

    public UserService(ResourceRepository repository) {
        this.repository = repository;
    }

    public void readOneResourceForUser(User user){
        //izvlicham edin resource ot nego (v slucheq vrashtam prosto nov obekt ot konretniq tip repository,
        // no moga da gi suhranqvam v nqkakva baza danni i da vzemam tova koeto mi trqbva)
        Resource resource = this.repository.fetchOne();
        //kazvam
        user.read(resource);
    }
}

package com.spirng_demo.repositories;

import com.spirng_demo.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User getByUsername(String username);
}

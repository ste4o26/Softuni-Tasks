package com.spirng_demo.repositories;

import com.spirng_demo.entities.Account;
import com.spirng_demo.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
    //TODO methods!!!
    List<Account> findAllByUser(User user);
}

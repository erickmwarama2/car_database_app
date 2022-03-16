package com.erick.cardatabase.repositories;

import com.erick.cardatabase.domain.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    
    User findByUsername(String username);
}

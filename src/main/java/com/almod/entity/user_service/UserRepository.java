package com.almod.entity.user_service;

import com.almod.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    public Iterable<User> findUserByFirstname(String firstname);
}

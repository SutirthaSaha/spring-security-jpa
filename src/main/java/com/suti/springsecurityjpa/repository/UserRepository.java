package com.suti.springsecurityjpa.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.suti.springsecurityjpa.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
	Optional<User> findByUserName(String userName);
}

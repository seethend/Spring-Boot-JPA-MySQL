package com.seeth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seeth.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}

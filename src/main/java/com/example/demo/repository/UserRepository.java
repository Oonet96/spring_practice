package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    Optional<User> findById(int id);
    Optional<User> findByUserId(String userId);

    boolean existsByUserId(String userId);
    boolean existsByNickname(String userName);
}

package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Reviews;

import java.util.Optional;

@Repository
public interface TestRepository extends JpaRepository<Reviews,Integer> {
    Optional<Reviews> findById(Integer id);
}

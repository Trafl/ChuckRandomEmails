package com.example.demo.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.domain.model.User;

public interface UserRepository extends MongoRepository<User, String>{

}

package com.tma.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tma.model.User;

public interface UserRepository extends MongoRepository<User, String>{

}

package com.example.dao;

import java.math.BigInteger;
import org.springframework.data.repository.CrudRepository;

import com.example.entities.Users;


public interface UserRepository extends CrudRepository<Users, BigInteger>{

}
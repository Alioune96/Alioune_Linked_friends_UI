package com.techelevator.tenmo.Tenmo.dao;

import com.techelevator.tenmo.Tenmo.model.RegisterUserDto;
import com.techelevator.tenmo.Tenmo.model.User;

import java.util.List;

public interface UserDao {

    List<User> getUsers();

    User getUserById(int id);

    User getUserByUsername(String username);

    User createUser(RegisterUserDto user);
}

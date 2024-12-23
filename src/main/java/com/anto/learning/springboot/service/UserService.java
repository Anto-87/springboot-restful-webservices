package com.anto.learning.springboot.service;

import com.anto.learning.springboot.dto.UserDto;
import com.anto.learning.springboot.entity.User;
import com.anto.learning.springboot.exception.EmailAlreadyExistException;
import com.anto.learning.springboot.exception.ResourceNotFoundException;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto user) throws EmailAlreadyExistException;
    UserDto getByUserId(Long id) throws ResourceNotFoundException;
    List<UserDto> getAllUsers() throws ResourceNotFoundException;
    UserDto updateUser(UserDto user) throws ResourceNotFoundException;
    void deleteUser(Long id) throws ResourceNotFoundException;
}

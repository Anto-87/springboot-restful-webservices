package com.anto.learning.springboot.service.impl;

import com.anto.learning.springboot.dto.UserDto;
import com.anto.learning.springboot.entity.User;
import com.anto.learning.springboot.exception.EmailAlreadyExistException;
import com.anto.learning.springboot.exception.ResourceNotFoundException;
import com.anto.learning.springboot.mapper.AutoUserMapper;
import com.anto.learning.springboot.mapper.UserMapper;
import com.anto.learning.springboot.repository.UserRepository;
import com.anto.learning.springboot.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) throws EmailAlreadyExistException {

        // model mapper
        //User user = modelMapper.map(userDto, User.class);
        // MapStruct
        Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail());

        if(optionalUser.isPresent()){
            throw new EmailAlreadyExistException("Email Already Exists for User");
        }

        User user = AutoUserMapper.MAPPER.mapToUser(userDto);
        User savedUser = userRepository.save(user);
        //Model mapper
        //UserDto savedUserDto = modelMapper.map(savedUser, UserDto.class);

        //MapStruct
        UserDto savedUserDto = AutoUserMapper.MAPPER.maptoUserDto(savedUser);

        return savedUserDto;
    }

    @Override
    public UserDto getByUserId(Long id) throws ResourceNotFoundException {
        User user= userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", id)
        );

        // ModelMapper
        // modelMapper.map(userData, UserDto.class);
        //MapStruct
        return AutoUserMapper.MAPPER.maptoUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> userDatas =  userRepository.findAll();

        // Model Mapper
        //return userDatas.stream().map(
          //      (users) -> modelMapper.map(users, UserDto.class))
            //    .collect(Collectors.toList());

        // Map Struct
        return userDatas.stream().map(
                  (users) -> AutoUserMapper.MAPPER.maptoUserDto(users))
                 .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto user) throws ResourceNotFoundException {

        User userData = userRepository.findById(user.getId()).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", user.getId())
        );
        userData.setFirstName(user.getFirstName());
        userData.setLastName(user.getLastName());
        userData.setEmail(user.getEmail());
        userRepository.save(userData);
        //Model Mapper
        // modelMapper.map(userData, UserDto.class);
        //Map Struct
        return AutoUserMapper.MAPPER.maptoUserDto(userData);
    }

    @Override
    public void deleteUser(Long id) throws ResourceNotFoundException {
        User existingUser = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", id)
        );
        userRepository.deleteById(id);
    }
}

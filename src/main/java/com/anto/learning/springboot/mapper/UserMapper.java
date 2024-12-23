package com.anto.learning.springboot.mapper;

import com.anto.learning.springboot.dto.UserDto;
import com.anto.learning.springboot.entity.User;

public class UserMapper {

    public static UserDto maptoUserDto(User user){
        UserDto userDto = new UserDto(
            user.getId(), user.getFirstName(), user.getLastName(), user.getEmail()
        );

        return userDto;
    }

    public static User mapToUser(UserDto userDto){
        User user = new User(
                userDto.getId(), userDto.getFirstName(), userDto.getLastName(), userDto.getEmail()
        );

        return user;

    }

}

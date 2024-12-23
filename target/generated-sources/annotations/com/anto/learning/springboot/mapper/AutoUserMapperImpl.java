package com.anto.learning.springboot.mapper;

import com.anto.learning.springboot.dto.UserDto;
import com.anto.learning.springboot.entity.User;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-30T18:23:59+0530",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.40.0.v20240919-1711, environment: Java 17.0.12 (Eclipse Adoptium)"
)
public class AutoUserMapperImpl implements AutoUserMapper {

    @Override
    public UserDto maptoUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setEmail( user.getEmail() );
        userDto.setFirstName( user.getFirstName() );
        userDto.setId( user.getId() );
        userDto.setLastName( user.getLastName() );

        return userDto;
    }

    @Override
    public User mapToUser(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setEmail( userDto.getEmail() );
        user.setFirstName( userDto.getFirstName() );
        user.setId( userDto.getId() );
        user.setLastName( userDto.getLastName() );

        return user;
    }
}

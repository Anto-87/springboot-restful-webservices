package com.anto.learning.springboot.mapper;

import com.anto.learning.springboot.dto.UserDto;
import com.anto.learning.springboot.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoUserMapper {

    AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);

    UserDto maptoUserDto(User user);

    User mapToUser(UserDto userDto);

}

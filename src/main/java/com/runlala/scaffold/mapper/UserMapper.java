package com.runlala.scaffold.mapper;

import com.runlala.scaffold.dto.in.UserInDto;
import com.runlala.scaffold.dto.out.UserOutDto;
import com.runlala.scaffold.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(source = "name", target = "username")
    UserOutDto toUserOutDto(User user);

    List<UserOutDto> toUserOutDtoList(List<User> users);

    User toUser(UserInDto userInDto);
}
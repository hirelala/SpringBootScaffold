package com.runlala.scaffold.mapper;

import com.runlala.scaffold.dto.in.UserInDto;
import com.runlala.scaffold.dto.out.UserOutDto;
import com.runlala.scaffold.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(source = "name", target = "username")
    UserOutDto toUserOutDTO(User user);

    User toUser(UserInDto userInDto);
}
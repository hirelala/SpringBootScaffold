package com.runlala.scaffold.controller.api;

import com.runlala.scaffold.dto.R;
import com.runlala.scaffold.dto.in.UserInDto;
import com.runlala.scaffold.dto.out.UserOutDto;
import com.runlala.scaffold.entity.User;
import com.runlala.scaffold.mapper.UserMapper;
import com.runlala.scaffold.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@Tag(name = "User")
public class UserApiController {
    private final UserService userService;
    private final UserMapper userMapper;

    @Autowired
    public UserApiController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping("/add")
    public R<UserOutDto> add(@RequestBody UserInDto userInDto) {
        Assert.isTrue(StringUtils.isNotBlank(userInDto.getName()), "name can not be blank");
        Assert.isTrue(StringUtils.isNotBlank(userInDto.getEmail()), "email can not be blank");

        User userIn = userMapper.toUser(userInDto);
        User user = userService.addUser(userIn);
        return R.success(userMapper.toUserOutDto(user));
    }

    @GetMapping("/get")
    public R<UserOutDto> get(@RequestParam String email) {
        Assert.isTrue(StringUtils.isNotBlank(email), "email can not be blank");

        Optional<User> user = userService.getByEmail(email);
        return user.map(value -> R.success(userMapper.toUserOutDto(value))).orElseGet(() -> R.error("user not found"));
    }

    @GetMapping("/get-all")
    public R<List<UserOutDto>> getAll() {
        List<User> users = userService.getAll();
        return R.success(userMapper.toUserOutDtoList(users));
    }
}
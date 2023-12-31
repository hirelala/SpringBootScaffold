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

import java.util.Map;

@RestController
@RequestMapping("/api/user")
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
        return R.success(userMapper.toUserOutDTO(user));
    }

    @GetMapping("/get")
    public R<Map<String, Boolean>> exist(@RequestParam String email) {
        Assert.isTrue(StringUtils.isNotBlank(email), "email can not be blank");
        return R.success(Map.of("exist", userService.isEmailExist(email)));
    }
}
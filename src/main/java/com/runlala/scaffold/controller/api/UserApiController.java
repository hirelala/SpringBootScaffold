package com.runlala.scaffold.controller.api;

import com.runlala.scaffold.dto.in.UserInDto;
import com.runlala.scaffold.dto.out.UserOutDto;
import com.runlala.scaffold.entity.User;
import com.runlala.scaffold.mapper.UserMapper;
import com.runlala.scaffold.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@Tag(name = "User")
@Validated
public class UserApiController {
    private final UserService userService;
    private final UserMapper userMapper;

    @Autowired
    public UserApiController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping("/add")
    public ResponseEntity<UserOutDto> add(@RequestBody @Valid UserInDto userInDto) {
        Assert.isTrue(StringUtils.isNotBlank(userInDto.getName()), "name can not be blank");
        Assert.isTrue(StringUtils.isNotBlank(userInDto.getEmail()), "email can not be blank");

        User userIn = userMapper.toUser(userInDto);
        User user = userService.addUser(userIn);
        return ResponseEntity.ok(userMapper.toUserOutDto(user));
    }

    @GetMapping("/get")
    public ResponseEntity<UserOutDto> get(@RequestParam String email) {
        Assert.isTrue(StringUtils.isNotBlank(email), "email can not be blank");

        Optional<User> user = userService.getByEmail(email);
        if (user.isEmpty()) {
            throw new IllegalArgumentException("Can't not find user!");
        }

        return ResponseEntity.ok(userMapper.toUserOutDto(user.get()));
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<UserOutDto>> getAll() {
        List<User> users = userService.getAll();
        return ResponseEntity.ok(userMapper.toUserOutDtoList(users));
    }
}
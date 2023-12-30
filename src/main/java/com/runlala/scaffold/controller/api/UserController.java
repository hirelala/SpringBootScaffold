package com.runlala.scaffold.controller.api;

import com.runlala.scaffold.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/user")
@Tag(name = "User")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/exist")
    public Boolean exist(@RequestParam String email) {
        Assert.isTrue(StringUtils.isNotBlank(email), "email can not be blank");
        return userService.isEmailExist(email);
    }
}

package com.runlala.scaffold.controller.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Home")
public class HomeApiController {
    @GetMapping("/health")
    public String health() {
        return "ok";
    }
}

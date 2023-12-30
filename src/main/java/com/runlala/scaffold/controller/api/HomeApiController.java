package com.runlala.scaffold.controller.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeApiController {
    @GetMapping("/health")
    public String health() {
        return "ok";
    }
}

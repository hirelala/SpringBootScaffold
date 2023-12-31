package com.runlala.scaffold.controller.api;

import com.runlala.scaffold.dto.R;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Tag(name = "Home")
public class HomeApiController {
    @GetMapping("/health")
    public R<String> health() {
        return R.success("ok");
    }
}
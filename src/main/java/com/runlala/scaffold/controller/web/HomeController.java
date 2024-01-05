package com.runlala.scaffold.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("greeting", "Hello SpringBootScaffold!");
        return "index";
    }
}

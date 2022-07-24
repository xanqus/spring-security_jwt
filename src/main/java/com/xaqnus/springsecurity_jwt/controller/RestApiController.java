package com.xaqnus.springsecurity_jwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestApiController {

    @GetMapping("home")
    public String home() {
        return "<h1>home</h1>";
    }

    @GetMapping("manager/hi")
    public String himanager() {
        return "<h1>hi manager</h1>";
    }
}

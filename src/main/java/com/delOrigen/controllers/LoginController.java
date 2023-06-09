package com.delOrigen.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class LoginController {


    @RequestMapping("/login")
    public String getLogin() {
        return "login";
    }
}

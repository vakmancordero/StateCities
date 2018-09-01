package com.upch.microservices.ui.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ui/home")
public class HomeController {

    @GetMapping
    public String home() {
        return "microservices";
    }

}

package com.dogigiri.springcore.springconfiguration.controller;

import com.dogigiri.springcore.springconfiguration.service.GreetingService;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {
    private GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String greet() {
        return greetingService.greet();
    }
}

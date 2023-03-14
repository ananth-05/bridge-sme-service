package com.bridge.sme.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/security-check")
public class HelloWorldController {

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome this endpoint is not secure!";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }
}

package vip.acgcode.springboot.spring_boot_start.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello everyon,This is my first SpringBoot Web project!";
    }
}

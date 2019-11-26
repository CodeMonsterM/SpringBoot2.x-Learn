package vip.avgcode.springboot.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author MING
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index(ModelMap modelMap){
        modelMap.addAttribute("MSG","Hello,MING !");
        return "index";
    }
}

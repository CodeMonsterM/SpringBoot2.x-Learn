package vip.acgcode.springboot.spring_boot_start.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.acgcode.springboot.spring_boot_start.entity.ProjectConfigBean;

@RestController
public class TestController {
    @Value("${project.name}")
    private String projectName;

    @Value("${project.author}")
    private String projectAuthor;

    @Autowired
    private ProjectConfigBean projectConfigBean;

    @GetMapping("/test1")
    public String test1(){
        return "本项目的名字是："+projectName+",属于："+projectAuthor+"所有";
    }

    @GetMapping("/test2")
    public ProjectConfigBean test2(){
        return projectConfigBean;
    }
}

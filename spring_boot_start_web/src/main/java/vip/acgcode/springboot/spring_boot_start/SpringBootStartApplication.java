package vip.acgcode.springboot.spring_boot_start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import vip.acgcode.springboot.spring_boot_start.entity.ProjectConfigBean;

@SpringBootApplication
@EnableConfigurationProperties(ProjectConfigBean.class)
public class SpringBootStartApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootStartApplication.class, args);
    }

}

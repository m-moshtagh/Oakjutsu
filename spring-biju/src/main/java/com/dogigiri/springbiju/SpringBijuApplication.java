package com.dogigiri.springbiju;

import com.dogigiri.springcore.springconfiguration.controller.GreetingController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.dogigiri"})
public class SpringBijuApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringBijuApplication.class, args);
        GreetingController controller = (GreetingController) context.getBean("greetingController");
        System.out.println(controller.greet());
    }

}

package com.helpdesksystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelpDeskSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelpDeskSystemApplication.class, args);
        System.out.println("系统运行成功");
    }

}

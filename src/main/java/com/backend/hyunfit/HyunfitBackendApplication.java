package com.backend.hyunfit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class HyunfitBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(HyunfitBackendApplication.class, args);
    }

}

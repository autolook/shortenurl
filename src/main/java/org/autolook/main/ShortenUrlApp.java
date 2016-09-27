package org.autolook.main;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.autolook")
@EnableAutoConfiguration
public class ShortenUrlApp {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ShortenUrlApp.class, args);
    }

}

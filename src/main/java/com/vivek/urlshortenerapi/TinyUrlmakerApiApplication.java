package com.vivek.urlshortenerapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class TinyUrlmakerApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(TinyUrlmakerApiApplication.class, args);
    }
}

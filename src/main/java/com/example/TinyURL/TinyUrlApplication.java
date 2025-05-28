package com.example.TinyURL;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@SpringBootApplication
@OpenAPIDefinition(
  info = @Info(
    title       = "TinyURL Service API",
    version     = "1.0.0",
    description = "This API lets you shorten URLs and redirect by code"
  ),
  servers = @Server(
    url         = "http://localhost:8080",
    description = "Local dev server"
  )
)
public class TinyUrlApplication {

    public static void main(String[] args) {
        SpringApplication.run(TinyUrlApplication.class, args);
        System.out.println("HIIIII");
        
    }

}

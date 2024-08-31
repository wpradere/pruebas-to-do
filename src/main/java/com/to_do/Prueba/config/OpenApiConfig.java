package com.to_do.Prueba.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "To-Do",
                version = "1.0",
                description = "This is a Todo rest Api"

        )


)
public class OpenApiConfig {



    }

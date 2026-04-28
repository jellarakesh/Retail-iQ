package com.example.swagger;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.annotations.Operation;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI retailIQOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("RetailIQ REST APIs")
                        .description("APIs for RetailIQ – Omnichannel Platform")
                        .version("1.0"));
    }
}

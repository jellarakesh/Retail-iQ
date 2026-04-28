package com.example.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "RetailIQ API",
        version = "1.0",
        description = "Omnichannel Customer Experience & Inventory Optimization Platform"
    ),
    servers = {
        @Server(url = "http://localhost:9011", description = "Local server")
    }
)
public class OpenApiConfig {
}
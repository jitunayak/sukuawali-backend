package com.sukuawali.sukuawalibackend.configurations;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIdoc {
    @Bean

    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Sukuawali REST Services")
                        .version("1.2")
                        .description("This backedend services are for both mobile application and web application")
                        .termsOfService("http://sukuawali.com")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));

    }
}

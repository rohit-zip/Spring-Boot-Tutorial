package com.tutorial.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collection;
import java.util.Collections;

/**
 * Owner - Rohit Parihar
 * Author - rohit
 * Project - Tutorial
 * Package - com.tutorial.configurations
 * Created_on - 03 January-2024
 * Created_at - 21 : 14
 */

@Configuration
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
        return new Docket(
                DocumentationType.SWAGGER_2
        ).apiInfo(getInfo())
                .securitySchemes(Collections.emptyList())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.tutorial"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo getInfo() {
        Contact contact = new Contact(
                "Rohit Parihar",
                "https://linkedin.in/beingrohit.exe",
                "rohitparih@gmail.com"
        );
        return new ApiInfo(
                "Social Media",
                "This is Tutorial project",
                "1.0",
                "Terms of Service",
                contact,
                "License",
                "License URL",
                Collections.emptyList()
        );
    }
}

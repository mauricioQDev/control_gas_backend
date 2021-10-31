package com.umanizales.control_gas.infrastructure.controllers.config;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.builders.RequestHandlerSelectors;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.spi.DocumentationType;
import org.springframework.context.annotation.Bean;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("ControlGas")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.umanizales.control_gas.infrastructure.controllers"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "Controller Manage Gas",
                "Service Rest API Crud Control Gas",
                "1.0",
                "http://umanizales.edu.co/",
                new Contact("Mauricio Quintero", "http://umanizales.edu.co/", "mquintero78594@umanizales.edu.co"),
                "LICENSE",
                "LICENSE URL",
                Collections.emptyList()
        );
    }
}

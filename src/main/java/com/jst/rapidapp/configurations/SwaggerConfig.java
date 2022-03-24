package com.jst.rapidapp.configurations;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi publicApi(){
        return GroupedOpenApi.builder()
                .group("Rapid Application System API")
                .packagesToScan("com.jst.rapidapp")
                .pathsToMatch("/rapidapp/**")
                .build();
    }

//    public ApiInfo apiInfoDetals(){
//        return new ApiInfo(
//                "Rapid Application System API",
//                "Rest API service for Rapid Application System",
//                "1.0",
//                "JST License Terms and Conditions",
//                new springfox.documentation.service.Contact("JST","https://jstrapidapp.com","jstrapidapp@gmail.com"),
//                "JST License",
//                "https://jstrapidapp.com",
//                Collections.emptyList()
//        );
//    }
}

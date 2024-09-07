package com.telecom.gastos.config;

import org.springframework.context.annotation.Bean;
import org.springdoc.core.models.GroupedOpenApi;

public class SwaggerConfiguration {
    @Bean
    GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public-apis")
                .pathsToMatch("/**")
                .build();
    }
}

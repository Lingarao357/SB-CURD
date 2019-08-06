/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.sample.config;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    public static final Contact DEFAULT_CONTACT = new Contact("Vectramind Technologies", "http://www.vectramind.com", "sales@vectramind.com");
    public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Sample", "Sample 1.0 UI Services", "1.0", "", "http://www.vectramind.com", "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");
    private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<String>(Arrays.asList("application/json", "application/xml"));

    @Bean
    public Docket swaggerApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_API_INFO)
                .produces(DEFAULT_PRODUCES_AND_CONSUMES)
                .consumes(DEFAULT_PRODUCES_AND_CONSUMES);
    }

    private ApiKey apiKey() {
        return new ApiKey("authkey", "Authorization", "header");
    }
}

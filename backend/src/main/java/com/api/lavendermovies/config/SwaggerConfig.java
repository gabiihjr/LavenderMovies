package com.api.lavendermovies.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.HashSet;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private Contact contact(){
        return new Contact(
                "Gabi",
                "https://github.com/gabiihjr",
                "gabriela.hermenegildo@gmail.com"
        );
    }

    private ApiInfoBuilder apiInformations() {
        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();

        apiInfoBuilder.title("Lavender Movies - REST API");
        apiInfoBuilder.description("Lavender Movies API");
        apiInfoBuilder.version("1.0");
        apiInfoBuilder.termsOfServiceUrl("Terms of Service: Open Source");
        apiInfoBuilder.contact(this.contact());

        return apiInfoBuilder;
    }

    @Bean
    public Docket detailsApi() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2);

        docket
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.api.lavendermovies.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(this.apiInformations().build())
                .consumes(new HashSet<String>(Arrays.asList("application/json")))
                .produces(new HashSet<String>(Arrays.asList("application/json")));

        return docket;
    }
}

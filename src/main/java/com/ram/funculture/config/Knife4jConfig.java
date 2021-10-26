package com.ram.funculture.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@EnableOpenApi   // 开启Swagger自定义接口文档
@Configuration   // 相当于Spring配置中的<beans>
public class Knife4jConfig {
    @Bean(value = "defaultApi")
    public Docket defaultApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("文娱")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.max.controller"))
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("文娱 RESTful APIs")
                .description("文娱")
                .termsOfServiceUrl("http://www.xxxxx.com/")
                .build();
    }
}
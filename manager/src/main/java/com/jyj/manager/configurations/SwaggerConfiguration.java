package com.jyj.manager.configurations;

import com.jyj.manager.controller.ProductController;
import org.springframework.boot.autoconfigure.web.BasicErrorController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger配置类
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket controllerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("controller")
                .apiInfo(apiInfo())
                .select()
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("HTTP API")
                .description("管理端接口")
                .termsOfServiceUrl("http://springfox.io")
                .contact("jyj")
                .license("Apache License Version 2.0")
                .licenseUrl("https://github.com/springfox/springfox/blob")
                .version("2.0")
                .build();
    }

}

package com.zhg.swagger;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@ConditionalOnProperty(prefix = "swagger",value = {"enable"},havingValue = "true")//enable
@EnableWebMvc
public class SwaggerConfig {
	
	   @Bean
	    public Docket createRestApi() {
		   
	        return new Docket(DocumentationType.SWAGGER_2)
	                .apiInfo(apiInfo())
	                .select()
	                .apis(RequestHandlerSelectors.basePackage("com.zhg.api"))
	                .paths(PathSelectors.any())
	                .build();
	    }
	   
	    @SuppressWarnings("deprecation")
		private ApiInfo apiInfo() {
	        return new ApiInfoBuilder()
	                .title("测试swagger")
	                .description("RESTful APIs 接口文档集合")
	                .termsOfServiceUrl("http://www.lemos.club/")
	                .contact("zhg")//作者
	                .version("1.0")
	                //.license("The Apache License, Version 2.0")
	                .build();
	    }

}
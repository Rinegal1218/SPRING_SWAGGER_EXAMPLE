package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * SwaggerConfig class.
 * This class implements WebMvcConfigurer interface to show swagger user interface.
 * @author Rinegal1218
 */
@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig implements WebMvcConfigurer {

	/**
	 * This method specifies swagger ui path.
	 */
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry
			.addResourceHandler("swagger-ui.html")
            .addResourceLocations("classpath:/META-INF/resources/");
	}

	/**
	 * This method is used to map the package that have the controllers for swagger-ui.
	 * @return Docket object.
	 */
    @Bean
    public Docket apiDocket() {
	    return new Docket(DocumentationType.SWAGGER_2)
	        .apiInfo(getApiInfo())
	        .select()
	        .apis(RequestHandlerSelectors.basePackage("com.example.demo.controllers"))
	        .paths(PathSelectors.any())
	        .build();
    }

    /**
     * This method sets information to /v2/api-docs path.
     * @return ApiInfo object.
     */
    private ApiInfo getApiInfo() {
    	return new ApiInfoBuilder()
            .title("Swagger API Doc")
            .description("Spring Swagger API example.")
            .version("1.0.0")
            .build();
    }
}
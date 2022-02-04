package me.dio.academia.digital;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SpringFoxConfig {

	 @Bean
	    public Docket api() {
	        return new Docket(DocumentationType.SWAGGER_2)
	          .select()
	          .apis(RequestHandlerSelectors.basePackage("me.dio.academia.digital.controller"))
	          .paths(PathSelectors.any())
	          .build()
	          .apiInfo(metaInfo());
	    }
	 
	 
	 private ApiInfo metaInfo() {

	        ApiInfo apiInfo = new ApiInfo(
	                "Api Academia REST",
	                "API REST de cadastro de Alunos.",
	                "1.0",
	                "",
	                new Contact("Jefferson da Silva leal", "https://www.linkedin.com/in/jefferson-da-silva-leal/",
	                        "drankhar@gmail.com"),
	                "",
	                "https://www.apache.org/licesen.html", new ArrayList<VendorExtension>()
	        );

	        return apiInfo;
	    }
}

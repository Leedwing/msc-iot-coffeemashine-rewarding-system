package com.hhz.hackathon2017.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Configurationsklasse für die Swagger-ui
 * 
 * @author Lee Edwing Nguepedja Tchwangnwou
 */
@Configuration
@EnableSwagger2
public class Swaggerconfig {
	@Bean
	public Docket productAPI() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.hhz.hackathon2017"))
				.paths(regex("/coffeemachine.*"))
				.build()
				.apiInfo(metaInfo()); //Custom Config
	}
	
	//Custom Config
	private ApiInfo metaInfo() {
		ApiInfo apiInfo = new ApiInfo(
				"Coffee Machine Swagger",
				"Coffee Machine Swagger by the Hackathon 2017 am HHZ Boeblingen",
				"1.0",
				"Term of Service",
				new Contact("Services Computing HHZ's Students: Lee Nguepedja, Pascal Smidt and Adil",
						"https://github.com/Leedwing/msc-iot-coffeemashine-rewarding-system",
						"lee_edwing.nguepedja_tchwangnwou@reutlingen-university.de"),
						"Apache License Version 2.0",
						"https://www.apache.org/licenses/");
		
		return apiInfo;
	}
}

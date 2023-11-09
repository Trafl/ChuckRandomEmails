package com.example.demo.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ProblemDetail;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.media.StringSchema;

@Configuration
public class SwaggerConfig {

	@Bean
	OpenAPI config() {
		
	 return new OpenAPI()
				.info(new Info()
						.title("RandonChuckNorrisEmails-MS")
						.version("v1")
						.description("Microservice responsible for created user for chuck messages database"))
						.components(new Components()
			                    .addSchemas("ProblemDetail", new Schema<ProblemDetail>()
			                            .type("object")
			                            .addProperty("type", new StringSchema().example("https://chuck.com/errors/entity-not-found"))
			                            .addProperty("title", new StringSchema().example("Unregistered doctor"))
			                            .addProperty("status", new StringSchema().example(404))
			                            .addProperty("detail", new StringSchema().example("Doctor id 5 was not found"))
			                            .addProperty("timestamp", new StringSchema().example("2023-10-16T19:32:54.253417400Z"))
										));			
	
	}
}

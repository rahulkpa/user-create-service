package com.nirsb.account.configuration;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	public static final Contact DEFAULT_CONTACT = new Contact("Rahul Kumar Pandey", "https://www.linkedin.com/in/rahul-kumar-pandey-b22b6684/", "rahulkumarpandeycs068@gmail.com");
	public static final ApiInfo MY_API_INFO = new ApiInfo("Api Documentation", "Api Documentation", "1.0", "urn:tos",
	          DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");
	private static final Set<String> DEFAULT_API_OUTPUT_TYPE = new HashSet<String>(Arrays.asList("application/Json"
			));
	private static final Set<String> DEFAULT_API_INPUT_TYPE = new HashSet<String>(Arrays.asList("application/Json"
			));

	@Bean
	public Docket apiInfo() {
		return new Docket(DocumentationType.SWAGGER_2)
		.apiInfo(MY_API_INFO)
		.consumes(DEFAULT_API_INPUT_TYPE)
		.produces(DEFAULT_API_OUTPUT_TYPE);
	}
	
}

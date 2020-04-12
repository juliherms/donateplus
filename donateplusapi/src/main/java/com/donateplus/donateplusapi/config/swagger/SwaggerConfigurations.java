package com.donateplus.donateplusapi.config.swagger;

import java.util.Arrays;

import org.springframework.context.annotation.Configuration;

import com.donateplus.donateplusapi.model.User;

import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * This class responsible swagger configuration
 * @author j.a.vasconcelos
 *
 */
@Configuration
public class SwaggerConfigurations {

	public Docket donatePlusApi() {

		return new Docket(DocumentationType.SWAGGER_2).
				select()
				.apis(RequestHandlerSelectors.basePackage("com.donateplus.donateplusapi"))
				.paths(PathSelectors.ant("/**"))
				.build()
				.ignoredParameterTypes(User.class)
				.globalOperationParameters(
						Arrays.asList(new ParameterBuilder().name("Authorization")
								.description("Header para token JWT")
								.modelRef(new ModelRef("string"))
								.parameterType("header")
								.required(false).build()));

	}
}

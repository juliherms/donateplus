package com.donateplus.donateplusapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Class principal
 * @author j.a.vasconcelos
 *
 */
@SpringBootApplication
@EnableSpringDataWebSupport //allows pageable
@EnableCaching //allows cache
@EnableSwagger2 //allow Swagger
public class DonateplusapiApplication {
	
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(DonateplusapiApplication.class, args);
	}

}

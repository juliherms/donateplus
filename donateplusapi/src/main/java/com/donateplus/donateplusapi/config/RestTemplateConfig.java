package com.donateplus.donateplusapi.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Class responsible to configura restTemplate call Eureka Server
 * 
 * @author j.a.vasconcelos
 *
 */
//@Configuration
public class RestTemplateConfig {

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}

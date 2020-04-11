package com.donateplus.donateplusapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

/**
 * Class principal
 * @author j.a.vasconcelos
 *
 */
@SpringBootApplication
@EnableSpringDataWebSupport //allows pageable
@EnableCaching //allows cache
public class DonateplusapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DonateplusapiApplication.class, args);
	}

}

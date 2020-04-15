package com.donateplus.monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

/**
 * Application responsible to monitor microservices
 * 
 * @author j.a.vasconcelos
 *
 */
@Configuration
@EnableAutoConfiguration
@EnableAdminServer
public class DonateplusmonitorApplication {

	public static void main(String[] args) {
		SpringApplication.run(DonateplusmonitorApplication.class, args);
	}
}

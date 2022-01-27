package com.pm.PensionerDetailModule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PensionerDetailModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(PensionerDetailModuleApplication.class, args);
	}

}

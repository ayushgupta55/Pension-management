package com.pm.ProcessPensionModule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProcessPensionModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProcessPensionModuleApplication.class, args);
	}

}

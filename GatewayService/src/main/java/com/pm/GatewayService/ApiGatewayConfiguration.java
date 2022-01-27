package com.pm.GatewayService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;

@Configuration
public class ApiGatewayConfiguration {

	@Autowired
	AuthenticationFilter filter;

	@Bean
//	@CrossOrigin(origins = "http://localhost:4200/")
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p.path("/Pension/**").filters(f -> f.filter(filter))
						.uri("http://ayupensionerdetail-env.eba-k7mqfmjp.us-east-1.elasticbeanstalk.com/"))
				.route(p -> p.path("/Process/**").filters(f -> f.filter(filter)).uri("http://ayuprocesspension-env.eba-2wex9kkd.us-east-1.elasticbeanstalk.com/"))
				.route(p -> p.path("/jwt").filters(f -> f.filter(filter)).uri("http://ayujwt-env.eba-7rkmguj3.us-east-1.elasticbeanstalk.com/")).build();
	}

}
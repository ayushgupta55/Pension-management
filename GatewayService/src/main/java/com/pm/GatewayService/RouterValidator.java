package com.pm.GatewayService;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

@Component
public class RouterValidator {

	public static final List<String> openApiEndpoints = List("/authenticate");

	public Predicate<ServerHttpRequest> isSecured = request -> openApiEndpoints.stream()
			.noneMatch(uri -> request.getURI().getPath().contains(uri));

	private static List<String> List(String string) {
		// TODO Auto-generated method stub
		List<String> arr = new ArrayList<>();
		arr.add(string);
		return arr;
	}

}
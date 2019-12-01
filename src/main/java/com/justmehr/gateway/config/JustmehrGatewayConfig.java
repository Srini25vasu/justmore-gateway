package com.justmehr.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JustmehrGatewayConfig {

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		
		return builder.routes()
				    .route("r1",r->r.host("localhost")
				    		.and()
				    		.path("/api/courses")
				    		.uri("http://localhost/api/courses"))
				    .route(r -> r.host("**.baeldung.com")
				            .and()
				            .path("/myOtherRouting")
				            .filters(f -> f.prefixPath("/myPrefix"))
				            .uri("http://othersite.com")
				            .id("myOtherID"))
				.build();
				  
		
	}
}

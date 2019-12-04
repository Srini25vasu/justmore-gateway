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
				.route(r->r.path("/api/courses/**")
						.filters(f->f.rewritePath("/api/courses?page=0&&size=3", "${remains}")
								.addRequestHeader("x-first-header", "first-service-header"))
						.uri("lb://JUSTMEHR-COURSE-SERVICE")
						.id("justmehr-course-service"))
				.build();
				
				  
		
	}
}

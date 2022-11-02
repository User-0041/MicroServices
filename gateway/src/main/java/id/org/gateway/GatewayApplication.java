package id.org.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
	@Bean
	DiscoveryClientRouteDefinitionLocator dynamicRoutes(ReactiveDiscoveryClient rdc,
	DiscoveryLocatorProperties dlp ){
	return new DiscoveryClientRouteDefinitionLocator(rdc,dlp );
	}
	@Bean
	RouteLocator gatewayRoutes(RouteLocatorBuilder builder){
		return builder.routes()
			.route(predicateSpec -> predicateSpec.path("/muslimsalat/**")
					.filters(f->f
							.addRequestHeader("x-rapidapi-host","muslimsalat.p.rapidapi.com")
							.addRequestHeader("x-rapidapi-key", "928562e11fmsh0cf113f6f5bc4f7p112efajsn2e9714fe6da2")
							.rewritePath("/muslimsalat/(?<segment>.*)","/${segment}")

					)
					.uri("https://muslimsalat.p.rapidapi.com")
			)
			.route(predicateSpec -> predicateSpec.path("/calorieninjas/**")
					.filters(f->f
							.addRequestHeader("x-rapidapi-host","calorieninjas.p.rapidapi.com")
							.addRequestHeader("x-rapidapi-key", "928562e11fmsh0cf113f6f5bc4f7p112efajsn2e9714fe6da2")
							.addRequestParameter("query","tomato")
							.rewritePath("/nutrition(?<segment>.*)","/${segment}")

					)
					.uri("https://calorieninjas.p.rapidapi.com")
			)
			.build();
}

	

	
}

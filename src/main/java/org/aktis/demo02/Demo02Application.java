package org.aktis.demo02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

@SpringBootApplication
public class Demo02Application {

	@Bean
	RouterFunction<ServerResponse> routes() {
		return RouterFunctions
				.route(GET("/hi"), request -> ServerResponse.ok().body(Flux.just("Hi, world"), String.class))
				.andRoute(GET("/hello"), request -> ServerResponse.ok().body(Flux.just("Hello, world"), String.class));
	}

	public static void main(String[] args) {
		SpringApplication.run(Demo02Application.class, args);
	}
}

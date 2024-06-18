package com.busycoder.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

import java.time.Duration;
import java.time.LocalDateTime;

@Configuration
public class RouteConfig {
    @Bean
    public RouteLocator busycoderRouteConfig(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
//                .route(p -> p
//                        .path("/busycoder/accounts/**")
//                        .filters( f -> f.rewritePath("/busycoder/accounts/(?<segment>.*)","/${segment}")
//                                .addResponseHeader("X-Response-Time", LocalDateTime.now().toString())
//                               )
//                        .uri("lb://ACCOUNTS"))
                .route(p -> p
                        .path("/busycoder/accounts/**")
                        .filters( f -> f.rewritePath("/busycoder/accounts/(?<segment>.*)","/${segment}")
                                .addResponseHeader("X-Response-Time", LocalDateTime.now().toString())
                                .circuitBreaker(config -> config.setName("accountCircuitBreaker")
                                        .setFallbackUri("forward:/contactSupport")))
                        .uri("lb://ACCOUNTS"))
//                .route(p -> p
//                        .path("/busycoder/loans/**")
//                        .filters( f -> f.rewritePath("/busycoder/loans/(?<segment>.*)","/${segment}")
//                                .addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
//                        .uri("lb://LOANS"))
                .route(p -> p
                        .path("/busycoder/loans/**")
                        .filters( f -> f.rewritePath("/busycoder/loans/(?<segment>.*)","/${segment}")
                                .addResponseHeader("X-Response-Time", LocalDateTime.now().toString())
                                .retry(retryConfig -> retryConfig.setRetries(3)
                                        .setMethods(HttpMethod.GET)
                                        .setBackoff(Duration.ofMillis(100),Duration.ofMillis(1000),2,true)))
                        .uri("lb://LOANS"))
                .route(p -> p
                        .path("/busycoder/cards/**")
                        .filters( f -> f.rewritePath("/busycoder/cards/(?<segment>.*)","/${segment}")
                                .addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
                        .uri("lb://CARDS")).build();
    }
}

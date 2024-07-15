package com.busycoder.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class AppRouteConfig {

    @Bean
    public RouteLocator busycoderRouteConfig(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                .route(p -> p
                        .path("/busycoder/accounts/**")
                        .filters( f -> f.rewritePath("/busycoder/accounts/(?<segment>.*)","/${segment}")
                                .addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
                        .uri("lb://ACCOUNTS"))
                .route(p -> p
                        .path("/busycoder/loans/**")
                        .filters( f -> f.rewritePath("/busycoder/loans/(?<segment>.*)","/${segment}")
                                .addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
                        .uri("lb://LOANS"))
                .route(p -> p
                        .path("/busycoder/cards/**")
                        .filters( f -> f.rewritePath("/busycoder/cards/(?<segment>.*)","/${segment}")
                                .addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
                        .uri("lb://CARDS")).build();
    }
//    @Bean
//    public RouteLocator busycoderRouteConfig(RouteLocatorBuilder routeLocatorBuilder){
//        return routeLocatorBuilder.routes()
//                .route(p->p.path("/busycoder/accounts/**")
//                        .filters(f -> f.rewritePath("/busycoder/accounts/(?<segment>.*)","/${segment)"))
//                        .uri("lb://ACCOUNTS"))
//                .route(p->p.path("/busycoder/loans/**")
//                        .filters(f -> f.rewritePath("/busycoder/accounts/(?<segment>.*)","/${segment)"))
//                        .uri("lb://LOANS"))
//                .route(p->p.path("/busycoder/cards/**")
//                        .filters(f -> f.rewritePath("/busycoder/accounts/(?<segment>.*)","/${segment)"))
//                        .uri("lb://CARDS"))
//                .build();
//    }
}

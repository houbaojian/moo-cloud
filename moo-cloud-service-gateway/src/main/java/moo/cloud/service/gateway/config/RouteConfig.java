package moo.cloud.service.gateway.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.gateway.filter.factory.StripPrefixGatewayFilterFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

/**
 * 路由配置
 *
 * @author houbj
 * @date 2019/11/26 15:27
 */
@Slf4j
@EnableAutoConfiguration
@Configuration
@ComponentScan("moo.cloud.service.gateway.config")
public class RouteConfig {
    @Autowired
    private StripPrefixGatewayFilterFactory stripPrefixGatewayFilterFactory;

    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder builder) {
        log.info("【moo】正在加载网关路由信息...");
        return builder.routes()
//                .route(p -> p
//                        .path("/httpbin/**")
//                        .filters(f -> f.filters(stripPrefixGatewayFilterFactory
//                                .apply(c -> c.setParts(1))))
//                        .uri("http://httpbin.org:80")
//                )
//                .route("data-post", p -> p
//                        .path("/DATA/**").and().method(HttpMethod.POST)
//                       .uri("lb://data")
//                )
//                .route("data-get", p -> p
//                        .path("/DATA/**").and().method(HttpMethod.GET)
//                       .uri("lb://data")
//                )
                .route(r -> r.path("/AUTH/**").uri("lb://auth"))
                .route(r -> r.path("/DATA/**").uri("lb://data"))
                .build();
    }
}
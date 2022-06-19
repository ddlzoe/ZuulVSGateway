package com.joe.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Map;

import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.GATEWAY_ROUTE_ATTR;

@Component
public class WebFilter implements GlobalFilter, Ordered {

    private static Logger logger = LoggerFactory.getLogger(WebFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.info("Inner ...");
        Route route = exchange.getAttribute(GATEWAY_ROUTE_ATTR);
        Map<String, Object> metaDatas = route.getMetadata();
        metaDatas.forEach((key, value) -> {
            logger.info("Key: {}, Value: {}", key, value);
        });
        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            logger.info("Outter ...");
        }));
    }

    @Override
    public int getOrder() {
        return 0;
    }
}

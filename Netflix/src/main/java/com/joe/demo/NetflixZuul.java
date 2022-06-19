package com.joe.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class NetflixZuul {
    public static void main(String[] args) {
        SpringApplication.run(NetflixZuul.class, args);
    }
}

package com.joe.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@SpringBootApplication
@RestController
public class BackendService {

    private static Logger logger = LoggerFactory.getLogger(BackendService.class);

    public static void main(String[] args) {
        SpringApplication.run(BackendService.class, args);
    }

    @GetMapping("/getWithLatency")
    public String latency() throws InterruptedException {
        logger.info("Get with Latency.");
        Thread.sleep(10 * 1000);
        Date date = new Date();
        return String.valueOf(date.getTime());
    }

    @GetMapping("/getWithLatency30")
    public String latency30() throws InterruptedException {
        logger.info("Get with Latency.");
        Thread.sleep(30 * 1000);
        Date date = new Date();
        return String.valueOf(date.getTime());
    }

    @GetMapping("/getWithoutLatency")
    public String noLatency() throws InterruptedException {
        Date date = new Date();
        return String.valueOf(date.getTime());
    }
}

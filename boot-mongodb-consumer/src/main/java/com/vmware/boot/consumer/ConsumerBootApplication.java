package com.vmware.boot.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.log4j.Log4j2;

@SpringBootApplication
@Log4j2
public class ConsumerBootApplication {

    public static void main(String[] args) {
        log.info("Start main() method in ConsumerBootApplication.class");
        SpringApplication.run(ConsumerBootApplication.class, args);
        log.info("End main() method in ConsumerBootApplication.class");
    }
}

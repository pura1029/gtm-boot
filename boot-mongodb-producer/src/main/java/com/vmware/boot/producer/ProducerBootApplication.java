package com.vmware.boot.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.log4j.Log4j2;

@SpringBootApplication
@Log4j2
public class ProducerBootApplication {

    public static void main(String[] args) {
        log.info("Start main() method in ProducerBootApplication.class");
        SpringApplication.run(ProducerBootApplication.class, args);
        log.info("End main() method in ProducerBootApplication.class");
    }
}

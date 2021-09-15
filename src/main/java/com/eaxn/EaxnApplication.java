package com.eaxn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import me.ehp246.aufjms.api.annotation.EnableByJms;

/**
 * @author Lei Yang
 *
 */
@EnableByJms
@SpringBootApplication
public class EaxnApplication {
    public static void main(String[] args) {
        SpringApplication.run(EaxnApplication.class, args);
    }
}

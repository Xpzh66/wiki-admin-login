/*
 * Name: Guanzhang He
 * Student ID: S1580804
 * BIT235 Assessment 2 - Part A: Wiki Administrator Login and User Authentication
 */
package com.bit235.wiki;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point of the Spring Boot web application.
 * @SpringBootApplication enables auto-configuration, component scanning
 * (controller / service / repository packages under com.bit235.wiki)
 * and the embedded web server.
 */
@SpringBootApplication
public class WikiApplication {

    public static void main(String[] args) {
        // Bootstrap the Spring application context and start Tomcat
        SpringApplication.run(WikiApplication.class, args);
    }
}

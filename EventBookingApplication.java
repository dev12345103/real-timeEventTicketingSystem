package com.eventbooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EventBookingApplication {
    public static void main(String[] args) {
        SpringApplication.run(EventBookingApplication.class, args);
        System.out.println("\nBackend development for the event ticketing system is running...");
    }
}
package com.book;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;

@SpringBootApplication
public class StartBookApplication {

    // start everything
    public static void main(String[] args) {
        SpringApplication.run(StartBookApplication.class, args);
    }

    @Profile("demo")
    @Bean
    CommandLineRunner initDatabase(BookRepository repository) {
        return args -> {
            repository.save(new Book("Four Illusions", "Chandrakirti", new BigDecimal("18.71")));
            repository.save(new Book("The Psychology of Money", "Morgan Housel", new BigDecimal("19.53")));
            repository.save(new Book("Asura: Tale of the Vanquished", "Anand Neelkantan", new BigDecimal("7.50")));
        };
    }
}
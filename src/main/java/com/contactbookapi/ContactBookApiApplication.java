package com.contactbookapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com"})
public class ContactBookApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContactBookApiApplication.class, args);
    }

}

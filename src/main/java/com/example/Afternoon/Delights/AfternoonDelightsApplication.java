package com.example.Afternoon.Delights;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class AfternoonDelightsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AfternoonDelightsApplication.class, args);
	}

}

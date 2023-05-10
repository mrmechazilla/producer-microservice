package com.example.producermicroservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.ScheduledExecutorService;

@SpringBootApplication
public class ProducerMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProducerMicroserviceApplication.class, args);
	}


}

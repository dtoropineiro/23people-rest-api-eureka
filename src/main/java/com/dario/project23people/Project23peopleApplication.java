package com.dario.project23people;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


@SpringBootApplication
@EnableDiscoveryClient
//@EnableZuulProxy
public class Project23peopleApplication {

	public static void main(String[] args) {
		SpringApplication.run(Project23peopleApplication.class, args);
	}

}

package com.example.demo;

import com.example.demo.repositories.FeedRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = { FeedRepository.class})
@ComponentScan(basePackages = {"com.example.demo"})
public class  DeveloperCommunityApp1Application{

	public static void main(String[] args) {
		SpringApplication.run(DeveloperCommunityApp1Application.class, args);
		System.out.println("Hello");
	}

}


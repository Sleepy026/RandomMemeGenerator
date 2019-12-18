package com.codecool.imagegenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ImageGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImageGeneratorApplication.class, args);
	}

}

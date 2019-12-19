package com.codecool.memestore;

import com.codecool.memestore.model.Meme;
import com.codecool.memestore.service.MemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
public class MemeStoreApplication {

    @Autowired
    private MemeService memeService;

    public static void main(String[] args) {
        SpringApplication.run(MemeStoreApplication.class, args);
    }

    @Bean
    public CommandLineRunner init() {
        return args -> {
            Meme meme1 = Meme.builder()
                    .url("https://i.imgflip.com/3jd2vv.jpg")
                    .upVote(10)
                    .downVote(1)
                    .build();

            memeService.save(meme1);

            Meme meme2 = Meme.builder()
                    .url("https://i.imgflip.com/3jd2vv.jpg")
                    .upVote(100)
                    .downVote(1)
                    .build();

            memeService.save(meme2);

            Meme meme3 = Meme.builder()
                    .url("https://i.imgflip.com/3jd2vv.jpg")
                    .upVote(80)
                    .downVote(1)
                    .build();

            memeService.save(meme3);
        };
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();

    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

package com.codecool.textgenerator;

import com.codecool.textgenerator.model.MemeText;
import com.codecool.textgenerator.repository.MemeTextRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableEurekaClient
@EnableSwagger2
@SpringBootApplication
public class TextGeneratorApplication {

    @Autowired
    private MemeTextRepository memeTextRepository;

    public static void main(String[] args) {
        SpringApplication.run(TextGeneratorApplication.class, args);
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
    public CommandLineRunner init(){
        return args -> {
            MemeText text1 = MemeText.builder()
                    .value("Bottom text")
                    .build();
            memeTextRepository.save(text1);
            MemeText text2 = MemeText.builder()
                    .value("Sample text")
                    .build();
            memeTextRepository.saveAndFlush(text2);
            MemeText text3 = MemeText.builder()
                    .value("Top text")
                    .build();
            memeTextRepository.saveAndFlush(text3);
            MemeText text4 = MemeText.builder()
                    .value("Ok boomer")
                    .build();
            memeTextRepository.saveAndFlush(text4);
            MemeText text5 = MemeText.builder()
                    .value("Miau")
                    .build();
            memeTextRepository.saveAndFlush(text5);
            MemeText text6 = MemeText.builder()
                    .value("You have never watched a full movie because you blinked.")
                    .build();
            memeTextRepository.saveAndFlush(text6);

        };
    }
}

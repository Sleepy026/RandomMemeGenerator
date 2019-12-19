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
                    .text0("Bottom")
                    .text1("text")
                    .build();
            memeTextRepository.save(text1);
            MemeText text2 = MemeText.builder()
                    .text0("Sample")
                    .text1("text")
                    .build();
            memeTextRepository.saveAndFlush(text2);
            MemeText text3 = MemeText.builder()
                    .text0("Top")
                    .text1("text")
                    .build();
            memeTextRepository.saveAndFlush(text3);
            MemeText text4 = MemeText.builder()
                    .text0("Ok")
                    .text1("boomer")
                    .build();
            memeTextRepository.saveAndFlush(text4);
            MemeText text5 = MemeText.builder()
                    .text0("Miau")
                    .text1("Miau")
                    .build();
            memeTextRepository.saveAndFlush(text5);
            MemeText text6 = MemeText.builder()
                    .text0("You have never watched a full movie")
                    .text1("because you blinked.")
                    .build();
            memeTextRepository.saveAndFlush(text6);
            MemeText text7 = MemeText.builder()
                    .text0("So far...")
                    .text1("So good!")
                    .build();
            memeTextRepository.saveAndFlush(text7);
            MemeText text8 = MemeText.builder()
                    .text0("IGHT IMMA")
                    .text1("HEAD OUT")
                    .build();
            memeTextRepository.saveAndFlush(text8);
            MemeText text9 = MemeText.builder()
                    .text0("Run as admin")
                    .text1("Sudo")
                    .build();
            memeTextRepository.saveAndFlush(text9);
            MemeText text10 = MemeText.builder()
                    .text0("I bet he is thinking about other women")
                    .text1("Words more words")
                    .build();
            memeTextRepository.saveAndFlush(text10);

        };
    }
}

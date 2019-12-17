package com.codecool.imagegenerator.controller;

import com.codecool.imagegenerator.model.Image;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ImageControllerTest {

    @Autowired
    private ImageController imageController;

    @Test
    @RepeatedTest(10)
    void getImage_ReturnsValidImage() {
        Image result = imageController.getImage();

        assertThat(result.getTemplate_id()!=null);
        assertThat(result.getUrl()!=null);
    }
}

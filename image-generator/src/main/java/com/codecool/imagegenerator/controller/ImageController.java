package com.codecool.imagegenerator.controller;

import com.codecool.imagegenerator.model.Image;
import com.codecool.imagegenerator.service.ImageProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
public class ImageController {

    @Autowired
    private ImageProviderService imageProviderService;

    @GetMapping("/")
    public Image getImage() {
        return imageProviderService.getRandomImage();
    }

}

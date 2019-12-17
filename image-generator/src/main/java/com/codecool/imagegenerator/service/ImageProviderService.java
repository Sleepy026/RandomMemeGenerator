package com.codecool.imagegenerator.service;

import org.springframework.stereotype.Service;

@Service
public class ImageProviderService {

    public String getRandomImageUrl() {
        return "https://imgflip.com/s/meme/Roll-Safe-Think-About-It.jpg";
    }

}

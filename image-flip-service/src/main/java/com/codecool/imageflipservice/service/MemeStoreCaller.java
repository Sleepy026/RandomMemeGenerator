package com.codecool.imageflipservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MemeStoreCaller {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${memestore.url}")
    private String memeStorageURL;

    public String saveMeme(String imageURL){
        return restTemplate.postForEntity(
                memeStorageURL,
                imageURL,
                String.class
        ).getBody();
    }
}

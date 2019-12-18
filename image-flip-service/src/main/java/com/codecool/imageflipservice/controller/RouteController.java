package com.codecool.imageflipservice.controller;

import com.codecool.imageflipservice.model.RequestMemeModel;
import com.codecool.imageflipservice.service.ImageFlipCaller;
import com.codecool.imageflipservice.service.MemeStoreCaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RouteController {

    @Autowired
    private MemeStoreCaller memeStoreCaller;
    @Autowired
    private ImageFlipCaller imageFlipCaller;

    @PostMapping("/image-flip")
    public String createMeme(@RequestBody RequestMemeModel requestMemeModel){

        String imageURL = imageFlipCaller.sendDataToImageFlip(requestMemeModel);
        String stringResponseEntity = memeStoreCaller.saveMeme(imageURL);

        return stringResponseEntity;

    }

}

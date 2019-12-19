package com.codecool.imageflipservice.controller;

import com.codecool.imageflipservice.model.generatedmodel.ResponseModel;
import com.codecool.imageflipservice.model.RequestMemeModel;
import com.codecool.imageflipservice.service.ImageFlipCaller;
import com.codecool.imageflipservice.service.MemeStoreCaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class RouteController {

    @Autowired
    private MemeStoreCaller memeStoreCaller;
    @Autowired
    private ImageFlipCaller imageFlipCaller;

    @PostMapping("/")
    public String createMeme(@RequestBody RequestMemeModel requestMemeModel){
        ResponseModel imageURL = imageFlipCaller.sendDataToImageFlip(requestMemeModel);
        return memeStoreCaller.saveMeme(imageURL.getDataModel().getUrl());

    }

    @GetMapping("/teszt")
    public String teszt(){
        return "success";
    }

}

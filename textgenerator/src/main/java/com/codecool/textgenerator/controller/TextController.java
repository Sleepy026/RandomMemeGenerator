package com.codecool.textgenerator.controller;

import com.codecool.textgenerator.model.MemeText;
import com.codecool.textgenerator.service.DataManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/text-generator")
public class TextController {

    @Autowired
    private DataManager dataManager;

    @GetMapping("/random-text")
    public List<MemeText> getRandomText(){
        return dataManager.getRandomTexts();
    }

}

package com.codecool.textgenerator.controller;

import com.codecool.textgenerator.service.DataManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class TextController {

    @Autowired
    private DataManager dataManager;

    @GetMapping("/get-generated-text")
    public List<String> getGeneratedText(){
        return dataManager.getGeneratedText();
    }

}

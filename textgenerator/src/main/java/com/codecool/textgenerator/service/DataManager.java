package com.codecool.textgenerator.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class DataManager {

    @GetMapping("/get-generated-text")
    public List<String> getGeneratedText() {
        return List.of("Bottom text","Top text","Ok Boomer","bOtTom tExT");
    }
}

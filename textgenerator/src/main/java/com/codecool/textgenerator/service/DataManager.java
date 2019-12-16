package com.codecool.textgenerator.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataManager {

    public List<String> getGeneratedText() {
        return List.of("Bottom text","Top text");
    }
}

package com.codecool.textgenerator.service;

import com.codecool.textgenerator.model.MemeText;
import com.codecool.textgenerator.repository.MemeTextRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DataManager {

    @Autowired
    private MemeTextRepository memeTextRepository;

    public List<MemeText> getRandomTexts() {
        List<MemeText> randomTexts = memeTextRepository.findAll();
        Collections.shuffle(randomTexts);
        List<MemeText> result = new ArrayList<>();
        result.add(randomTexts.get(0));
        result.add(randomTexts.get(1));
        result.add(randomTexts.get(2));
        result.add(randomTexts.get(3));
        return result;
    }
}

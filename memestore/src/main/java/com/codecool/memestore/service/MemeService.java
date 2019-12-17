package com.codecool.memestore.service;

import com.codecool.memestore.model.Meme;
import com.codecool.memestore.repository.MemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemeService {

    @Autowired
    private MemeRepository memeRepository;

    public void save(Meme meme) {
        memeRepository.save(meme);
    }
}

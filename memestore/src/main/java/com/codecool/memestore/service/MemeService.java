package com.codecool.memestore.service;

import com.codecool.memestore.model.Meme;
import com.codecool.memestore.repository.MemeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MemeService {

    @Autowired
    private MemeRepository memeRepository;

    public void save(Meme meme) {
        memeRepository.save(meme);
    }

    public List<Meme> getLeaderBoard() {
        return memeRepository.findAllByOrderByUpVoteDesc();
    }

    public void upVote(Long memeId) {
        Meme meme = memeRepository.findById(memeId).get();
        meme.setUpVote(meme.getUpVote() + 1);
        save(meme);
    }

    public void downVote(Long memeId) {
        Meme meme = memeRepository.findById(memeId).get();
        meme.setDownVote(meme.getDownVote() + 1);
        save(meme);
    }

    public void createMeme(String url) {
        save(Meme.builder()
                .url(url)
                .upVote(0)
                .downVote(0)
                .build());
    }
}

package com.codecool.memestore.controller;

import com.codecool.memestore.model.Meme;
import com.codecool.memestore.service.MemeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin
public class MemeController {

    @Autowired
    private MemeService memeService;

    @GetMapping("/leader-board")
    public List<Meme> getLeaderBoard() {
        return memeService.getLeaderBoard();
    }

    @GetMapping("/up-vote/{memeId}")
    public void upVote(@PathVariable("memeId") long memeId) {
        memeService.upVote(memeId);
    }

    @GetMapping("/down-vote/{memeId}")
    public void downVote(@PathVariable("memeId") long memeId) {
        memeService.downVote(memeId);
    }

    @PostMapping("/save-meme")
    public ResponseEntity createMeme(@RequestBody String url) {
        memeService.createMeme(url);
        return new ResponseEntity<>("Meme saved", HttpStatus.OK);
    }
}

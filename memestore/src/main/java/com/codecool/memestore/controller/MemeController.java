package com.codecool.memestore.controller;

import com.codecool.memestore.model.Meme;
import com.codecool.memestore.service.MemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class MemeController {

    @Autowired
    private MemeService memeService;

    @GetMapping
    public String test() {
        return "test";
    }

    @GetMapping("/leader-board")
    public List<Meme> getLeaderBoard(){
        return memeService.getLeaderBoard();
    }
}

package com.codecool.imageflipservice.controller;

import com.codecool.imageflipservice.model.RequestMemeModel;
import com.codecool.imageflipservice.model.ResponseImageFlipModel;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/")
public class RouteController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${imageflip.username}")
    private String username;
    @Value("${imageflip.password}")
    private String password;
    @Value("${memestore.url}")
    private String url;

    @PostMapping("/image-flip")
    public void createMeme(@RequestBody RequestMemeModel requestMemeModel){

        JSONObject requestData = new JSONObject();
        requestData.put("text0", requestMemeModel.getText());
        requestData.put("template_id", requestMemeModel.getTemplateId());
        requestData.put("password", password);
        requestData.put("username", username);

        ResponseEntity<ResponseImageFlipModel> response = restTemplate.postForEntity(
                "https://api.imgflip.com/caption_image",
                requestData,
                ResponseImageFlipModel.class
                );

        String imageURL = response.getBody().getResponseDataContent().getUrl();


    }

}

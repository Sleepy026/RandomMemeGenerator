package com.codecool.imageflipservice.service;

import com.codecool.imageflipservice.model.RequestMemeModel;
import com.codecool.imageflipservice.model.ResponseImageFlipModel;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ImageFlipCaller {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${imageflip.username}")
    private String username;
    @Value("${imageflip.password}")
    private String password;


    public String sendDataToImageFlip(RequestMemeModel requestMemeModel) {
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

        return response.getBody().getResponseDataContent().getUrl();
    }
}

package com.codecool.imageflipservice.service;

import com.codecool.imageflipservice.model.generatedmodel.ResponseModel;
import com.codecool.imageflipservice.model.RequestMemeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestTemplate;

@Service
@CrossOrigin
public class ImageFlipCaller {

    @Autowired
    private RestTemplate externalRestTemplate;

    @Value("${imageflip.username}")
    private String username;

    @Value("${imageflip.password}")
    private String password;


    public ResponseModel sendDataToImageFlip(RequestMemeModel requestMemeModel) {

        MultiValueMap<String, String> requestData = new LinkedMultiValueMap<>();
        requestData.add("template_id", requestMemeModel.getTemplateId());
        requestData.add("username", username);
        requestData.add("password", password);
        requestData.add("text0", requestMemeModel.getText0());
        requestData.add("text0", requestMemeModel.getText1());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> flip = new HttpEntity<>(requestData, headers);

        ResponseModel responseModel = externalRestTemplate.postForEntity(
                "https://api.imgflip.com/caption_image",
                flip,
                ResponseModel.class
        ).getBody();


        return responseModel;
    }
}

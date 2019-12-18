package com.codecool.imageflipservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseImageFlipModel {

    private boolean success;
    private ResponseDataContent responseDataContent;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public class ResponseDataContent {

        private String url;
        private String page_url;
    }


}



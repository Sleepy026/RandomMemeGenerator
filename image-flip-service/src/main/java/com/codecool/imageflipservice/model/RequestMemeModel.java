package com.codecool.imageflipservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestMemeModel {

    private String templateId;
    private String text0;
    private String text1;

}

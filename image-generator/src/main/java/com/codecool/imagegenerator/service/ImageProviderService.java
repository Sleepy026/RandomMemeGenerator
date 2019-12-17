package com.codecool.imagegenerator.service;

import org.springframework.stereotype.Service;

import java.util.*;

import static java.util.Map.entry;

@Service
public class ImageProviderService {

    private final static String baseUrl = "https://imgflip.com/s/meme/";

    private final static Map<String, String> templates = Map.ofEntries(
            entry("61579", "One-Does-Not-Simply"),
            entry("100947", "What-If-I-Told-You"),
            entry("129242436", "Change-My-Mind"),
            entry("438680", "Batman-Slapping-Robin"),
            entry("114585149", "Inhaling-Seagull"),
            entry("718432", "Back-In-My-Day")
    );

    private final List<String> templateKeys = new ArrayList<>(templates.keySet());

    public String getRandomTemplateKey() {
        Collections.shuffle(templateKeys, new Random());
        return templateKeys.get(0);
    }

    public String getRandomImage() {
        return templates.get(getRandomTemplateKey());
    }
}

package com.codecool.imagegenerator.service;

import com.codecool.imagegenerator.model.Image;
import org.springframework.stereotype.Service;

import java.util.*;

import static java.util.Map.entry;

@Service
public class ImageProviderService {

    private final static String baseUrl = "https://imgflip.com/s/meme/";

    private final static Map<String, String> templates = Map.ofEntries(
            entry("61579", "One-Does-Not-Simply"),
            entry("129242436", "Change-My-Mind"),
            entry("438680", "Batman-Slapping-Robin"),
            entry("114585149", "Inhaling-Seagull"),
            entry("27813981", "Hide-the-Pain-Harold"),
            entry("91545132", "Trump-Bill-Signing"),
            entry("718432", "Back-In-My-Day")
    );

    private final List<String> templateKeys = new ArrayList<>(templates.keySet());

    public String getRandomTemplateKey() {
        Collections.shuffle(templateKeys, new Random());
        return templateKeys.get(0);
    }

    public Image getRandomImage() {
        String resultKey = getRandomTemplateKey();
        String resultUrl = baseUrl + templates.get(resultKey) + ".jpg";
        return Image.builder().template_id(resultKey).url(resultUrl).build();
    }
}

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
            entry("87743020", "Two-Buttons"),
            entry("129242436", "Change-My-Mind"),
            entry("438680", "Batman-Slapping-Robin"),
            entry("114585149", "Inhaling-Seagull"),
            entry("27813981", "Hide-the-Pain-Harold"),
            entry("91545132", "Trump-Bill-Signing"),
            entry("155067746", "Surprised-Pikachu"),
            entry("119139145", "Blank-Nut-Button"),
            entry("178591752", "Tuxedo-Winnie-The-Pooh"),
            entry("188390779", "Woman-Yelling-At-Cat"),
            entry("132769734", "Hard-To-Swallow-Pills"),
            entry("123999232", "The-Scroll-Of-Truth"),
            entry("184801100", "Me-And-The-Boys"),
            entry("101287", "Third-World-Success-Kid"),
            entry("99683372", "Sleeping-Shaq"),
            entry("101910402", "Who Would Win?"),
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

package com.example.personaltrainer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionnaireApi {

    @GetMapping("/kwestionariusz")
    public String getQuestionnaire(){
        return "Witaj to kwestionariusz";
    }
}

package com.example.personaltrainer.questionnaire;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class QuestionnaireAdminController {

    @GetMapping
    public String adminHello() {
        return "admin";
    }
}

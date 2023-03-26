package com.example.personaltrainer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuestionnaireController {


    private final QuestionnaireService questionnaireService;

    public QuestionnaireController(QuestionnaireService questionnaireService) {
        this.questionnaireService = questionnaireService;
    }

    @GetMapping("/kwestionariusz")
    public String getQuestionnaire(Model model) {

        model.addAttribute("questions", questionnaireService.getQuestions());
        return "questionnaire";
    }

}

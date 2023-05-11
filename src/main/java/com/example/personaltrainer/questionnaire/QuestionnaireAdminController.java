package com.example.personaltrainer.questionnaire;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class QuestionnaireAdminController {

    private final QuestionnaireService questionnaireService;

    public QuestionnaireAdminController(QuestionnaireService questionnaireService) {
        this.questionnaireService = questionnaireService;
    }

    @GetMapping
    public String adminHello() {
        return "admin";
    }

    @GetMapping("/kwestionariusz/edit")
    public String editQuestionnaire(Model model) {
        model.addAttribute("questions", questionnaireService.getQuestions());
        return "admin-questionnaire-edit";
    }
}

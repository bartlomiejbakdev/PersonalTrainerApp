package com.example.personaltrainer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping("/kwestionariusz")
public class QuestionnaireController {


    private final QuestionnaireService questionnaireService;

    public QuestionnaireController(QuestionnaireService questionnaireService) {
        this.questionnaireService = questionnaireService;
    }

    @GetMapping()
    public String getQuestionnaire(Model model) {

        model.addAttribute("questions", questionnaireService.getQuestions());
        return "questionnaire";
    }

    @PostMapping()
    public String submit(@ModelAttribute QuestionsDto questionsDto) throws IOException {

        questionnaireService.generateDocument(questionsDto);
        return "redirect:/kwestionariusz";
    }
}
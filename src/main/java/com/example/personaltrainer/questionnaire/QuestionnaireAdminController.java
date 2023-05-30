package com.example.personaltrainer.questionnaire;

import com.example.personaltrainer.questionnaire.entity.Question;
import com.example.personaltrainer.questionnaire.enums.AnswerType;
import com.example.personaltrainer.questionnaire.repository.QuestionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class QuestionnaireAdminController {

    private final QuestionnaireService questionnaireService;
    private final QuestionRepository questionRepository;

    public QuestionnaireAdminController(QuestionnaireService questionnaireService, QuestionRepository questionRepository) {
        this.questionnaireService = questionnaireService;
        this.questionRepository = questionRepository;
    }

    @GetMapping
    public String adminHello() {
        return "admin";
    }

    @GetMapping("/kwestionariusz")
    public String editQuestionnaire(Model model) {
        model.addAttribute("questions", questionnaireService.getQuestions());
        model.addAttribute("newQuestion", new Question());
        return "admin-questionnaire";
    }

    @PostMapping("/kwestionariusz/add-question")
    public String addQuestion(@ModelAttribute Question question){
        question.setAnswerType(AnswerType.TEXT);
        questionRepository.save(question);
        return "redirect:/admin/kwestionariusz";
    }
}

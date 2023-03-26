package com.example.personaltrainer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.mail.MessagingException;
import java.io.IOException;

@Controller
@RequestMapping("/kwestionariusz")
public class QuestionnaireController {


    private final QuestionnaireService questionnaireService;
    private final EmailService emailService;

    public QuestionnaireController(QuestionnaireService questionnaireService, EmailService emailService) {
        this.questionnaireService = questionnaireService;
        this.emailService = emailService;
    }

    @GetMapping()
    public String getQuestionnaire(Model model) {

        model.addAttribute("questions", questionnaireService.getQuestions());
        return "questionnaire";
    }

    @PostMapping()
    public String submit(@ModelAttribute QuestionsDto questionsDto) throws IOException, MessagingException, jakarta.mail.MessagingException {

        questionnaireService.generateDocument(questionsDto);
        emailService.sendEmailWithAttachment("barbak43@wp.pl", questionsDto.getQuestionList().get(0).answer,
                "Kwestionariusz wypełniony przez: " + questionsDto.getQuestionList().get(0).answer + " znajduję się w załączniku",
                "src/main/resources/questionnaires/" + questionsDto.getQuestionList().get(0).answer + ".docx");

        return "redirect:/kwestionariusz";
    }
}
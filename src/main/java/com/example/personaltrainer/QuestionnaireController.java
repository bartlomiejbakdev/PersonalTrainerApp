package com.example.personaltrainer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @GetMapping("/thankyou")
    public String getThanksYou() {
        return "thank-you";
    }

    @PostMapping()
    public String submit(@ModelAttribute QuestionsDto questionsDto) throws jakarta.mail.MessagingException {

        String sentTo = "barbak43@wp.pl";
        String subject = emailService.generateSubject(questionsDto);
        String message = emailService.generateMessage(questionsDto);

        emailService.sendEmailWithAttachment(sentTo, subject, message);

        return "redirect:/kwestionariusz/thankyou";
    }
}
package com.example.personaltrainer.questionnaire;

import com.example.personaltrainer.core.EmailService;
import com.example.personaltrainer.questionnaire.model.AnswerDto;
import com.example.personaltrainer.questionnaire.model.QuestionsDto;
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

        QuestionsDto questionsDto = questionnaireService.getQuestions();
        AnswerDto answerDto = questionnaireService.getAnswers(questionsDto.getQuestionList());


        model.addAttribute("questions", questionsDto);
        model.addAttribute("answers", answerDto);
        return "questionnaire";
    }

    @GetMapping("/thankyou")
    public String getThanksYou() {
        return "thank-you";
    }

    @PostMapping()
    public String submit(@ModelAttribute AnswerDto answerDto) throws jakarta.mail.MessagingException {

        System.out.println(answerDto);

//        String sentTo = "barbak43@wp.pl";
//        String subject = emailService.generateSubject(questionsDto);
//        String message = emailService.generateMessage(questionsDto);
//
//        emailService.sendEmailWithAttachment(sentTo, subject, message);

        return "redirect:/kwestionariusz/thankyou";
    }
}
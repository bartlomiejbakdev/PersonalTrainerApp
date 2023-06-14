package com.example.personaltrainer.core;

import com.example.personaltrainer.questionnaire.entity.Answer;
import com.example.personaltrainer.questionnaire.entity.Question;
import com.example.personaltrainer.questionnaire.model.QuestionsDto;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmailWithAttachment(String sentTo, String subject, String text) throws jakarta.mail.MessagingException {
        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(sentTo);
        helper.setSubject(subject);
        helper.setText(text, true);

        mailSender.send(message);
    }

    public String generateSubject(QuestionsDto questionsDto) {
        return "[PersonalTrainerApp] Kwestionariusz wypełniony przez: " + questionsDto.getQuestionList().get(0).answerList.get(0).text;
    }

    public String generateMessage(QuestionsDto questionsDto) {

        StringBuilder message = new StringBuilder();

        for (Question question : questionsDto.getQuestionList()) {

            message.append("<b>").append(question.text).append("</b>");
            message.append("<br />");

            for (Answer answer : question.answerList) {
                if (answer.questionText != null) {
                    message.append(answer.questionText);
                    message.append("<br />");
                }
                message.append(answer.text);
                message.append("<br />");

            }
            message.append("<br />");
        }

        return message.toString();
    }
}

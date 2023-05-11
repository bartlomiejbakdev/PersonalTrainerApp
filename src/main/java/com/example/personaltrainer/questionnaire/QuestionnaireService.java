package com.example.personaltrainer.questionnaire;

import com.example.personaltrainer.questionnaire.entity.Answer;
import com.example.personaltrainer.questionnaire.entity.Question;
import com.example.personaltrainer.questionnaire.enums.AnswerType;
import com.example.personaltrainer.questionnaire.model.QuestionsDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionnaireService {


    public QuestionsDto getQuestions() {

        List<Question> questions = new ArrayList<>();

        questions.add(new Question("Jak się nazywasz?", List.of(new Answer("", "", AnswerType.TEXT))));
        questions.add(new Question("Twój E-mail", List.of(new Answer("", "", AnswerType.TEXT))));
        questions.add(new Question("Napisz mi o celach, które Cię interesują", List.of(new Answer("", "", AnswerType.TEXT))));
        questions.add(new Question("Twoja aktywność fizyczna", List.of(new Answer("", "Duża", AnswerType.CHECKBOX), new Answer("", "Średnia", AnswerType.CHECKBOX), new Answer("", "Mała", AnswerType.CHECKBOX))));
        questions.add(new Question("Jakim planem treningowym obecnie trenowałeś?", List.of(new Answer("", "", AnswerType.TEXT))));
        questions.add(new Question("Masz jakieś kontuzje bądź odczuwasz dyskomfort przy ćwiczeniach?", List.of(new Answer("", "", AnswerType.TEXT))));
        questions.add(new Question("Ile jednostek treningowych w skali tygodnia jesteś w stanie wykonać?", List.of(new Answer("", "", AnswerType.TEXT))));
        questions.add(new Question("Podaj mi swoją wagę(na czczo) oraz wzrost.", List.of(new Answer("", "Waga:", AnswerType.SMALLTEXT), new Answer("", "Wzrost:", AnswerType.SMALLTEXT))));
        questions.add(new Question("Pomiary", List.of(new Answer("", "", AnswerType.TEXT))));
        questions.add(new Question("Dieta", List.of(new Answer("", "", AnswerType.TEXT))));
        questions.add(new Question("Dieta", List.of(new Answer("", "", AnswerType.TEXT))));

        return new QuestionsDto(questions);
    }

}
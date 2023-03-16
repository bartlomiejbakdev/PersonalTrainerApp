package com.example.personaltrainer;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionnaireService {


    public List<Question> getQuestions() {

        List<Question> questionList = new ArrayList<>();


        questionList.add(Question.builder()
                .id(1L)
                .text("Napisz mi o celach, które Cię interesują")
                .build());

        questionList.add(Question.builder()
                .id(1L)
                .text("Twoja aktywność fizyczna")
                .build());

        questionList.add(Question.builder()
                .id(1L)
                .text("Jakim planem treningowym obecnie trenowałeś?")
                .build());

        questionList.add(Question.builder()
                .id(1L)
                .text("Masz jakieś kontuzje bądź odczuwasz dyskomfort przy ćwiczeniach?")
                .build());

        questionList.add(Question.builder()
                .id(1L)
                .text("Ile jednostek treningowych w skali tygodnia jesteś w stanie wykonać?")
                .build());

        questionList.add(Question.builder()
                .id(1L)
                .text("Podaj mi swoją wagę(na czczo) oraz wzrost.")
                .build());

        questionList.add(Question.builder()
                .id(1L)
                .text("Pomiary")
                .build());

        questionList.add(Question.builder()
                .id(1L)
                .text("Dieta")
                .build());
        questionList.add(Question.builder()
                .id(1L)
                .text("Dieta")
                .build());

        return questionList;
    }
}

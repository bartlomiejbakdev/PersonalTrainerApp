package com.example.personaltrainer;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionnaireService {


    public List<Question> getQuestions() {

        List<Question> questions = new ArrayList<>();

        questions.add(new Question("Napisz mi o celach, które Cię interesują", ""));
        questions.add(new Question("Twoja aktywność fizyczna", ""));
        questions.add(new Question("Jakim planem treningowym obecnie trenowałeś?", ""));
        questions.add(new Question("Masz jakieś kontuzje bądź odczuwasz dyskomfort przy ćwiczeniach?", ""));
        questions.add(new Question("Ile jednostek treningowych w skali tygodnia jesteś w stanie wykonać?", ""));
        questions.add(new Question("Podaj mi swoją wagę(na czczo) oraz wzrost.", ""));
        questions.add(new Question("Pomiary", ""));
        questions.add(new Question("Dieta", ""));
        questions.add(new Question("Dieta", ""));

        return questions;
    }
}

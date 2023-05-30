package com.example.personaltrainer.questionnaire;

import com.example.personaltrainer.questionnaire.entity.Answer;
import com.example.personaltrainer.questionnaire.entity.Question;
import com.example.personaltrainer.questionnaire.enums.AnswerType;
import com.example.personaltrainer.questionnaire.model.AnswerDto;
import com.example.personaltrainer.questionnaire.model.QuestionsDto;
import com.example.personaltrainer.questionnaire.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionnaireService {

    private final QuestionRepository questionRepository;

    public QuestionnaireService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }


    public QuestionsDto getQuestions() {

        List<Question> questions = questionRepository.findAll();

//        questions.add(new Question("Jak się nazywasz?", AnswerType.TEXT, List.of(new Answer("", ""))));
//        questions.add(new Question("Twój E-mail", AnswerType.TEXT, List.of(new Answer("", ""))));
//        questions.add(new Question("Napisz mi o celach, które Cię interesują", AnswerType.TEXT, List.of(new Answer("", ""))));
//        questions.add(new Question("Twoja aktywność fizyczna", AnswerType.CHECKBOX, List.of(new Answer("", "Duża"), new Answer("", "Średnia"), new Answer("", "Mała"))));
//        questions.add(new Question("Jakim planem treningowym obecnie trenowałeś?", AnswerType.TEXT, List.of(new Answer("", ""))));
//        questions.add(new Question("Masz jakieś kontuzje bądź odczuwasz dyskomfort przy ćwiczeniach?", AnswerType.TEXT, List.of(new Answer("", ""))));
//        questions.add(new Question("Ile jednostek treningowych w skali tygodnia jesteś w stanie wykonać?", AnswerType.TEXT, List.of(new Answer("", ""))));
//        questions.add(new Question("Podaj mi swoją wagę(na czczo) oraz wzrost.", AnswerType.SMALLTEXT, List.of(new Answer("", "Waga:"), new Answer("", "Wzrost:"))));
//        questions.add(new Question("Pomiary", AnswerType.TEXT, List.of(new Answer("", ""))));
//        questions.add(new Question("Dieta", AnswerType.TEXT, List.of(new Answer("", ""))));
//        questions.add(new Question("Dieta", AnswerType.TEXT, List.of(new Answer("", ""))));

        questions.add(Question.builder()
                .text("Jak się nazywasz?")
                .answerType(AnswerType.TEXT)
                .build());
//        questions.add(Question.builder()
//                .text("Twoja aktywność fizyczna")
//                .answerType(AnswerType.CHECKBOX)
//                .labels(List.of(new Label("Duża"), new Label("Średnia"), new Label("Mała")))
//                .build());
//        questions.add(Question.builder()
//                .text("Podaj mi swoją wagę(na czczo) oraz wzrost.")
//                .answerType(AnswerType.SMALLTEXT)
//                .labels(List.of(new Label("Waga:"), new Label("Wzrost:")))
//                .build());
        System.out.println(questions.get(4).text);
        System.out.println(questions.get(4).labels);
        System.out.println(questions.get(4).answerType);

        System.out.println(questions.get(5).text);
        System.out.println(questions.get(5).labels);
        System.out.println(questions.get(5).answerType);

        return new QuestionsDto(questions);
    }

    public AnswerDto getAnswers(List<Question> questionList) {

        List<Answer> answerList = new ArrayList<>();

        for (Question ignored : questionList) {
            answerList.add(new Answer());
        }

        return new AnswerDto(answerList);
    }
}
package com.example.personaltrainer.questionnaire;

import com.example.personaltrainer.questionnaire.entity.Answer;
import com.example.personaltrainer.questionnaire.entity.Question;
import com.example.personaltrainer.questionnaire.model.AnswerDto;
import com.example.personaltrainer.questionnaire.model.QuestionsDto;
import com.example.personaltrainer.questionnaire.repository.QuestionRepository;
import org.springframework.data.domain.Sort;
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

        Sort sortByOrderId = Sort.by("orderId");

        List<Question> questions = questionRepository.findAll(sortByOrderId);

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
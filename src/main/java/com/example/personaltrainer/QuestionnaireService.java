package com.example.personaltrainer;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionnaireService {


    public QuestionsDto getQuestions() {

        List<Question> questions = new ArrayList<>();

        questions.add(new Question("Jak się nazywasz?", List.of(new Answer("", AnswerType.TEXT))));
        questions.add(new Question("Twój E-mail", List.of(new Answer("", AnswerType.TEXT))));
        questions.add(new Question("Napisz mi o celach, które Cię interesują", List.of(new Answer("", AnswerType.TEXT))));
        questions.add(new Question("Twoja aktywność fizyczna", List.of(new Answer("", AnswerType.TEXT))));
        questions.add(new Question("Jakim planem treningowym obecnie trenowałeś?", List.of(new Answer("", AnswerType.TEXT))));
        questions.add(new Question("Masz jakieś kontuzje bądź odczuwasz dyskomfort przy ćwiczeniach?", List.of(new Answer("", AnswerType.TEXT))));
        questions.add(new Question("Ile jednostek treningowych w skali tygodnia jesteś w stanie wykonać?", List.of(new Answer("", AnswerType.TEXT))));
        questions.add(new Question("Podaj mi swoją wagę(na czczo) oraz wzrost.", List.of(new Answer("", AnswerType.TEXT))));
        questions.add(new Question("Pomiary", List.of(new Answer("", AnswerType.TEXT))));
        questions.add(new Question("Dieta", List.of(new Answer("", AnswerType.TEXT))));
        questions.add(new Question("Dieta", List.of(new Answer("", AnswerType.TEXT))));

        return new QuestionsDto(questions);
    }

    public void generateDocument(QuestionsDto questionsDto) throws IOException {

        XWPFDocument document = new XWPFDocument();

        XWPFParagraph paragraph = document.createParagraph();


        for (Question question : questionsDto.getQuestionList()) {
            paragraph.createRun().setText(question.text + "\n");
            paragraph.createRun().addBreak();
            paragraph.createRun().addBreak();
            for (Answer answer : question.answerList) {
                paragraph.createRun().setText(answer + "\n");
            }
            paragraph.createRun().addBreak();
            paragraph.createRun().addBreak();
            paragraph.createRun().addBreak();
        }

        FileOutputStream out = new FileOutputStream("src/main/resources/questionnaires/" + questionsDto.getQuestionList().get(0).answerList.get(0).text + ".docx");
        document.write(out);
        out.close();
    }
}
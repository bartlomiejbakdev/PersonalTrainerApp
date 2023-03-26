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

        questions.add(new Question("Jak się nazywasz?", ""));
        questions.add(new Question("Twój E-mail", ""));
        questions.add(new Question("Napisz mi o celach, które Cię interesują", ""));
        questions.add(new Question("Twoja aktywność fizyczna", ""));
        questions.add(new Question("Jakim planem treningowym obecnie trenowałeś?", ""));
        questions.add(new Question("Masz jakieś kontuzje bądź odczuwasz dyskomfort przy ćwiczeniach?", ""));
        questions.add(new Question("Ile jednostek treningowych w skali tygodnia jesteś w stanie wykonać?", ""));
        questions.add(new Question("Podaj mi swoją wagę(na czczo) oraz wzrost.", ""));
        questions.add(new Question("Pomiary", ""));
        questions.add(new Question("Dieta", ""));
        questions.add(new Question("Dieta", ""));

        return new QuestionsDto(questions);
    }

    public void generateDocument(QuestionsDto questionsDto) throws IOException {

        XWPFDocument document = new XWPFDocument();

        XWPFParagraph paragraph = document.createParagraph();


        for (Question question : questionsDto.getQuestionList()) {
            paragraph.createRun().setText(question.text + "\n");
            paragraph.createRun().addBreak();
            paragraph.createRun().addBreak();
            paragraph.createRun().setText(question.answer + "\n");
            paragraph.createRun().addBreak();
            paragraph.createRun().addBreak();
            paragraph.createRun().addBreak();
        }

        FileOutputStream out = new FileOutputStream("src/main/resources/questionnaires/" + questionsDto.getQuestionList().get(0).answer + ".docx");
        document.write(out);
        out.close();
    }
}
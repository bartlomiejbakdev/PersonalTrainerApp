package com.example.personaltrainer.questionnaire.entity;

import com.example.personaltrainer.questionnaire.enums.AnswerType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Question {

    public String text;

    public AnswerType answerType;
    public List<Answer> answerList;
    public List<Label> labels;
}

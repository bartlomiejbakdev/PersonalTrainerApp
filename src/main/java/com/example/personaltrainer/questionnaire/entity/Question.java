package com.example.personaltrainer.questionnaire.entity;

import com.example.personaltrainer.questionnaire.entity.Answer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {

    public String text;
    public List<Answer> answerList;
}

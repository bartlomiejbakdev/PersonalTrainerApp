package com.example.personaltrainer.questionnaire.model;

import com.example.personaltrainer.questionnaire.entity.Answer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerDto {

    private List<Answer> answerList;
}

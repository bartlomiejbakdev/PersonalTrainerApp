package com.example.personaltrainer.questionnaire.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionOrder {

    public Long firstQuestionId;
    public Long secondQuestionId;
}

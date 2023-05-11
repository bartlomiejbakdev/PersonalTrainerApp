package com.example.personaltrainer.questionnaire.entity;


import com.example.personaltrainer.questionnaire.enums.AnswerType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Answer {

    public String text;
    public String label;
    public AnswerType type;
}

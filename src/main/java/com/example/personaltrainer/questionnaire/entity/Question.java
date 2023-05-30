package com.example.personaltrainer.questionnaire.entity;

import com.example.personaltrainer.questionnaire.enums.AnswerType;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String text;

    public AnswerType answerType;

    @OneToMany
    public List<Answer> answerList;

    @OneToMany
    public List<Label> labels;
}

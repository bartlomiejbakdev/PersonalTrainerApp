package com.example.personaltrainer.questionnaire.repository;


import com.example.personaltrainer.questionnaire.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}

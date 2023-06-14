package com.example.personaltrainer.questionnaire.repository;


import com.example.personaltrainer.questionnaire.entity.Question;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    Question findByOrderId(Long orderId);
    List<Question> findAll(Sort sort);
}

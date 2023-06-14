package com.example.personaltrainer.questionnaire.repository;

import com.example.personaltrainer.questionnaire.entity.Label;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LabelRepository extends JpaRepository <Label, Long> {
}

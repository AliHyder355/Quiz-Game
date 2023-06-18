package com.quiz.kbc.Repositories;

import com.quiz.kbc.Entities.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionsRepository extends JpaRepository <Questions , Integer> {
}

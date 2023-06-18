package com.quiz.kbc.Repositories;

import com.quiz.kbc.Entities.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository <Answer, Integer> {

}

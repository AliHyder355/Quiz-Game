package com.quiz.kbc.Services.Interfaces;

import com.quiz.kbc.DTO.QuestionsDto;
import com.quiz.kbc.Entities.Questions;
import org.aspectj.weaver.patterns.TypePatternQuestions;

import java.util.List;

public interface QuestionService {

    public QuestionsDto addQuestion(QuestionsDto questionsDto) throws Exception;
    public List<QuestionsDto> getAllQuestions() throws Exception;
    public QuestionsDto getQuestionById(int id) throws Exception;
    public QuestionsDto updateQuestion(QuestionsDto questionsDto) throws Exception;
    public void deleteQuestion (int id) throws Exception;
}

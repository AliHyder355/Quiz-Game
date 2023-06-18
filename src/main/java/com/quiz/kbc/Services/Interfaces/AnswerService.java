package com.quiz.kbc.Services.Interfaces;

import com.quiz.kbc.DTO.AnswerDto;
import com.quiz.kbc.Entities.Answer;

import java.util.List;

public interface AnswerService {

    public List<AnswerDto> getAllAns() throws Exception;
    public AnswerDto updateAns(AnswerDto answerDto) throws Exception ;

    public void deleteAns(int id) throws Exception;

}

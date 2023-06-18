package com.quiz.kbc.Adapters;

import com.quiz.kbc.DTO.AnswerDto;
import com.quiz.kbc.Entities.Answer;

public class AnswersAdapter {

    public Answer DtoToDao(AnswerDto answerDto){
        Answer answer = new Answer();
        answer.setAnsID(answerDto.getAnsId());
        answer.setAnswer(answerDto.getAnswer());
        answer.setCorrectAns(answerDto.getCorrectAns());

        return answer;
    }

    public AnswerDto DaoToDto(Answer answer){
        AnswerDto answerDto = new AnswerDto();
        answerDto.setAnsId(answer.getAnsID());
        answerDto.setAnswer(answer.getAnswer());
        answerDto.setCorrectAns(answer.getCorrectAns());

        return answerDto;
    }
}

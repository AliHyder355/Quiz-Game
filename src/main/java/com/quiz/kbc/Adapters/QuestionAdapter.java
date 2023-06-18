package com.quiz.kbc.Adapters;

import com.quiz.kbc.DTO.AnswerDto;
import com.quiz.kbc.DTO.QuestionsDto;
import com.quiz.kbc.Entities.Answer;
import com.quiz.kbc.Entities.Questions;
import com.quiz.kbc.Utility.QuestionCategory;

import java.util.ArrayList;
import java.util.List;

public class QuestionAdapter {

    public Questions DtoToDao(QuestionsDto questionsDto){
        AnswersAdapter answersAdapter = new AnswersAdapter();
        Questions questions = new Questions();
        List<Answer> answers = new ArrayList<>();

        questions.setQuestionID(questionsDto.getQuestionId());
        questions.setQuestion(questionsDto.getQuestion());

        switch (questionsDto.getQuestionCategory()){
            case "Computer Science":
                questions.setQstnCategory(QuestionCategory.COMPUTER);
                break;

            case "General Science":
                questions.setQstnCategory(QuestionCategory.GENERAL_SCIENCE);
                break;

            case "History":
                questions.setQstnCategory(QuestionCategory.HISTORY);
                break;

            case "Pakistan Studies":
                questions.setQstnCategory(QuestionCategory.PAKISTAN_STUDIES);
                break;
        }

        for(AnswerDto ans: questionsDto.getAnswers()){
            answers.add(answersAdapter.DtoToDao(ans));
        }
        questions.setAns(answers);
        return questions;
    }

    public QuestionsDto DaoToDto(Questions questions){
        AnswersAdapter answersAdapter = new AnswersAdapter();
        QuestionsDto questionsDto = new QuestionsDto();
        List<AnswerDto> answersDto = new ArrayList<>();

        questionsDto.setQuestionId(questions.getQuestionID());
        questionsDto.setQuestion(questions.getQuestion());

        switch (questions.getQstnCategory()){
            case GENERAL_SCIENCE:
                questionsDto.setQuestionCategory("General Science");
                break;

            case COMPUTER:
                questionsDto.setQuestionCategory("Computer Science");
                break;

            case PAKISTAN_STUDIES:
                questionsDto.setQuestionCategory("Pakistan Studies");
                break;

            case HISTORY:
                questionsDto.setQuestionCategory("History");
                break;
        }

        for(Answer ans: questions.getAns()){
            answersDto.add(answersAdapter.DaoToDto(ans));
        }
        questionsDto.setAnswers(answersDto);

        return questionsDto;
    }


}

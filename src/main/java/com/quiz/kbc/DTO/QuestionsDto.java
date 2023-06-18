package com.quiz.kbc.DTO;

import com.quiz.kbc.Utility.QuestionCategory;

import java.util.List;

public class QuestionsDto {
    private int questionId;
    private String questionCategory;
    private String question;
    private List<AnswerDto> answers;

    public QuestionsDto(int questionId, String questionCategory, String question, List<AnswerDto> answers) {
        this.questionId = questionId;
        this.questionCategory = questionCategory;
        this.question = question;
        this.answers = answers;
    }

    public QuestionsDto() {
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestionCategory() {
        return questionCategory;
    }

    public void setQuestionCategory(String questionCategory) {
        this.questionCategory = questionCategory;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<AnswerDto> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerDto> answers) {
        this.answers = answers;
    }
}


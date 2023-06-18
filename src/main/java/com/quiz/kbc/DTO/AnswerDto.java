package com.quiz.kbc.DTO;

public class AnswerDto {
    private int ansId;
    private String answer;

    private boolean correctAns;

    public AnswerDto() {
    }

    public AnswerDto(int ansId, String answer, boolean correctAns) {
        this.ansId = ansId;
        this.answer = answer;
        this.correctAns = correctAns;
    }

    public int getAnsId() {
        return ansId;
    }

    public void setAnsId(int ansId) {
        this.ansId = ansId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean getCorrectAns() {
        return correctAns;
    }

    public void setCorrectAns(boolean correctAns) {
        this.correctAns = correctAns;
    }
}

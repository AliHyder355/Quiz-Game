package com.quiz.kbc.Entities;

import jakarta.persistence.*;

@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ansID;
    @Column
    private String answer;
    @Column
    private boolean correctAns;

//    @ManyToOne
//    @JoinColumn
//    private Questions questions;


    public Answer(int ansID, String answer, boolean correctAns) {
        this.ansID = ansID;
        this.answer = answer;
        this.correctAns = correctAns;
    }

    public Answer() {
    }

    public int getAnsID() {
        return ansID;
    }

    public void setAnsID(int ansID) {
        this.ansID = ansID;
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
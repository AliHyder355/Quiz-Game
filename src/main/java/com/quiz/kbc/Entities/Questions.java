package com.quiz.kbc.Entities;
import com.quiz.kbc.Utility.QuestionCategory;
import jakarta.persistence.*;

import java.util.List;
@Entity
public class Questions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int questionID;
    @Column
    private QuestionCategory qstnCategory;
    @Column
    private String question;

    @OneToMany (cascade = CascadeType.ALL )
    @JoinColumn(name="qstn_id")
    private List<Answer> ans;

    public Questions(int questionID, QuestionCategory qstnCategory, String question, List<Answer> ans) {
        this.questionID = questionID;
        this.qstnCategory = qstnCategory;
        this.question = question;
        this.ans = ans;
    }

    public Questions() {
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public QuestionCategory getQstnCategory() {
        return qstnCategory;
    }

    public void setQstnCategory(QuestionCategory qstnCategory) {
        this.qstnCategory = qstnCategory;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Answer> getAns() {
        return ans;
    }

    public void setAns(List<Answer> ans) {
        this.ans = ans;
    }
}

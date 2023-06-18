package com.quiz.kbc.Entities;

import jakarta.persistence.*;

@Entity
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int scoreId;

    @Column
    private int score;
//    @OneToOne
//    @JoinColumn(name = "player_id" , referencedColumnName = "playerId")
//    private Player player;

    public Score(int scoreId, int score) {
        this.scoreId = scoreId;
        this.score = score;
    }

    public Score() {
    }

    public int getScoreId() {
        return scoreId;
    }

    public void setScoreId(int scoreId) {
        this.scoreId = scoreId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}

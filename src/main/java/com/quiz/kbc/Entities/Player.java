package com.quiz.kbc.Entities;

import jakarta.persistence.*;

@Entity
public class Player {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private int playerId;
    @Column
    private String playerName;
    @Column
    private String playerEmail;
    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name="score_id")
    private Score playerScore;

    public Player(int playerId, String playerName, String playerEmail, Score playerScore) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.playerEmail = playerEmail;
        this.playerScore = playerScore;
    }

    public Player() {
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerEmail() {
        return playerEmail;
    }

    public void setPlayerEmail(String playerEmail) {
        this.playerEmail = playerEmail;
    }

    public Score getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(Score playerScore) {
        this.playerScore = playerScore;
    }
}

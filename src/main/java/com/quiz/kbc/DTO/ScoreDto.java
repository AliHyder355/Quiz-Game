package com.quiz.kbc.DTO;

public class ScoreDto {

    private int scoreId;
    private int playerScore;

    public ScoreDto(int scoreId, int playerScore) {
        this.scoreId = scoreId;
        this.playerScore = playerScore;
    }

    public ScoreDto() {
    }

    public int getScoreId() {
        return scoreId;
    }

    public void setScoreId(int scoreId) {
        this.scoreId = scoreId;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }
}

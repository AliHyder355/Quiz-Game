package com.quiz.kbc.DTO;

public class PlayerDto {
    private int playerId;
    private  String playerName;
    private String playerEmail;
    private ScoreDto playerScore;

    private String category;

    public PlayerDto() {
    }

    public PlayerDto(int playerId, String playerName, String playerEmail, ScoreDto playerScore) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.playerEmail = playerEmail;
        this.playerScore = playerScore;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public ScoreDto getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(ScoreDto playerScore) {
        this.playerScore = playerScore;
    }
}

package com.quiz.kbc.Adapters;

import com.quiz.kbc.DTO.PlayerDto;
import com.quiz.kbc.Entities.Player;

public class PlayerAdapter {

    public PlayerDto DaoToDto(Player player){
        ScoreAdapter scoreAdapter = new ScoreAdapter();
        PlayerDto playerDto = new PlayerDto();

        playerDto.setPlayerId(player.getPlayerId());
        playerDto.setPlayerName(player.getPlayerName());
        playerDto.setPlayerEmail(player.getPlayerEmail());
        playerDto.setPlayerScore(scoreAdapter.DaoToDto(player.getPlayerScore()));

        return playerDto;
    }

    public Player DtoToDao(PlayerDto playerDto){
        Player player = new Player();
        ScoreAdapter scoreAdapter = new ScoreAdapter();

        player.setPlayerId(playerDto.getPlayerId());
        player.setPlayerName(playerDto.getPlayerName());
        player.setPlayerEmail(playerDto.getPlayerEmail());
        player.setPlayerScore(scoreAdapter.DtoToDao(playerDto.getPlayerScore()));

        return player;

    }

}

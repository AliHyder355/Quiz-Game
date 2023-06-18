package com.quiz.kbc.Services.Interfaces;

import com.quiz.kbc.DTO.PlayerDto;
import com.quiz.kbc.Entities.Player;

import java.util.List;

public interface PlayerService {

    public List<PlayerDto> getAllPlayers() throws Exception;
    public PlayerDto findById(int id) throws Exception;
    public PlayerDto savePlayer(PlayerDto playerDto) throws Exception;
    public PlayerDto updatePlayer (PlayerDto playerDto) throws Exception;

    public void deletePlayer (int id) throws Exception;
}

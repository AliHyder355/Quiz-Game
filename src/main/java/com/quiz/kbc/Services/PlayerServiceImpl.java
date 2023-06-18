package com.quiz.kbc.Services;

import com.quiz.kbc.Adapters.PlayerAdapter;
import com.quiz.kbc.Adapters.ScoreAdapter;
import com.quiz.kbc.DTO.PlayerDto;
import com.quiz.kbc.Entities.Player;
import com.quiz.kbc.Repositories.PlayerRepository;
import com.quiz.kbc.Services.Interfaces.PlayerService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {
    @Autowired
    private PlayerRepository playerRepository;
    @Override
    public List<PlayerDto> getAllPlayers() throws Exception {
        PlayerAdapter playerAdapter =new PlayerAdapter();
        List<PlayerDto> playerDtos = new ArrayList<>();
        for (Player player : playerRepository.findAll()) {
            playerDtos.add(playerAdapter.DaoToDto(player));
        }
        return  playerDtos;
    }

    @Override
    public PlayerDto findById(int id) throws Exception {
        PlayerAdapter playerAdapter =new PlayerAdapter();
        Player player = playerRepository.findById(id).get();
        return playerAdapter.DaoToDto(player);
    }

    @Override
    public PlayerDto savePlayer(PlayerDto playerDto) throws Exception {
        PlayerAdapter playerAdapter =new PlayerAdapter();
        Player player = playerAdapter.DtoToDao(playerDto);
        playerRepository.save(player);
        return  playerDto;
    }

    @Transactional
    @Override
    public PlayerDto updatePlayer(PlayerDto playerDto) throws Exception {
        PlayerAdapter playerAdapter =new PlayerAdapter();
        ScoreAdapter scoreAdapter = new ScoreAdapter();
        Player player = playerRepository.findById(playerDto.getPlayerId()).get();

        player.setPlayerId(playerDto.getPlayerId());
        player.setPlayerName(playerDto.getPlayerName());
        player.setPlayerEmail(playerDto.getPlayerEmail());
       // player.setPlayerScore(scoreAdapter.DtoToDao(playerDto.getPlayerScore()));

        return playerDto;
    }

    @Override
    public void deletePlayer(int id) throws Exception {

        playerRepository.deleteById(id);
    }
}

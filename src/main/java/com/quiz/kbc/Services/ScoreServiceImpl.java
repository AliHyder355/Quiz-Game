package com.quiz.kbc.Services;

import com.quiz.kbc.Adapters.ScoreAdapter;
import com.quiz.kbc.DTO.ScoreDto;
import com.quiz.kbc.Entities.Score;
import com.quiz.kbc.Repositories.ScoreRepository;
import com.quiz.kbc.Services.Interfaces.ScoreService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;
    @Override
    public List<ScoreDto> getAllScore() throws Exception {
        ScoreAdapter scoreAdapter = new ScoreAdapter();
        List<ScoreDto> scoreDtos = new ArrayList<>();

        for (Score score : scoreRepository.findAll()) {
            scoreDtos.add(scoreAdapter.DaoToDto(score));
        }
        return scoreDtos;
    }

    @Override
    public ScoreDto getScoreById(int id) throws Exception {
        ScoreAdapter scoreAdapter = new ScoreAdapter();
        Score score = scoreRepository.findById(id).get();
        return scoreAdapter.DaoToDto(score);
    }

    @Override
    public void deleteScore(int id) throws Exception {
        scoreRepository.deleteById(id);
    }
    @Transactional
    @Override
    public ScoreDto updateScore(ScoreDto scoreDto) throws Exception {
        Score score = scoreRepository.findById(scoreDto.getScoreId()).get();
        score.setScoreId(score.getScoreId());
        score.setScore(scoreDto.getPlayerScore());
        return scoreDto;
    }
}

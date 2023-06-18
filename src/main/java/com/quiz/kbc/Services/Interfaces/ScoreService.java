package com.quiz.kbc.Services.Interfaces;

import com.quiz.kbc.DTO.ScoreDto;
import com.quiz.kbc.Entities.Score;

import java.util.List;

public interface ScoreService {

    public List<ScoreDto> getAllScore() throws Exception;
    public ScoreDto getScoreById(int id) throws Exception;
    public void deleteScore(int id) throws Exception;

    public ScoreDto updateScore (ScoreDto scoreDto) throws Exception;

}

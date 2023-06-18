package com.quiz.kbc.Adapters;

import com.quiz.kbc.DTO.ScoreDto;
import com.quiz.kbc.Entities.Score;

public class ScoreAdapter {

    public ScoreDto DaoToDto(Score score){
        ScoreDto scoreDto = new ScoreDto();

        scoreDto.setScoreId(score.getScoreId());
        scoreDto.setPlayerScore(score.getScore());
        return scoreDto;
    }

    public Score DtoToDao(ScoreDto scoreDto){
        Score score = new Score();

        score.setScoreId(scoreDto.getScoreId());
        score.setScore(scoreDto.getPlayerScore());
        return score;
    }
}

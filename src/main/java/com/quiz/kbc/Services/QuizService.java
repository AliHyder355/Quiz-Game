package com.quiz.kbc.Services;

import com.quiz.kbc.Adapters.PlayerAdapter;
import com.quiz.kbc.Adapters.QuestionAdapter;
import com.quiz.kbc.DTO.AnswerDto;
import com.quiz.kbc.DTO.PlayerDto;
import com.quiz.kbc.DTO.QuestionsDto;
import com.quiz.kbc.Entities.Player;
import com.quiz.kbc.Entities.Questions;
import com.quiz.kbc.Entities.Score;
import com.quiz.kbc.Repositories.AnswerRepository;
import com.quiz.kbc.Repositories.PlayerRepository;
import com.quiz.kbc.Repositories.QuestionsRepository;
import com.quiz.kbc.Repositories.ScoreRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
@Service
public class QuizService {
    @Autowired
    private QuestionsRepository questionsRepository;
    @Autowired
    private AnswerRepository answerRepository;
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private ScoreRepository scoreRepository;
    public Random rand = new Random();
    List<QuestionsDto> randomQuestion = new ArrayList<>();
    public int playerId = 0;
    public int playerScore = 0;
    private int randomIndex = 0;


    //-----------Api for starting quiz, this will return any random question--------
    public QuestionsDto startQuiz(PlayerDto playerDto)throws Exception{
        QuestionsDto qd = new QuestionsDto();
        qd.setQuestion("Sample");
        randomQuestion.add(qd);

        playerScore = 0;
        //------String category is for testing purpose we'll take category from player-----

        PlayerAdapter playerAdapter = new PlayerAdapter();
        QuestionAdapter questionAdapter = new QuestionAdapter();

        Player player = playerAdapter.DtoToDao(playerDto);

        Player byplayerName = playerRepository.findByplayerName(player.getPlayerName());

        System.out.println(byplayerName);

        if (byplayerName != null){
            this.playerId = byplayerName.getPlayerId();
        }
        else {
            Player savedPlayer = playerRepository.save(player);
            playerId = savedPlayer.getPlayerId();
        }
//        Player savedPlayer = playerRepository.save(player);
//        playerId = savedPlayer.getPlayerId();

        System.out.println(playerId);

            randomQuestion.removeAll(randomQuestion);

            for (Questions questions : questionsRepository.findAll()) {
                if (questionAdapter.DaoToDto(questions).getQuestionCategory().equals(playerDto.getCategory())){
                    randomQuestion.add(questionAdapter.DaoToDto(questions));
                }
            }

        randomIndex = rand.nextInt(0 , randomQuestion.size());
        return randomQuestion.get(randomIndex);

    }
    @Transactional
    public QuestionsDto playerAnswer(AnswerDto answerDto)throws Exception {
        PlayerAdapter playerAdapter = new PlayerAdapter();

        if (answerDto.getCorrectAns()){
            int scoreId = playerRepository.findById(playerId).get().getPlayerScore().getScoreId();

            playerScore += 10;

            System.out.println(playerScore);

            Score score = scoreRepository.findById(scoreId).get();
            if (playerScore > score.getScore()){
                score.setScore(playerScore);
            }
//            score.setScore(playerScore);

            randomQuestion.remove(randomIndex);
            if (randomQuestion.size() <1){
               return null;
            }
            randomIndex = rand.nextInt(0 , randomQuestion.size());
            return randomQuestion.get(randomIndex);

        }

        else {
            return null;
        }


    }

    public AnswerDto seeAnswer()throws Exception{
        for (AnswerDto answer : randomQuestion.get(randomIndex).getAnswers()) {
            if (answer.getCorrectAns()){
                return answer;
            }
        }
        return null;
    }

    public PlayerDto getPlayer()throws Exception{
        PlayerAdapter playerAdapter = new PlayerAdapter();

        Player player = this.playerRepository.findById(playerId).get();

        return playerAdapter.DaoToDto(player);
    }

}





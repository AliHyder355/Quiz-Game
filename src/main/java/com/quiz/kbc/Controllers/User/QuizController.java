package com.quiz.kbc.Controllers.User;

import com.quiz.kbc.DTO.AnswerDto;
import com.quiz.kbc.DTO.PlayerDto;
import com.quiz.kbc.DTO.QuestionsDto;
import com.quiz.kbc.Services.QuestionServiceImpl;
import com.quiz.kbc.Services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/player/")
public class QuizController {
    @Autowired
    private QuizService quizService;

    @PostMapping("startquiz")
    public ResponseEntity<Object> startQuiz(@RequestBody PlayerDto playerDto){
        try {
            QuestionsDto questionsDto = quizService.startQuiz(playerDto);
            return new ResponseEntity(questionsDto , HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage() , HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("currentplayer")
    public ResponseEntity<PlayerDto> currentPlayer(){
        try {
            PlayerDto player = quizService.getPlayer();
            return  new ResponseEntity(player , HttpStatus.OK);
        }
        catch (Exception e){
            return  new ResponseEntity(e.getMessage() , HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("checkanswer")
    public ResponseEntity<Object> checkAnswer(@RequestBody AnswerDto answerDto){
        try {
            QuestionsDto questionsDto = quizService.playerAnswer(answerDto);
            return new ResponseEntity(questionsDto, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage() , HttpStatus.OK);
        }
    }

    @GetMapping("seeanswer")
    public ResponseEntity<Object> seeAnswer(){
        try {
            AnswerDto answerDto = quizService.seeAnswer();
            return new ResponseEntity(answerDto , HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}

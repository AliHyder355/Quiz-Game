package com.quiz.kbc.Controllers.Admin;

import com.quiz.kbc.DTO.ScoreDto;
import com.quiz.kbc.Services.Interfaces.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/")
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    @GetMapping("getallscores")
    public ResponseEntity<Object> getAllScores(){
        try{
            List<ScoreDto> allScore = scoreService.getAllScore();
            return new ResponseEntity(allScore , HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("scorebyid/{id}")
    public ResponseEntity<Object> scoreById(@PathVariable int id){
        try{
            ScoreDto scoreById = scoreService.getScoreById(id);
            return new ResponseEntity(scoreById, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("updatescore")
    public ResponseEntity<Object> updateScore(@RequestBody ScoreDto scoreDto){
        try{
            ScoreDto updatedScore = scoreService.updateScore(scoreDto);
            return new ResponseEntity(updatedScore ,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("deletescore/{id}")
    public ResponseEntity<Object> deleteScore(@PathVariable int id){
        try{
            scoreService.deleteScore(id);
            return new ResponseEntity("Score Successfully Deleted..!" , HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage() , HttpStatus.NOT_FOUND);
        }
    }
}

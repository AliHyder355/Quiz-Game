package com.quiz.kbc.Controllers.Admin;

import com.quiz.kbc.DTO.AnswerDto;
import com.quiz.kbc.Services.AnswerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/")
public class AnswerController {
    @Autowired
    private AnswerServiceImpl answerService;

    @GetMapping("getallanswers")
    public ResponseEntity<Object> getAll(){
        try{
            List<AnswerDto> allAns = answerService.getAllAns();
            return new ResponseEntity(allAns, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage() , HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("updateanswer")
    public ResponseEntity<Object> updateAns(@RequestBody AnswerDto answerDto){
        try {
            AnswerDto updatedAns = answerService.updateAns(answerDto);
            return new ResponseEntity(updatedAns, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage() , HttpStatus.OK);
        }
    }

    @DeleteMapping("deleteanswer/{id}")
    public ResponseEntity<Object> deleteAns(@PathVariable int id){
        try{
           answerService.deleteAns(id);
           return new ResponseEntity("Answer Deleted" , HttpStatus.OK);
        }
        catch (Exception e){
            return  new ResponseEntity(e.getMessage() , HttpStatus.OK);
        }
    }
}

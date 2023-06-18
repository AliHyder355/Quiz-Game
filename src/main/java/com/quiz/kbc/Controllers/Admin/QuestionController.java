package com.quiz.kbc.Controllers.Admin;

import com.quiz.kbc.DTO.QuestionsDto;
import com.quiz.kbc.Services.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/admin")
public class QuestionController {

    @Autowired
    private QuestionServiceImpl questionService;

    @PostMapping("/addQuestion")
    public ResponseEntity<Object> addQuestion(@RequestBody QuestionsDto questionsDto){
        try{
           QuestionsDto qDto = questionService.addQuestion(questionsDto);
            return new ResponseEntity(qDto,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage() ,HttpStatus.OK );
        }
    }


    @GetMapping("/getallquestions")
    public ResponseEntity<Object> getAll(){
        try{
            List<QuestionsDto> allQuestions = questionService.getAllQuestions();
            return  new ResponseEntity(allQuestions, HttpStatus.OK);
        }
        catch (Exception e){
            return  new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<Object> getById(@PathVariable int id){
        try{
            QuestionsDto questionById = questionService.getQuestionById(id);
            return new ResponseEntity(questionById , HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updatequestion")
    public ResponseEntity<Object> updateQuestion(@RequestBody QuestionsDto questionsDto){
        try{
            QuestionsDto updatedQuestion = questionService.updateQuestion(questionsDto);
            return new ResponseEntity(updatedQuestion , HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deletequestion/{id}")
    public ResponseEntity<Object> deleteQuestion(@PathVariable int id){
        try{
            questionService.deleteQuestion(id);
            return new ResponseEntity("Question Deleted Succesfully..!", HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}

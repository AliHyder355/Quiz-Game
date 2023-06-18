package com.quiz.kbc.Controllers.Admin;

import com.quiz.kbc.DTO.PlayerDto;
import com.quiz.kbc.Services.Interfaces.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @GetMapping("getallplayers")
    public ResponseEntity<Object> getAllPlayers(){
        try{
            List<PlayerDto> allPlayers = playerService.getAllPlayers();
            return new ResponseEntity(allPlayers , HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage() , HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("addplayer")
    public ResponseEntity<Object> addPlayer(@RequestBody PlayerDto playerDto){
        try{
            PlayerDto savedPlayer = playerService.savePlayer(playerDto);
            return new ResponseEntity(savedPlayer, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("updateplayer")
    public ResponseEntity<Object> updatePlayer(@RequestBody PlayerDto playerDto){
        try{
            PlayerDto updatedPlayer = playerService.updatePlayer(playerDto);
            return new ResponseEntity(updatedPlayer , HttpStatus.OK);
        }
        catch (Exception e){
            return  new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("playerbyid{id}")
    public ResponseEntity<Object> findById(@PathVariable int id){
        try{
            PlayerDto playerById = playerService.findById(id);
            return new ResponseEntity(playerById , HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage() , HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("deleteplayer/{id}")
    public ResponseEntity<Object> deletePlayer(@PathVariable int id){
        try{
            playerService.deletePlayer(id);
            return new ResponseEntity("Player Deleted" , HttpStatus.OK);
        }
        catch (Exception e){
            return  new ResponseEntity(e.getMessage() , HttpStatus.OK);
        }
    }
}

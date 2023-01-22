package com.moura.retro.controller;

import com.moura.retro.model.dto.ErrorResponseDTO;
import com.moura.retro.model.entity.Game;
import com.moura.retro.service.GameService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/games")
@Slf4j
public class GameController {
    @Autowired
    private GameService gameService;

    @PostMapping("/")
    public ResponseEntity<Object> create(@RequestBody @Valid Game game){
        log.info("Inside CREATE method of CartridgeController");

        try {

            Game newGame = gameService.save(game);
            return new ResponseEntity<>(newGame, HttpStatus.CREATED);

        } catch (Exception e) {
            ErrorResponseDTO error = new ErrorResponseDTO();
            error.setCode("InternalServerError");
            error.setMessage(e.getMessage());
            error.setRejectedValue(game);
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> retrieve(@PathVariable("id") Long gameId){
        log.info("Inside RETRIEVE method of CartridgeController");

        try {

            Game game = gameService.findGameById(gameId);
            return new ResponseEntity<>(game, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

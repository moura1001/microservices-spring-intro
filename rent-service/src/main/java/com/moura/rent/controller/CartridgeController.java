package com.moura.rent.controller;

import com.moura.rent.model.dto.CartridgeResponseDTO;
import com.moura.rent.model.dto.ErrorResponseDTO;
import com.moura.rent.model.entity.Cartridge;
import com.moura.rent.service.CartridgeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cartridges")
@Slf4j
public class CartridgeController {
    @Autowired
    private CartridgeService cartridgeService;

    @PostMapping("/")
    public ResponseEntity<Object> create(@RequestBody @Valid Cartridge cartridge){
        log.info("Inside CREATE method of CartridgeController");

        try {

            Cartridge newCartridge = cartridgeService.save(cartridge);
            return new ResponseEntity<>(newCartridge, HttpStatus.CREATED);

        } catch (Exception e) {
            ErrorResponseDTO error = new ErrorResponseDTO();
            error.setCode("InternalServerError");
            error.setMessage(e.getMessage());
            error.setRejectedValue(cartridge);
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> retrieve(@PathVariable("id") Long gameId){
        log.info("Inside RETRIEVE method of CartridgeController");

        try {

            CartridgeResponseDTO cartridges = cartridgeService.getCartridgesWithGame(gameId);
            return new ResponseEntity<>(cartridges, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

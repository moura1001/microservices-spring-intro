package com.moura.rent.controller;

import com.moura.rent.entity.Cartridge;
import com.moura.rent.service.CartridgeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cartridges")
@Slf4j
public class CartridgeController {
    @Autowired
    private CartridgeService cartridgeService;

    @PostMapping("/")
    public ResponseEntity<Cartridge> create(@RequestBody Cartridge cartridge){
        log.info("Inside CREATE method of CartridgeController");

        try {

            Cartridge newCartridge = cartridgeService.save(cartridge);
            return new ResponseEntity<>(newCartridge, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cartridge> retrieve(@PathVariable("id") Long cartridgeId){
        log.info("Inside RETRIEVE method of CartridgeController");

        try {

            Cartridge cartridge = cartridgeService.findCartridgeById(cartridgeId);
            return new ResponseEntity<>(cartridge, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

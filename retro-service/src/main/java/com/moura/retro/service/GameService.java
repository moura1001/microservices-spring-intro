package com.moura.retro.service;

import com.moura.retro.model.entity.Game;
import com.moura.retro.model.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    public Game save(Game game) {
        return gameRepository.save(game);
    }

    public Game findGameById(Long gameId) {
        Game game = gameRepository.findById(gameId).get();
        return game;
    }
}

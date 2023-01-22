package com.moura.retro.model.entity;

enum GameGenre {
    ACTION("ACTION"), ADVENTURE("ADVENTURE"), ARCADE("ARCADE"),
    EDUCATIONAL("EDUCATIONAL"), PUZZLE("PUZZLE"), RPG("RPG"),
    SPORTS("SPORTS");

    private String genre;

    GameGenre(String genre){
        this.genre = genre;
    }

    public String getGenre(){
        return genre;
    }
}

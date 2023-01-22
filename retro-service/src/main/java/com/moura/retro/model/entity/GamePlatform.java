package com.moura.retro.model.entity;

enum GamePlatform {
    NES("NES"), SNES("SNES"), GAMEBOY("GAMEBOY");

    private String platform;

    GamePlatform(String platform){
        this.platform = platform;
    }

    public String getPlatform(){
        return platform;
    }
}

package com.moura.rent.model.entity;

enum CartridgeRegion {
    JP("JP"), NA("NA"), EU("EU");

    private String region;

    CartridgeRegion(String region){
        this.region = region;
    }

    public String getRegion(){
        return region;
    }
}

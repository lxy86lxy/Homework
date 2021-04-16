package com.example.helloworld;

public class BoardGame {
    private String name;
    private int imageId;
    public BoardGame(String name,int imageId){
        this.name=name;
        this.imageId=imageId;
    }
    public String getName(){
        return name;
    }
    public int getImageId(){
        return imageId;
    }
}

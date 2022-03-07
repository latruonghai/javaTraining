package com.lth.example;

public class Brick {
    private int num_brick;
    private int expected;


    public void setBrick(int num_brick, int expected) {
        this.num_brick = num_brick;
        this.expected = expected;
    }

    public int getBrick(){
        return this.num_brick;
    }
    public int getExpected(){
        return this.expected;
    }

}

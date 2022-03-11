package com.lth.example;

public class Brick {
//    private int num_brick;
    private int expected;

    public Brick(int expected){
        this.expected = expected;
    }
    public void setBrick(int num_brick, int expected) {
        this.expected = expected;
    }

    public void setBrick(int expected){
        this.expected = expected;
    }

    public void updateExpected(){
        this.expected--;
    }

    public int getExpected(){
        return this.expected;
    }
}

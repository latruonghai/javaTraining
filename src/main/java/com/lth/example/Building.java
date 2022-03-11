package com.lth.example;

import java.util.concurrent.locks.ReentrantLock;

public class Building {

    private static int Expected = 100;
    public static void main(String[] args) {

        Brick brick = new Brick(Expected);
        ReentrantLock lock = new ReentrantLock(true);
        Mason mason = new Mason(0, Expected, lock, brick);
        mason.start();

        Builder builder1 = new Builder("Builder 1", 0, mason, lock, brick);
        Builder builder2 = new Builder("Builder 2", 0, mason, lock, brick);
        Builder builder3 = new Builder("Builder 3", 0, mason, lock, brick);

        builder1.start();
        builder2.start();
        builder3.start();

//        for(int i=0; i<3;i++){
//            Builder builder = new Builder("Builder " + (i+1), 0, mason, Expected, lock);
//            builder.start();
//        }
//        System.out.println("Done");


    }
}

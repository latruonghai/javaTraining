package com.lth.inhherrit;

public class AnotherParent implements GrandParent{
    public AnotherParent(){
        System.out.println("Day la Another Parent");
    }
    @Override
    public void display(){
        System.out.println("Hello Another Parent");
    }
}

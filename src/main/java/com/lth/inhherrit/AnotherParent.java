package com.lth.inhherrit;

public class AnotherParent implements Child{
    public AnotherParent(){
        System.out.println("Day la Another Parent");
    }
    @Override
    public void display(){
        System.out.println("Hello Another Parent");
    }

    @Override
    public void display2() {
        System.out.println("Hello Child");
    }
}

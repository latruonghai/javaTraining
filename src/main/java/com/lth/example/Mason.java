package com.lth.example;

import org.javatuples.Pair;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Mason extends Thread {
    private int current_resources;
//    private int Expected;
    private Brick brick;
    private final int RESOURCE_RANGE;
    private int KPI;

    Random rand = new Random();
    private ReentrantLock lock;

    public Mason(int current_resources, int Expected, ReentrantLock lock, Brick brick) {
        this.current_resources = current_resources;
        this.lock = lock;
        this.brick = brick;
//        this.Expected = Expected;
        this.RESOURCE_RANGE = Expected /5;
        this.KPI = 0;
    }

    /*
    * Method for mason to get new resources
    * */
    public void setMaxresources(int current_resources){
        if(this.brick.getExpected()>0){
            System.out.println("Out of resources for builders. Mason set new resources");
            this.current_resources = current_resources;
//                this.Expected-=this.MAX_RESOURCES;
            System.out.println("Set new resources successfully. There are " + this.current_resources + " available resources");
        }
        else{
            this.current_resources = 0;
        }
    }
    /*
    * Method to give resources for builders
    * */
    public int getMaxResourcesForBuilder(){
        int newResources = this.current_resources;
        this.current_resources = 0;
        this.KPI += newResources;
        return newResources;
    }
    /*
    * Mason tries to get new resources everytime he ran out of resources.
    *
    * */
    /*@Override
    public void run(){
        while(this.Expected>0) {
            if (this.MAX_RESOURCES <= 0) {
                this.setMaxresources(this.Expected > 0 ? rand.nextInt(RESOURCE_RANGE) + 1 : 0);
            }
        }
        System.out.println("Used " + this.KPI + " resources to gain KPI");
    }*/
//    private void setResources()
    /*
    * Mason tries to give resources for builders to continue building
    * */
    public int getMaxResources(){
//        if(this.MAX_RESOURCES <=0 && this.Expected >=0){
//            this.setMaxresources(this.Expected >=0 ? rand.nextInt(7):0);
//        }
        if (this.current_resources <= 0) {
//            System.out.println("There is " + this.MAX_RESOURCES + " resources");
            this.setMaxresources(this.brick.getExpected() >= 0 ? rand.nextInt(RESOURCE_RANGE) : 0);
        }

        return getMaxResourcesForBuilder();




    }


}

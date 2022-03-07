package com.lth.example;

import org.javatuples.Pair;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Mason extends Thread {
    private int MAX_RESOURCES;
    private int Expected;
    private final int RESOURCE_RANGE;
    private int KPI;

    Random rand = new Random();
    private ReentrantLock lock;

    public Mason(int MAX_RESOURCES, int Expected, ReentrantLock lock) {
        this.MAX_RESOURCES = MAX_RESOURCES;
        this.lock = lock;
        this.Expected = Expected;
        this.RESOURCE_RANGE = Expected /4;
        this.KPI = 0;
    }

    /*
    * Method for mason to get new resources
    * */
    public void setMaxresources(int MAX_RESOURCES){
        if(this.Expected>0){
            System.out.println("Out of resources for builders. Mason set new resources");
            this.MAX_RESOURCES = MAX_RESOURCES;
//                this.Expected-=this.MAX_RESOURCES;
            System.out.println("Set new resources successfully. There are " + this.MAX_RESOURCES + " available resources");
        }
        else{
            this.MAX_RESOURCES = 0;
        }
    }
    /*
    * Method to give resources for builders
    * */
    public Pair<Integer, Integer> getMaxResourcesForBuilder(){
        int newResources = this.MAX_RESOURCES;
        this.MAX_RESOURCES = 0;
        this.Expected -= newResources;
        this.KPI += newResources;
        return Pair.with(newResources, this.Expected);

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
    public Pair<Integer, Integer> getMaxResources(){
//        if(this.MAX_RESOURCES <=0 && this.Expected >=0){
//            this.setMaxresources(this.Expected >=0 ? rand.nextInt(7):0);
//        }
        if (this.MAX_RESOURCES <= 0) {
//            System.out.println("There is " + this.MAX_RESOURCES + " resources");
            this.setMaxresources(this.Expected >= 0 ? rand.nextInt(RESOURCE_RANGE) + 1 : 0);
        }

        return getMaxResourcesForBuilder();




    }


}

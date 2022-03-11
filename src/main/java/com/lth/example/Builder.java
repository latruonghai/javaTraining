package com.lth.example;


import org.javatuples.Pair;

import java.util.concurrent.locks.ReentrantLock;

public class Builder extends Thread {
    private int resources;

    private final String name;
    private final Mason mason;
    private final Brick brick;
//    private int Expected;
    private ReentrantLock lock;
    public Builder(String name, int resources, Mason mason,ReentrantLock lock, Brick brick) {
//        super();
//        this.mason = new Mason()
        this.lock = lock;
        this.brick = brick;
        this.mason = mason;
        this.name = name;
        this.resources = resources;
//        this.Expected = Expected;
    }

    public void setResources(int resources) {
        this.resources = resources;
    }

    private void buildingTime() {
        this.resources --;
        lock.lock();
        try{
            this.brick.updateExpected();
        }
        finally{
            lock.unlock();
        }
        System.out.println(this.name + " is building. There are the remainder of "
                + this.brick.getExpected() + " resources");
    }

    @Override
    public void run(){


        while(true){
            if(this.brick.getExpected() <=0){
                System.out.println("There is " + this.brick.getExpected() +
                        " brick in expected resources. So that, " + this.name + " done Job");
                break;
            }

            else if (this.resources <=0 ){
                System.out.println(this.name + " Require resources!!");
                int resources;
                lock.lock();
                try{
                   resources = mason.getMaxResources();
                }
                finally{
                   lock.unlock();
                }
//               System.out.println(resourcesAndExpected.getValue1());

                /*
                * There are two cases:
                *   - When build get resources which have 0 number. That means
                *   the mason run out of resources. So that, builder have to wait for
                *   mason to get new resources.
                *   - When build get resources which have 0 number and there is no
                *   expected resources. That means, the task has done. The builder should
                *   not build anymore.
                * */
                if(resources <= 0 ){
//                    if(resourcesAndExpected.getValue1() <= 0 ){
                    System.out.println(this.name + " Can't Require resources!!");
                    System.out.println(this.name + " Done Job");
                    break;
//                    }
//                    else{
//                        System.out.println("Mason is getting resources! " + this.name + " please wait");
//                    }
                }
                else{
                    System.out.println(this.name + " was gotten resources");
                    setResources(resources);

                    System.out.println(this.name + " have " + this.resources + " resources");
                }

            }
            /*
            * State that builder is building.
            * */
            if(this.resources>0){
                buildingTime();

            }

        }
    }



}

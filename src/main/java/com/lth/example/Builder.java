package com.lth.example;


import org.javatuples.Pair;

import java.util.concurrent.locks.ReentrantLock;

public class Builder extends Thread {
    private int resources;
    private String name;
    private Mason mason;
    private int Expected;
    private ReentrantLock lock;
    public Builder(String name, int resources, Mason mason, int Expected, ReentrantLock lock) {
//        super();
//        this.mason = new Mason()
        this.lock = lock;
        this.mason = mason;
        this.name = name;
        this.resources = resources;
        this.Expected = Expected;
    }

    public void setResources(int resources) {
        this.resources = resources;
    }

//    public void setExpected(int Expected){
//        this.Expected = Expected;
//    }
    /*
    * Builder try to build
    * */
    @Override
    public void run(){


        while(true ){
            if (this.resources <=0 ){
                System.out.println(this.name + " Require resources!!");
               Pair<Integer, Integer> resourcesAndExpected = mason.getMaxResources();
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
                if(resourcesAndExpected.getValue0() <= 0 ){
                    if(resourcesAndExpected.getValue1() <= 0 ){
                        System.out.println(this.name + " Can't Require resources!!");
                        System.out.println(this.name + " Done Job");
                        break;
                    }
                    else{
                        System.out.println("Mason is getting resources! " + this.name + " please wait");
                    }

                }
                else{
                    System.out.println(this.name + " was gotten resources");
                    setResources(resourcesAndExpected.getValue0());
//                mason.setMaxresources(0);

                    System.out.println(this.name + " have " + this.resources + " resources");
                }

            }
            /*
            * State that builder is building.
            * */
            if(this.resources>0){
                this.resources --;
                System.out.println(this.name + " is building");
            }

        }
    }

}

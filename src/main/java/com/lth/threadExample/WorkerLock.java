package com.lth.threadExample;

import java.util.concurrent.locks.ReentrantLock;

public class WorkerLock extends Thread {
    private ReentrantLock lock;
    private String name;


    public WorkerLock(ReentrantLock lock, String name) {
        this.lock = lock;
        this.name = name;
    }

    @Override
    public void run() {
        lock.lock();
        try{
            for(int i =0 ; i <6; i++){

                System.out.println(this.name + " is running with " + (i+1) + " time");
            }
        }
        finally{
            lock.unlock();
        }
    }
}

package com.lth.threadExample;

import java.util.concurrent.locks.ReentrantLock;

public class LockExample {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock(true);
        for(int i =0 ; i<6; i++){
            WorkerLock worker = new WorkerLock(lock , "Worker " + (i + 1));
            worker.start();
        }
    }
}

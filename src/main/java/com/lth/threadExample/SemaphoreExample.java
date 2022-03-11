package com.lth.threadExample;

import java.util.concurrent.Semaphore;
public class SemaphoreExample {

    private static final Semaphore semaphore = new Semaphore(4);

    public static void main(String[] args) {
        System.out.println("Total available Semaphore permits: " + semaphore.availablePermits());
        for (int i = 1; i <= 6; i++) {
            WorkerThread atmWorker = new WorkerThread(semaphore, "AMT " + i);
            atmWorker.start();
        }
    }
}

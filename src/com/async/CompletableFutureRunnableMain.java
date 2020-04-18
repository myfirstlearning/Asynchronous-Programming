package com.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureRunnableMain {


    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Runnable runnableTask = ()-> {
            System.out.println("I am running asynchronously!!!!" + Thread.currentThread().getName());
        };
        CompletableFuture.runAsync(runnableTask, executorService);

        //Thread.sleep(200);

        //shuttingDown the executor service
        executorService.shutdown();
    }


}

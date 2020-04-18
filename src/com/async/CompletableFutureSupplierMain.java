package com.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

public class CompletableFutureSupplierMain {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Supplier<String> supplier = () -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return Thread.currentThread().getName();
        };

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(supplier, executorService);

        //completableFuture.complete("Too Long!!!");//Makes completableFuture to complete force fully
        //completableFuture.obtrudeValue("Obtrude Value!!!");

        String result = completableFuture.join();//join returns the result
        System.out.println("Result :" + result);

        //completableFuture.complete("Too Long!!!");

        completableFuture.obtrudeValue("Obtrude Value!!!");//replace the result with forced value

        result = completableFuture.join();
        System.out.println("Result :" + result);


        executorService.shutdown();


    }


}

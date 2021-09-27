package com.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @Autor wangwei
 * @Data 2021/6/1 10:45
 */
public class FutureTaskDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(() -> 8+8);
        ExecutorService execute = Executors.newFixedThreadPool(1);
        execute.submit(futureTask);
        System.out.println(futureTask.get());
    }
}

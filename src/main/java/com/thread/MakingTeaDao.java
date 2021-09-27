package com.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @Autor wangwei
 * @Data 2021/6/1 10:55
 */
public class MakingTeaDao {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // ft2 完成洗茶壶、洗茶杯、拿茶叶的任务
        FutureTask<String> ft2 = new FutureTask<>(new Task2());

        // t1 完成洗水壶、烧开水、泡茶的任务
        FutureTask<String> ft1 = new FutureTask<>(new Task1(ft2));

        Thread t1 = new Thread(ft1);
        t1.start();

        Thread t2 = new Thread(ft2);
        t2.start();

        System.out.println(ft1.get());


    }

    private static class Task1 implements Callable<String> {
        private FutureTask<String> ft2;
        public Task1(FutureTask<String> ft2) {
            this.ft2 = ft2;
        }

        @Override
        public String call() throws Exception {
            System.out.println("T1 -> 洗水壶........");
            TimeUnit.SECONDS.sleep(3);
            System.out.println("T1 -> 烧开水.......");
            TimeUnit.SECONDS.sleep(5);
            String s = ft2.get();
            System.out.println("T1 -> 拿到茶叶......." + s);
            System.out.println("T1 -> 开始泡茶............");
            TimeUnit.SECONDS.sleep(10);
            return "上茶";
        }
    }

    private static class Task2 implements Callable<String> {

        @Override
        public String call() throws Exception {
            System.out.println("T2 -> 洗茶壶.........");
            TimeUnit.SECONDS.sleep(3);
            System.out.println("T2 -> 洗茶杯.........");
            TimeUnit.SECONDS.sleep(5);
            System.out.println("T2 -> 拿茶叶.........");
            TimeUnit.SECONDS.sleep(10);
            return "黄山毛峰";
        }
    }
}

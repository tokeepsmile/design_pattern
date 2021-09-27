package com.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @Autor wangwei
 * @Data 2021/6/1 11:30
 */
public class MakingTeaDaoByCompletabeFuture {
    public static void main(String[] args) {
        //洗水壶、烧开水
        CompletableFuture<Void> f1 = CompletableFuture.runAsync(() -> {
            System.out.println("f1 -> 洗水壶");
            sleep(3);
            System.out.println("f1 -> 烧开水");
            sleep(5);
        });

        // 洗茶壶、洗茶杯、拿茶叶
        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("f2 -> 洗茶壶");
            sleep(3);
            System.out.println("f2 -> 洗茶杯");
            sleep(3);
            System.out.println("f2 -> 拿茶叶");
            return "西湖龙井";
        });

        CompletableFuture<String> f3 = f1.thenCombine(f2, (__, tf) -> {
            System.out.println("f3 -> 拿到茶叶" + tf);
            System.out.println("f3 -> 泡茶");
            sleep(10);
            return "上茶" + tf;
        });

        System.out.println(f3.join());
    }

    private static void sleep(int time) {
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

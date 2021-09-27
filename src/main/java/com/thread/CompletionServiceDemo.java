package com.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.*;

/**
 * @Autor wangwei
 * @Data 2021/6/1 12:26
 */
public class CompletionServiceDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CompletionService<String> completionService = new ExecutorCompletionService<>(executorService);
        List<Future<String>> futureList = new ArrayList<>();
        futureList.add(completionService.submit(CompletionServiceDemo::addressService1));
        futureList.add(completionService.submit(CompletionServiceDemo::addressService2));
        futureList.add(completionService.submit(CompletionServiceDemo::addressService3));
        String city = null;
        try {
            for (int i = 0; i < 3; i++) {
                city = completionService.take().get();
                if (Objects.nonNull(city)){
                    break;
                 }
            }
        }finally {
            for (Future<String> future : futureList) {
                future.cancel(true);
            }
        }
        System.out.println(city);

    }

    private static String addressService1() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "beijing";
    }

    private static String addressService2() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "shanghai";
    }

    private static String addressService3() {
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "anhui";
    }
}

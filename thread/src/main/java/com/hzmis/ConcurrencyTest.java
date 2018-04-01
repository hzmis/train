package com.hzmis;

/**
 * @author elephant-huang-zhao
 * @date 2018/3/31
 */
public class ConcurrencyTest {
    public static final long count = 1000000001;

    public static void main(String[] args) throws InterruptedException {
        concurency();
        serial();
    }

    private static void serial() {
        long begin = System.currentTimeMillis();
        int a = 0, b = 0;
        for (int i = 0; i < count; i++) {
            a += 5;
        }
        for (int i = 0; i < count; i++) {
            b--;
        }
        long time = System.currentTimeMillis() - begin;
        System.out.println("serial :" + time + "ms , a: " + a + ", b: " + b);
    }

    private static void concurency() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread thread = new Thread(() -> {
            int a = 0;
            for (int i = 0; i < count; i++) {
                a += 5;
            }
        });
        thread.start();
        int b = 0;
        for (int i = 0; i < count; i++) {
            b--;
        }
        thread.join();
        long time = System.currentTimeMillis() - begin;
        System.out.println("concurrency :" + time + "ms, b: " + b);

    }
}

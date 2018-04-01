package com.hzmis;

/**
 * @author elephant-huang-zhao
 * @date 2018/4/1
 */
public class NoVisibility {
    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            while (!ready) {
                Thread.yield();
                System.out.println(number);
            }
        }
    }

    public static void main(String[] args) {
        new ReaderThread().start();
        number = 33;
        ready = true;
    }
}

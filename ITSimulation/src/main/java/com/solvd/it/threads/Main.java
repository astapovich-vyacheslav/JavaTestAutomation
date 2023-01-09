package com.solvd.it.threads;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    public static void main(String[] args) {


        ExecutorService executorService = Executors.newFixedThreadPool(5);
        try {
            for (int i = 0; i < 5; i++) {
                executorService.execute(new DatePrintThread("A"));
                Thread.sleep(500);
                executorService.execute(new DatePrintThread("B"));
                Thread.sleep(500);
                executorService.execute(new DatePrintThread("C"));
                Thread.sleep(500);
            }
        } catch (Exception ignored) {
        }
        executorService.shutdown();

        DeadLocker1 deadLocker1 = new DeadLocker1();
        DeadLocker2 deadLocker2 = new DeadLocker2();
        deadLocker1.start();
        deadLocker2.start();
    }

    private static class DatePrintThread extends Thread {
        String name;

        public DatePrintThread(String name) {
            this.name = name;
        }

        public void run() {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(name + ": " + dtf.format(now));
            }
        }
    }

    private static class DeadLocker1 extends Thread {
        public void run() {
            synchronized (lock1) {
                System.out.println("DeadLocker 1 holding lock 1");
                try {
                    Thread.sleep(10);
                } catch (Exception ignored) {
                }
                System.out.println("DeadLocker 1 waiting for lock 2");

                synchronized (lock2) {
                    System.out.println("DeadLocker 1 holding lock 1 and 2");
                }
            }
        }
    }

    private static class DeadLocker2 extends Thread {
        public void run() {
            synchronized (lock2) {
                System.out.println("DeadLocker 2 holding lock 2");
                try {
                    Thread.sleep(10);
                } catch (Exception ignored) {
                }
                System.out.println("DeadLocker 2 waiting for lock 1");

                synchronized (lock1) {
                    System.out.println("DeadLocker 2 holding lock 1 and 2");
                }
            }
        }
    }
}


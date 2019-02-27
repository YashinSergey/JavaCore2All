package ru.geekbrains.classes.lesson5;

import static java.lang.Thread.sleep;

public class DaemonThread {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread completed.");
            }
        });
        thread.setDaemon(true);  // Программа завершится не дожидаясь завершения работы потока - демона
        thread.start();
        System.out.println("HomeWork thread completed.");
    }
}

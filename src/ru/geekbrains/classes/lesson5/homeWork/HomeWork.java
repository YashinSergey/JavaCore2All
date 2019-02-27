package ru.geekbrains.classes.lesson5.homeWork;

import java.util.Arrays;

public class HomeWork {


    public static void main(String[] args) throws InterruptedException {
        HomeWork m = new HomeWork();
        m.createArray();
        m.createRunnable();
    }

    public void createArray(){
        final int SIZE = 10_000_000;
        long start;
        long finish;
        float[] arr = new float[SIZE];

        Arrays.fill(arr, 1.0f); // заполнение всего массива arr элементами со значением "1".
        start = System.currentTimeMillis();
        for(int i = 0; i < arr.length; i++){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        finish = System.currentTimeMillis() - start;
        System.out.printf("Первый метод. Время выполненияоперации: %d %s%n", finish, "мс.");
    }

    public void createRunnable() throws InterruptedException {
        final int size = 10000000;
        final int h = size / 2;
        long timePoint1, timePoint2, timePoint3, timePoint4, timePoint5, timePoint6, timePoint7, timePoint8;

        float[] arr = new float[size];

        Arrays.fill(arr, 1);

        timePoint1 = System.currentTimeMillis();
        float[] arr1 = new float[h];
        float[] arr2 = new float[h];
        System.arraycopy(arr, 0, arr1, 0, h);
        System.arraycopy(arr, h, arr2, 0, h);
        timePoint2 = System.currentTimeMillis() - timePoint1;
        System.out.printf("Второй метод. Время разбивки массива: %d %s%n", timePoint2, "мс.");

        timePoint3 = System.currentTimeMillis();
        Thread firstTread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < arr1.length; i++){
                    arr1[i] = (float)(arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });
        firstTread.start();
        timePoint4 = System.currentTimeMillis() - timePoint3;
        System.out.printf("Второй метод. Время работы потока %d: %d %s%n", firstTread.getId(), timePoint4, "мс.");

        timePoint5 = System.currentTimeMillis();
        Thread secondThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < arr2.length; i++){
                    arr2[i] = (float)(arr2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });
        secondThread.start();
        timePoint6 = System.currentTimeMillis() - timePoint5;
        System.out.printf("Второй метод. Время работы потока %d: %d %s%n", secondThread.getId(), timePoint6, "мс.");

        firstTread.join();
        secondThread.join();
        
        timePoint7 = System.currentTimeMillis();
        System.arraycopy(arr1, 0, arr, 0, h);
        System.arraycopy(arr2, 0, arr, h, h);
        timePoint8 = System.currentTimeMillis() - timePoint7;
        System.out.printf("Второй метод. Время склейки массива: %d %s%n", timePoint8, "мс.");
    }
}

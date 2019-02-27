package ru.geekbrains.classes.lesson5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Thread.sleep;

public class ShearedVelueExemple {

    private static int counter = 0;

    // Критическая секция - область кода, в которую может входить только один поток.
    private static synchronized void incrementCounter(){  // метод с модификатором synchronized в один момент
        counter++;                                        // времени может использоватсься только одним потоком
    }


    public static void main(String[] args) throws InterruptedException {
        Runnable incrementer = new Runnable() {

            @Override
            public void run() {
                try {
                    sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for(int i = 0; i < 10; i++) {
                    // инкремент не атомарный( состоиз из более чем одной инструкции), т.е. чтобы провести эту операцию нужно:
                    // 1) считать значение
                    // 2) увеличить значение на единицу
                    // 3) записать значение обратно
                    incrementCounter();
                }
            }
        };

        List<Thread> threadList = new ArrayList<>();



        // !!самостоятельно изучить Concurrent

        for(int i = 0; i < 10; i++) {
            Thread thr = new Thread(incrementer);
            threadList.add(thr);
            thr.start();
        }

        for(Thread thr: threadList){
            thr.join();
        }

        System.out.println(counter);

        // потокозащищенная коллекция
        List<Object> list = Collections.synchronizedList(new ArrayList<>()); // синхронизация коллекций (в данном случае ArrayList)
    }
}



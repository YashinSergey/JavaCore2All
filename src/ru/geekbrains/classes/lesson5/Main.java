package ru.geekbrains.classes.lesson5;

public class Main {

    static class MyThread extends Thread{                         // 1-й способ создания потока

        @Override
        public void run() {

            for(int i = 0; i < 10; i++) {
                Main.sleep(10);
                System.out.printf("Thread id: %d counter: %d%n", getId(), i);
            }
        }
    }

    public static void main(String[] args) {
        MyThread myTread = new MyThread();                        // 1-й способ создания потока
        myTread.start();                                          // !!! не забывать про метод start()

        new Thread(){                                             // 2-й способ создания потока
            @Override
            public void run() {
                for(int i = 0; i < 10; i++) {
                    Main.sleep(10);
                    System.out.printf("Thread id: %d counter: %d%n", getId(), i);
                }
            }
        }.start();

        new Thread(new Runnable() {                               // 3-й способ создания потока (обратить внимание на вывод ID)
            @Override
            public void run() {
                for(int i = 0; i < 10; i++) {
                    Main.sleep(10);
                    System.out.printf("Thread id: %d counter: %d%n", Thread.currentThread().getId(), i);
                }
            }
        }).start();
    }

    private static void sleep(long millis){
        try{
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

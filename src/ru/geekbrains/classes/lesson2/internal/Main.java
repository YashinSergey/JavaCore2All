package ru.geekbrains.classes.lesson2.internal;

public class Main {

    public class Internal{ // внутренний класс

    }

    public static class StaticInternal{ // внутренний класс
        public int value;
    }

    public static void main(String[] args) {
        Internal internal = new Main().new Internal(); // экземпляр внутреннего класса создаётся только
        // после экземпляра основного класса (для нестатического класса!)

        StaticInternal staticInternal = new StaticInternal();

        class Internal1{ // анонимный класс

        }

        new Participant(){

            @Override
            public String getName() {
                return null;
            }

            @Override
            public boolean isOnDistance() {
                return false;
            }

            @Override
            public void run(int distance) {

            }

            @Override
            public void jump(int height) {

            }

            @Override
            public void swim(int distance) {

            }
        };

    }
}

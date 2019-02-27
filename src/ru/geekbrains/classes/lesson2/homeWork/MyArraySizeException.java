package ru.geekbrains.classes.lesson2.homeWork;

public class MyArraySizeException extends Exception {

    public MyArraySizeException() {
        super("\nНеверно задан размер массива.");
    }
}

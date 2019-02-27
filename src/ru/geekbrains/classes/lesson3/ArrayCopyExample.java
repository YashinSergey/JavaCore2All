package ru.geekbrains.classes.lesson3;

public class ArrayCopyExample {
    public void ArrayCopy() {
        int[] arr = {1, 2, 3, 4};
        int[] arr_new = new int[10];
        System.arraycopy(arr, 0, arr_new, 0, arr.length);
        arr = arr_new;
        arr_new = null;
    }
}

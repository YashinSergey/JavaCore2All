package ru.geekbrains.classes.lesson3;

import java.util.ArrayList;

public class ArrayListExamples {

    public void createArrayList1() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1); // Добавляем эдемент в массив
        list.add(2);
        list.add(3);
        System.out.printf("list[0] = %d%n", list.get(0));

        System.out.println("Данный элемент имеет индекс № " + list.indexOf(2));
    }


    public void createArrayList2() {
        ArrayList<String> list = new ArrayList<>();
        list.add("A"); // Добавляем эдемент в массив
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("E");
        System.out.println(list + "\n");
        list.add(1, "A0"); // добавляем элемент на позицию с индексом 1, при этом все элементы сдвигаются вправо
        System.out.println(list);
        list.remove("E"); // удаляем из массива объект с указанным значением(удаляет только один элемент).
        System.out.println(list);
        list.remove(2); // удаляем из массива объект с указанным индексом.
        System.out.println(list);
    }

    public void fromArrayListToArrayExample(){
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(1);
        a.add(2);
        a.add(3);
        Integer b[] = new Integer[a.size()];
        a.toArray(b);
    }
}
/*
boolean add(E e)              Добавить элемент в конец списка

void add(int index, E e)      Добавить элемент на позицию index

E get(int index)              Получить элемент списка с индексом index

void set(int index, E e)      Заменить элемент на позиции index

boolean remove(int index)     Удалить элемент списка с заданной позиции, вернуть — true,
                              если объект был удален, false — в противном случае

boolean remove(E e)           Удалить заданный объект из списка, вернуть — true, если
                              объект был удален, false — в противном случае

void trimToSize()             «Урезать» емкость списка до его размера

int size()                    Получить размер списка

ensureCapacity(int capacity)  Увеличить емкости списка до значения capacity, только если
                              текущая емкость меньше указанной

boolean contains(E e)         Проверить на присутствие указанного элемента в списке
 */

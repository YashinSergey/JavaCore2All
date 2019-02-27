package ru.geekbrains.classes.lesson3;

import java.util.*;

public class CollectionsReview {
    public static void main(String[] args) {

        // List

        // Динамический массив
        List<String> arrayList = new ArrayList<>();
        arrayList.add("aaa");

        // быстро
        arrayList.get(0); // Поиск элемента по индексу

        // медленно
        arrayList.add(0, "bbb");

        // медленно (Просмотр всего массива)
        arrayList.contains("bbb"); // поиск эдемента в масииве по значению

        // Двусвязный список
        LinkedList<String> linkedList  = new LinkedList<>();
        linkedList.add("aaa");

        // медленно
        arrayList.get(2);

        // быстро работают методы двунаправленной очереди стека
        Deque<String> deque = linkedList;
        deque.addFirst("A"); // добавляет элемент в начало списка
        deque.addLast("Z"); // Добавляет элемент в конец списка

        // Set - множества
        // Элементы множества должны быть уникальны
        // У элементов должен быть корректно преопределен equals b hashCode

        Set<String> hashSet = new HashSet<>();
        hashSet.add("bbb");

        // быстро
        // !!! Нельзя итерировать Set для поиска элементов(теряется смыл использования Set)
        hashSet.contains("bbb");

        // сохраняет порядок добавления элементов
        Set<String> linkedHashSet = new LinkedHashSet<>();

        // Элементы будут уникальны и отсортированны
        // Элементы должны имплементировать интерфейс Comparable
        Set<String> treeSet = new TreeSet<>();
        treeSet.add("ccc");


        // Map - структура ключ -> значение
        Map<String, String> dictionary = new HashMap<>();

        // быстрый поиск по ключу
        dictionary.get("bbb");

        // Медленный поиск по значению.
        dictionary.containsValue("AAA");

        Map<String, String> dictionary2 = new LinkedHashMap<>();

        Map<String, String> dictionary3 = new TreeMap<>();

    }
}

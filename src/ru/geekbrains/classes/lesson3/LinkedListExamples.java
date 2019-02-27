package ru.geekbrains.classes.lesson3;

import java.util.LinkedList;

public class LinkedListExamples {

    public void linkedListExample(){
        LinkedList <String> w = new LinkedList<>();
        w.add ( "F" );
        w.add ( "B" );
        w.add ( "D" );
        w.add ( "Е" );
        w.add ( "C" );
        System.out.println("1. LinkedList w: " + w );
        w.addLast ( "Z" );
        w.addFirst ( "A" );
        System.out.println("2. LinkedList w: " + w );
        w.add ( 1 , "А2" );
        System.out.println ( "3. LinkedList w: " + w );
        w.remove ( "F" );
        System.out.println("4. LinkedList w: " + w );
        w.remove ( 2 );
        System.out.println ( "5. LinkedList w: " + w );
        w.removeFirst ();
        w.removeLast ();
        System.out.println ( "6. LinkedList w: " + w );
        String val = w.get ( 2 );                        // Получение индекса элемента с помощью get()
        w.set ( 2 , val + " изменено" );                 // Изменение элемента списка с помощью set(index, новое значение)
        System.out.println ( "7. LinkedList w: " + w );
    }

}


/*
addFirst(E e), offerFirst(E e)            Добавить элемент в начало списка

addLast(E e), offerLast(E e), add(E e)    Добавить элемент в конец списка

getFirst(), peekFirst()                   Получить первый элемент списка

removeFirst(), pollFirst()                Получить первый элемент и удалить его из списка

getLast(), peekLast()                     Получить последний элемент списка

removeLast(), pollLast()                  Получить последний элемент и удалить его из списка

 */
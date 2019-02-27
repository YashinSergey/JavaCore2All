package ru.geekbrains.classes.lesson3;

import java.util.*;

public class SetExamples {

    public void createHashSet(){
        Set<Integer> setOfInt = new HashSet<>();
        setOfInt.add(1);
        setOfInt.add(2);
        setOfInt.add(3);
    }

    public void createLinkedHashSet(){
        // Когда нужно сохранить порядок добавления элементов
        Set<Integer> linkedSet = new LinkedHashSet<>();
        linkedSet.add(1);
        linkedSet.add(2);
        linkedSet.add(3);
        System.out.println(linkedSet);
    }


    public void createTreeSet(){
        // O(log(n))
        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(1);
        treeSet.add(2);
        treeSet.add(3);
        treeSet.add(3);
    }

    public void createMap(){
        Map<String, String> dict = new HashMap<>();
        dict.put("dot","точка");
        dict.put("comma","запятая");
        dict.put("language","язык");
        System.out.println(dict);
        System.out.println(dict.get("dot"));
        System.out.println(dict.containsKey("comma")); // containsKey(поиск элемента. Возвращает true или false) - работает быстро
        System.out.println(dict.containsValue("запятая")); // containsValue - работает медленно

        Map<String, String[]> dict1 = new HashMap<>();
        dict1.put("dot", new String[] {"точка", "пятнышко", "крошечная вещь"});
        dict1.put("comma", new String[] {"запятая"});
        dict1.put("language", new String[] {"язык", "реч", "брань"});
    }

    public static void main(String[] args) {
        SetExamples s = new SetExamples();
        s.createLinkedHashSet();
        s.createMap();
    }

    /*
    Условия корректности для метода hashCode:(при переопределении метода hashCode, он должен выполнять эти условия)
        1. a.equals(b)    => a.hashCode() == b.hashCode()
        2. !a.equals(b)  => a.hashCode() == b.hashCode() || a.hashCode() !== b.hashCode()
     */

    public void equalsExample(){
        Integer i1 = 1;
        Integer i2 = new Integer(1);

        if(i1.equals(i2)){
            System.out.println(i1 + " = " + i2);
        }
        /*
        Условия корректности метода equals: (при переопределении метода equals, он должен выполнять эти условия)
            1. a.equals(a)
            2. a.equals(b) == true => b.equals(a)
            3. a.equals(b) && b.equals(c) => a.equals(c)
         */
    }


}

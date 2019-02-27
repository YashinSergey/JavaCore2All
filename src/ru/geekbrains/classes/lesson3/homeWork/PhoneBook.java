package ru.geekbrains.classes.lesson3.homeWork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private Map<String, List<String>> phoneBook;

    public PhoneBook(){
        this.phoneBook = new HashMap<>();
    }

    public void add(String name, String phoneNumber){
        List<String> phones;
        if(phoneBook.containsKey(name)){
            phones = phoneBook.get(name);
        }else{
            phones = new ArrayList<>();
            phoneBook.put(name,phones);
        }
        phones.add(phoneNumber);
    }

    public List<String> get(String name){
       return phoneBook.get(name);
    }
}

package ru.geekbrains.classes.lesson3.homeWork;

public class Main {
    public static void main(String[] args) {
        Words w = new Words();
        w.createArr();
        System.out.println();

        PhoneBook book = new PhoneBook();
        book.add("БздашекЗападловский", "111-11-11");
        book.add("ОливьеЖюйДаГлотай","222-22-22");
        book.add("СпироНаполносракис","333-33-33");
        book.add("МаразмусНолемоций", "444-44-44");
        book.add("СпироНаполносракис","555-55-55");
        book.add("ОливьеЖюйДаГлотай","777-77-77");

        System.out.println(book.get("БздашекЗападловский"));
        System.out.println(book.get("ОливьеЖюйДаГлотай"));
        System.out.println(book.get("СпироНаполносракис"));
    }
}

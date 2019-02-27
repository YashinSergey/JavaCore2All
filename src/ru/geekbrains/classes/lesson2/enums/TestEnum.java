package ru.geekbrains.classes.lesson2.enums;

public class TestEnum {


    public static void main(String[] args) {
        Color color = Color.RED;
        Color color1 = Color.BLUE;
        System.out.printf("Цвет %s : %s", color, color.getRuName());  // %s - это ссылка на указанные далее атрибуты
        if(color.equals(Color.RED)){
        }


    }
}

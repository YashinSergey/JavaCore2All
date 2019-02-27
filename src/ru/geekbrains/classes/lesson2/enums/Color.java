package ru.geekbrains.classes.lesson2.enums;

public enum Color {  // по умолчанию является final

    BLACK("черный"),
    WHITE("белый"),
    GREEN("зеленый"),
    RED("красный"),
    BLUE("синий");

    public String ruName;
    public int   colorCode;

    public String getRuName() {
        return ruName;
    }


    Color(String ruName) {  // по умолчанию является private
        this.ruName = ruName;
    }
}

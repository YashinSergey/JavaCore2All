package ru.geekbrains.classes.lesson2.enums;

public final class OldColor {

    public static final OldColor BLACK = new OldColor("черный");
    public static final OldColor WHITE = new OldColor("белый");
    public static final OldColor GREEN = new OldColor("зеленый");
    public static final OldColor RED = new OldColor("красный");
    public static final OldColor BLUE = new OldColor("синий");

    private String ruName;

    public OldColor(String ruName) {
        this.ruName = ruName;
    }

    public String getRuName() {
        return ruName;
    }

}

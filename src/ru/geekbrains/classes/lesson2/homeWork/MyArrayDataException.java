package ru.geekbrains.classes.lesson2.homeWork;

public class MyArrayDataException extends Exception {

    private int rowIndex;
    private int colIndex;
    private String value;

    public MyArrayDataException(int rowIndex, int colIndex, String value) {
        this(rowIndex, colIndex, value, null);
    }

    public MyArrayDataException(int rowIndex, int colindex, String value, Throwable cause) {
        super(String.format("\nНевозможно преобразовать данные  в ячейке: [%d][%d]. Некорректное значение: [%s]",
                rowIndex, colindex, value), cause);
        this.rowIndex = rowIndex;
        this.colIndex = colindex;
        this.value = value;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public int getColIndex() {
        return colIndex;
    }

    public String getValue() {
        return value;
    }
}

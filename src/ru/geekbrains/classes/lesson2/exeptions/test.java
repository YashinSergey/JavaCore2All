package ru.geekbrains.classes.lesson2.exeptions;

public class test {
    public static void main ( String args []) {
        System . out . println ( "Начало" );
        try {
            int а = 0 ;
            int b = 42 / а;
        } catch ( ArithmeticException e ) {
            e . printStackTrace ();
        }
        System . out . println ( "Конец" );
    }
}

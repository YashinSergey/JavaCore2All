package ru.geekbrains.classes.lesson2.exeptions;

public class Main {

    public static void main(String[] args) {
        try {
            aaa();
        } catch (ArithmeticException ex) {
            // System.out.println("Арифметическая ошибка");
            throw ex;
        } catch (MyException ex){
            System.out.println("Моё исключение");
        }catch (Exception ex) {
            System.out.println("Неизвестная ошибка");
        } finally {
            System.out.println("Complete");
        }
    }

    public static void aaa() throws Exception {
        bbb();
    }

    public static void bbb() throws Exception {
        ccc();
    }

    public static void ccc() throws Exception {
        throw new MyException("Ошибка");
    }

}

package ru.geekbrains.classes.lesson2.homeWork;




public class Array {


    public static int array(String[][] arr) throws MyArraySizeException, MyArrayDataException {

        if (arr.length != 4) {
            throw new MyArraySizeException();
        }

        int num = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i].length != 4) {
                throw new MyArraySizeException();
            }
            for(int j = 0; j < arr[i].length; j++){
                try {
                    num = num + Integer.parseInt(arr[i][j]);
                }catch(NumberFormatException e){
                    throw new MyArrayDataException(i,j, arr[i][j], e);
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        String[][] arr = new String[][]{
                {"1", "1", "1", "1"},
                {"2", "2", "2", "2"},
                {"3", "3", "3", "3"},
                {"4", "4", "4", "/"}};

        try {
            System.out.println("Сумма значений в массиве: " + array(arr));
        } catch (MyArraySizeException se) {
            se.printStackTrace();
        } catch (MyArrayDataException de) {
            de.printStackTrace();
        }
        System.out.println("The end.");
    }
}

package ru.geekbrains.classes.lesson4.hw;

import javax.swing.*;

class Main {

    private static Window window;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                window = new Window();
            }
        });
    }
}

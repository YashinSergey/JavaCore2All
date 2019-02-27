package ru.geekbrains.classes.lesson4.hw;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class Window extends JFrame {
    private JFrame frame;
    private JPanel inputPanel;
    private JPanel outputPanel;
    private TextField textField;
    private JButton sendButton;
    private JList<String> list;
    private DefaultListModel<String> listModel;
    private JScrollPane scroll;

    public Window(){
        super("SY-Chat");
        frame = new JFrame();
        frame.setBounds(700,200,600,600);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);


        frame.setVisible(true);
        textField.requestFocus();
    }

}

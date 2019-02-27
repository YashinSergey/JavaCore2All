package ru.geekbrains.classes.lesson4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class BorderLayoutExample extends JFrame {
    private JButton[] jbs;
    private JButton button;
    private JTextField textField;
    private JList<String> list;
    private DefaultListModel<String> listModel; // Создаётся для того чтобы была
                                                // возможность добавлять элементы в list
    private JPanel panel;



    public BorderLayoutExample(){
        setTitle("Test Window");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(700,300,500,500);
        jbs = new JButton[5];
        for(int i = 0; i < 5; i++){
            jbs[i] = new JButton("#" + i);
        }
        setLayout(new BorderLayout());
        add(jbs[0], BorderLayout.EAST);
        add(jbs[1], BorderLayout.WEST);

        textField = new JTextField();


        listModel = new DefaultListModel<>();
        list = new JList<>(listModel);
        add(list , BorderLayout.CENTER);

        panel = new JPanel();
        panel.add(jbs[2], BorderLayout.EAST);
        panel.add(textField, BorderLayout.WEST);
        textField.setSize(40,10);
        jbs[2].addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listModel.add(0,textField.getText());
            }
        });
        add(panel, BorderLayout.SOUTH);

        setVisible(true);
    }


    public void borderLayoutExample2(){
        setTitle("Test Window№2");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300,300,400,400);
        button = new JButton ("Button 1 (PAGE_START)");
        add(button, BorderLayout.PAGE_START );
        button = new JButton("Button 2 (CENTER)");
        button.setPreferredSize(new Dimension(200, 100));
        add( button, BorderLayout.CENTER);
        button = new JButton ("Button 3 (LINE_START)");
        add(button, BorderLayout.LINE_START );
        button = new JButton("Long-Named Button 4 (PAGE_END)");
        add(button, BorderLayout.PAGE_END);
        button = new JButton ("5 (LINE_END)");
        add(button, BorderLayout.LINE_END);
        setVisible(true);
    }
}


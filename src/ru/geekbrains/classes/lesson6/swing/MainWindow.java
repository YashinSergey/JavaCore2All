package ru.geekbrains.classes.lesson6.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class MainWindow extends JFrame implements MessageSender {

    private JTextField textField;
    private JButton button;
    private JScrollPane scrollPane;
    private JList<Message> list;
    private DefaultListModel<Message> listModel;
    private JPanel panel;

    private NetWork network;

    public MainWindow() {
        setTitle("Сетевой чат");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(200, 200, 500, 500);

        setLayout(new BorderLayout());   // выбор компоновщика элементов

        listModel = new DefaultListModel<>();
        list = new JList<>(listModel);
        list.setCellRenderer(new MessageCellRenderer());

        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(list, BorderLayout.SOUTH);
        panel.setBackground(list.getBackground());
        scrollPane = new JScrollPane(panel);
        add(scrollPane, BorderLayout.CENTER);

        textField = new JTextField();
        button = new JButton("Send");
        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text  = textField.getText();
                submitMessage("user", text);
                textField.setText(null);
                textField.requestFocus();
                network.sendMassage(text);
            }
        });

        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                String text  = textField.getText();
                if (e.getKeyCode()== KeyEvent.VK_ENTER) {
                    submitMessage("user", text);
                    textField.setText(null);
                    textField.requestFocus();
                    network.sendMassage(text);
                }
            }
        });

        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent evt) {
                list.ensureIndexIsVisible(listModel.size() - 1);
            }
        });

        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(button, BorderLayout.EAST);
        panel.add(textField, BorderLayout.CENTER);

        add(panel, BorderLayout.SOUTH);

        try {
            network = new NetWork("localhost", 7777, this);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        setVisible(true);
    }

    @Override
    public void submitMessage(String user, String message) {
        if (message == null || message.isEmpty()) {
            return;
        }
        listModel.add(listModel.size(), new Message(user, message));
        list.ensureIndexIsVisible(listModel.size() - 1);
    }
}
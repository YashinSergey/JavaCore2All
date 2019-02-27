package ru.geekbrains.lesson7;

import ru.geekbrains.lesson7.auth.AuthServiceImpl;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ClientHandler {

    private static final Pattern MESSAGE_PATTERN = Pattern.compile("^/w (.+) (.+)$");
    private Thread handleThread;
    private DataInputStream inp;
    private DataOutputStream out;
    private ChatServer server;
    private String userName;
    private Socket socket;
    private AuthServiceImpl authServiceImpl;

    public ClientHandler(){
    }

    public ClientHandler(String username, Socket socket, ChatServer server) throws IOException {
        this.userName = username;
        this.socket = socket;
        this.server = server;
        this.inp = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());

        this.handleThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (!Thread.currentThread().isInterrupted()) {
                        String msg = inp.readUTF();
                        System.out.printf("Message from user %s: %s%n", userName, msg);
                        Matcher matcher = MESSAGE_PATTERN.matcher(msg);
                        if (matcher.matches()) {
                            userName = matcher.group(1);
                            msg = matcher.group(2);
                            server.sendMessage(userName, msg);

                        } else {
                            System.out.println("Error typing name");
                        }
                    }
                    // TODO реализовать прием сообщений от клиента и пересылку адресату через сервер
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    System.out.printf("%s had disconnected%n", userName);
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        handleThread.start();
    }

    public DataInputStream getInp() {
        return inp;
    }

    public DataOutputStream getOut() {
        return out;
    }
}
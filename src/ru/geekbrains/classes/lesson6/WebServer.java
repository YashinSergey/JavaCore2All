package ru.geekbrains.classes.lesson6;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
    public static void main(String[] args) throws InterruptedException {
        try(ServerSocket serverSocket = new ServerSocket(7777)){
            while(true) {
                Socket socket = serverSocket.accept(); // accept переводит основной поток в режим
                                                       // ожидания до момента подключения кого-либо к серверу
                System.out.println("Client connected!");

                try(BufferedReader input =
                            new BufferedReader(
                                    new InputStreamReader(socket.getInputStream())); PrintWriter output =
                                            new PrintWriter(socket.getOutputStream())){
                    while(!input.ready());

                    while (input.ready()){
                        System.out.println(input.readLine());
                    }

                    output.println("HTTP/1.1 200 OK");
                    output.println("Content-Type: text/html; charset=utf-8");
                    output.println();
                    output.println("<p>Привет всем!</p>");
                    output.flush(); // отправляет все буфферизованные данные по назначению
                }
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
}

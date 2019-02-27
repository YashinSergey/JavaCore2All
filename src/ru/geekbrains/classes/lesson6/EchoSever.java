package ru.geekbrains.classes.lesson6;

import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.*;

public class EchoSever {

    private static List<ClientHandler> clientHandlerList = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(7777)){
            System.out.println("Server started!");

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try(Scanner scanner = new Scanner(System.in)) {
                        System.out.print("Enter your message: ");
                        while (!Thread.currentThread().isInterrupted() && scanner.hasNextLine()){
                            String msg = scanner.nextLine();
                            Iterator<ClientHandler> iterator = clientHandlerList.iterator();
                            while(iterator.hasNext()){
                                ClientHandler handler = iterator.next();
                                try{
                                handler.sendMessage(msg);
                                }catch(EOFException | SocketException ex){
                                System.out.println("The client disconnected.");
                                ex.printStackTrace();
                                iterator.remove();
                                }
                            }
                            System.out.println("Enter your message: ");
                        }
                    }catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

            while(true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected!");

                clientHandlerList.add(new ClientHandler(socket));
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
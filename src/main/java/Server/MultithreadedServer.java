package Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MultithreadedServer{
    private static Socket clientSocket;
    private static ServerSocket server;
    public static void main(String[] args){
        ServerSocket server = null;
        try {
            server = new ServerSocket(8088);
            System.out.println("Сервер запущен!");
            while (true){
                clientSocket = server.accept();
                System.out.println("Клиент "+clientSocket.getInetAddress()
                        .getHostAddress()+ " подключился!");
                ClientHandler clientThread = new ClientHandler(clientSocket);
                new Thread(clientThread).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package org.example.controllers;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerController {
    public static void main(String[] args) throws IOException {
        int portNumber = 8080;
        ServerSocket serverSocket = new ServerSocket(portNumber);
        System.out.println("Server started on port " + portNumber);

        // Wait for a client to connect
        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected from " + clientSocket.getInetAddress().getHostAddress());

        // Process client requests
        // ...

        // Close the socket and server socket when done
        clientSocket.close();
        serverSocket.close();
    }
}

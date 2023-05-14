package org.example.controllers;

import org.example.entities.Player;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerController {
    public static void main(String[] args) throws IOException {

        PlayerController contP = new PlayerController();

        int portNumber = 8080;
        ServerSocket serverSocket = new ServerSocket(portNumber);
        System.out.println("Server started on port " + portNumber);

        while (true) {
            // Wait for a client to connect
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected from " + clientSocket.getInetAddress().getHostAddress());

            //Open input and output channels
            InputStream istream = clientSocket.getInputStream();
            OutputStream ostream = clientSocket.getOutputStream();

            //Read the next message from input
            byte[] typebuffer = new byte[1024];
            int bytesRead = istream.read(typebuffer);
            String input = new String(typebuffer, 0, bytesRead);

            System.out.println(input);

            String [] ops = input.split(",");

            //Do operation
            switch (ops[0]) {
                case "new":
                    String playerName = ops[1];

                    contP.addPlayer(playerName);

                    break;

                case "active":

                    for (String s : contP.getActivePlayersString()) {
                        byte[] playername = s.getBytes();
                        ostream.write(playername);
                        ostream.write((",").getBytes());
                    }
                    ostream.flush();

                    break;

                case "time":

                    for (Player p : contP.getActivePlayers()) {
                        p.setX(48.879304F);
                        p.setY(2.357054F);
                    }

                    contP.setPlayingPlayers(contP.getActivePlayers());

                    contP.setActivePlayers(new ArrayList<>());
                    break;

                case "move":

                    String x = ops[1];
                    String y = ops[2];

                    for (Player p : contP.getPlayingPlayers()) {
                        p.setX(Float.parseFloat(x));
                        p.setY(Float.parseFloat(y));
                    }
            }
        }

        // Process client requests
        // ...

        // Close the socket and server socket when done
        //clientSocket.close();
        //serverSocket.close();
    }
}

package org.example.main;

import org.example.controllers.ServerController;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {

        ServerController contS = new ServerController();
        contS.main(args);

    }
}
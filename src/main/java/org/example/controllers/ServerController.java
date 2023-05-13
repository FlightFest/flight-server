package src.main.java.org.example.controllers;

import javax.bluetooth.*;
import javax.microedition.io.Connector;
import javax.microedition.io.StreamConnection;
import javax.microedition.io.StreamConnectionNotifier;
import java.io.IOException;
import java.util.ArrayList;

public class ServerController {

    private ArrayList<StreamConnection> connections = new ArrayList<StreamConnection>();
    private LocalDevice lDevice;
    private StreamConnectionNotifier notifier;
    private volatile boolean isRunning = true;

    public ServerController(){

    }

    public void start() throws IOException {
        lDevice = LocalDevice.getLocalDevice();
        lDevice.setDiscoverable(DiscoveryAgent.GIAC);

        UUID uuid = new UUID("0000110100001000800000805F9B34FB", false);
        String url = "btspp://localhost:" + uuid.toString() + ";name=Server";
        notifier = (StreamConnectionNotifier) Connector.open(url);

        System.out.println("Server started");
        
        while (isRunning) {
            StreamConnection connection = notifier.acceptAndOpen();
            connections.add(connection);
            System.out.println("Client connected: " + connection);
            Thread t = new Thread(new ClientHandler(connection));
            t.start();
        }
    }

    public void end() throws IOException {
        isRunning = false;
        for (StreamConnection connection : connections) {
            connection.close();
        }
        notifier.close();
    }

    private class ClientHandler implements Runnable {
        private StreamConnection connection;

        public ClientHandler(StreamConnection connection) {
            this.connection = connection;
        }

        @Override
        public void run() {
            try {
                while (isRunning) {
                    // handle client requests
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    connections.remove(connection);
                    connection.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

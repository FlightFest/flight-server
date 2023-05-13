package org.example.main;

import com.intel.bluetooth.rmi.Server;
import src.main.java.org.example.controllers.PlayerController;
import src.main.java.org.example.controllers.ServerController;
import src.main.java.org.example.entities.Player;

import javax.microedition.io.Connector;
import javax.microedition.io.StreamConnection;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Main {
    public static void main(String[] args) throws IOException {

        boolean ended = false;

        PlayerController contP = new PlayerController();

        //Start bluetooth connection
        StreamConnection streamConnection = getBluetoothConnection();

        // Obtener el objeto InputStream y OutputStream de la conexión
        InputStream inputStream = streamConnection.openInputStream();
        OutputStream outputStream = streamConnection.openOutputStream();

        while (!ended) {
            byte[] buffer = new byte[1024];
            int bytes = inputStream.read(buffer);
            String request = new String(buffer, 0, bytes);
            System.out.println("Recibido: " + request);

            // Procesar la solicitud aquí y enviar la respuesta al dispositivo remoto
            String response = "Respuesta a la solicitud: " + request;
            outputStream.write(response.getBytes());
        }

        //End bluetooth connection
        streamConnection.close();

    }

    private static StreamConnection getBluetoothConnection() throws IOException {
        String connectionString = "btspp://localhost:1";
        return (StreamConnection) Connector.open(connectionString);
    }
}
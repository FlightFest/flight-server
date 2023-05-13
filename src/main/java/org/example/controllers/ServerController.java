package src.main.java.org.example.controllers;

import javax.bluetooth.*;
import javax.microedition.io.Connector;
import javax.microedition.io.StreamConnection;
import javax.microedition.io.StreamConnectionNotifier;
import java.io.IOException;

public class ServerController {

    LocalDevice lDevice;
    StreamConnectionNotifier notifier;

    public ServerController(){

    }

    public void start() throws IOException {
        lDevice = LocalDevice.getLocalDevice();
        lDevice.setDiscoverable(DiscoveryAgent.GIAC);

        UUID uuid = new UUID("0000110100001000800000805F9B34FB", false);
        String url = "btspp://localhost:" + uuid.toString() + ";name=Server";
        notifier = (StreamConnectionNotifier) Connector.open(url);

        StreamConnection connection = notifier.acceptAndOpen();
    }

    public void end() throws IOException {
        notifier.close();
    }
}

import javafx.application.Platform;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ReaderThread extends Thread {
    private ObjectInputStream inputStream;
    private Client client;
    private Socket socket;
    private GUITest GUI;

    public ReaderThread(Socket socket, Client client, GUITest GUI) {
//        System.out.println("Creating Reader Thread");
        this.client = client;
        this.socket = socket;
        this.GUI = GUI;
    }

    public void run() {
//        System.out.println("Starting Reader Thread.");
        try {
            inputStream = new ObjectInputStream(socket.getInputStream());

            while (true) {
                Object payload = inputStream.readObject();
//                System.out.println(payload.toString());
                Platform.runLater(() -> GUI.toGUI(payload));
            }
        }
        catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error reading from server: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}

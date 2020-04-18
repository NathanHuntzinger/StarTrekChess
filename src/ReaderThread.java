import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ReaderThread extends Thread {
    private ObjectInputStream inputStream;
    private Client client;
    private Socket socket;

    public ReaderThread(Socket socket, Client client) {
        System.out.println("Creating Reader Thread");
        this.client = client;
        this.socket = socket;
    }

    public void run() {
        System.out.println("Starting Reader Thread.");
        while (true) {
            try {
                inputStream = new ObjectInputStream(socket.getInputStream());

                Object payload = inputStream.readObject();
                if (payload instanceof ChatObj) {
                    System.out.flush();
                    System.out.println(payload.toString());
                }
            }
            catch (IOException | ClassNotFoundException ex) {
                System.out.println("Error reading from server: " + ex.getMessage());
                ex.printStackTrace();
                break;
            }
        }
    }
}

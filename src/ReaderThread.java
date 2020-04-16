import java.io.*;
import java.net.Socket;

public class ReaderThread extends Thread {
    private ObjectInputStream inputStream;
    private Client client;

    public ReaderThread(Socket socket, Client client) {
        this.client = client;

        try {
            inputStream = new ObjectInputStream(socket.getInputStream());
//            inputStream = new BufferedReader(new InputStreamReader(input));
        } catch (IOException ex) {
            System.out.println("Error getting input stream: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void run() {
        while (true) {
            try {
                Object payload = inputStream.readObject();
                if (payload instanceof ChatObj) {
                    System.out.println(payload.toString());
                }

                // prints the username after displaying the server's message
                if (client.getPlayerName() != null) {
                    System.out.print("[" + client.getPlayerName() + "]: ");
                }
            } catch (IOException | ClassNotFoundException ex) {
                System.out.println("Error reading from server: " + ex.getMessage());
                ex.printStackTrace();
                break;
            }
        }
    }
}

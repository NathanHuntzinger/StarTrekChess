import java.io.IOException;
import java.net.Socket;

public class Client {
    private String hostname;
    private int port;
    private String playerName;

    public Client(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }

    public void start() {
        try {
            Socket socket = new Socket(hostname, port);

            System.out.println("Connected to the chat server");

            ReaderThread reader = new ReaderThread(socket, this);
            WriterThread writer = new WriterThread(socket, this);

            reader.start();
            writer.start();
        } catch (IOException ex) {
            System.out.println("I/O Error: " + ex.getMessage());
        }

    }

    void setPlayerName(String name) {
        this.playerName = name;
    }
    String getPlayerName() {
        return this.playerName;
    }


    public static void main(String[] args) {
        String hostname = "127.0.0.1";
        int port = 9001;

        Client client = new Client(hostname, port);
        client.start();
    }
}

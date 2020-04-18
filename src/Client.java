import java.io.IOException;
import java.net.Socket;

public class Client {
    private String hostname;
    private int port;
    private Socket socket;
    private String playerName = "Dummy Name";
    private WriterThread writerThread;
    private ReaderThread readerThread;

    public Client(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }

    public void start() {
        try {
            socket = new Socket(hostname, port);

            System.out.println("Connected to the chat server");

            writerThread = new WriterThread(socket, this);
            readerThread = new ReaderThread(socket, this);

            readerThread.start();
            writerThread.start();
        }
        catch (IOException ex) {
            System.out.println("I/O Error: " + ex.getMessage());
        }

    }

    public void setPlayerName(String name) {
        this.playerName = name;
        if (this.writerThread != null) {
            this.writerThread.userName = name;
        }
    }

    public String getPlayerName() {
        return this.playerName;
    }


    public static void main(String[] args) {
        String hostname = "127.0.0.1";
        int port = 9001;

        Client client = new Client(hostname, port);
        client.setPlayerName("Client");
        client.start();
    }
}

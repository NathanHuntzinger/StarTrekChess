import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

public class Client {
    private String hostname;
    private int port;
    private Socket socket;
    private String playerName = "Dummy Name";
//    private WriterThread writerThread;
    private ReaderThread readerThread;
    private ObjectOutputStream outputStream;
    private GUITest GUI;

    public Client(String hostname, int port, GUITest GUI) {
        this.hostname = hostname;
        this.port = port;
        this.GUI = GUI;
    }

    public void start() {
        try {
            socket = new Socket(hostname, port);

            System.out.println("Connected to the chat server");

//            writerThread = new WriterThread(socket, this, GUI);
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            readerThread = new ReaderThread(socket, this, GUI);

            readerThread.start();
//            writerThread.start();
        }
        catch (IOException ex) {
            System.out.println("I/O Error: " + ex.getMessage());
        }

    }

    public void setPlayerName(String name) {
        this.playerName = name;
//        if (this.writerThread != null) {
//            this.writerThread.userName = name;
//        }
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public void toServer(Serializable payload) {
        try {
            outputStream.writeObject(payload);
            outputStream.flush();
        } catch (IOException ex) {
            System.out.println("I/O Error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        String hostname = "127.0.0.1";
//        int port = 9001;
//
//        Client client = new Client(hostname, port);
//        client.setPlayerName("Client");
//        client.start();
//    }
}

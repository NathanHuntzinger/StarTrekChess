import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class WriterThread extends Thread {
    private ObjectOutputStream outputStream;
    private Client client;
    private Socket socket;
    protected String userName;

    public WriterThread(Socket socket, Client client) {
        this.client = client;
        this.socket = socket;
        this.userName = client.getPlayerName();
    }

    public void run() {
        System.out.println("Started the Writer Thread");

        try {
            outputStream = new ObjectOutputStream(socket.getOutputStream());

            ChatObj chat;
            Scanner scanner;

            while (true) {
                scanner = new Scanner(System.in);

                System.out.print("> "); // TODO: This will need to be taken out when we have a GUI
                chat = new ChatObj(userName, scanner.nextLine());

                outputStream.writeObject(chat);
                outputStream.flush();
            }
        } catch (IOException ex) {
            System.out.println("I/O Error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}

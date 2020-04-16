import java.io.*;
import java.net.Socket;

public class WriterThread extends Thread {
    private PrintWriter writer;
    private Client client;

    public WriterThread(Socket socket, Client client) {
        this.client = client;

        try {
            OutputStream output = new ObjectOutputStream(socket.getOutputStream());
            writer = new PrintWriter(output, true);
        } catch (IOException ex) {
            System.out.println("Error getting output stream: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void run() {

        Console console = System.console();

        String userName = console.readLine("\nEnter your name: ");
        client.setPlayerName(userName);
        writer.println(userName);

        ChatObj chatMessage;

        while (true) {
            chatMessage = new ChatObj(userName, console.readLine());
            writer.println(chatMessage);
        }
    }
}

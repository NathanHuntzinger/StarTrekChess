import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer {
    int port;
    ArrayList<serverThread> playerThreads;

    ChatServer(int port) {
        this.port = port;
        playerThreads = new ArrayList<serverThread>();
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(this.port)) {
            System.out.println("Server started on port " + this.port);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New Connection: " + clientSocket);

                serverThread newPlayer = new serverThread(clientSocket, this);
                playerThreads.add(newPlayer);
                newPlayer.start();
            }
        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    protected void broadcast(Object payload, serverThread sender) {
        for (serverThread player : playerThreads) {
            if (player != sender) {
                System.out.println(payload.toString());

                player.toClient(payload);
            }
        }
    }

    public static void main(String[] args) {
        ChatServer server = new ChatServer(9001);
        server.start();
    }
}

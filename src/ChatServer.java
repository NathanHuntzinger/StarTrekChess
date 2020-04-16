import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer {
    int port;
    ArrayList<PlayerThread> playerThreads;

    ChatServer(int port) {
        this.port = port;
        playerThreads = new ArrayList<PlayerThread>();
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(this.port)) {
            System.out.println("Server started on port " + this.port);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New Connection: " + clientSocket);

                PlayerThread newPlayer = new PlayerThread(clientSocket, this);
                playerThreads.add(newPlayer);
                newPlayer.start();
            }
        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    protected void broadcast(Object payload, PlayerThread sender) {
        for (PlayerThread player : playerThreads) {
            if (player == sender) { continue; }

            player.send(payload);
        }
    }

    public static void main(String[] args) {
        ChatServer server = new ChatServer(9001);
        server.start();
    }
}

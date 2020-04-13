import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer {
    ServerSocket serverSocket;
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

    protected void broadcast(String msg) {
        for (PlayerThread player : playerThreads) {
            player.sendChat(msg);
        }
    }

    public static void main(String[] args) {
        ChatServer server = new ChatServer(9001);
        server.start();
    }
}

class PlayerThread {
    Socket socket;
    ChatServer server;
    BufferedWriter writer;
    BufferedReader reader;
    String name;

    PlayerThread(Socket socket, ChatServer server) {
        this.socket = socket;
        this.server = server;

        this.start();
    }

    public void start() {
        try {
            this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            System.out.println("What is your name?  ");
            this.name = reader.readLine();

            String msg = "I AM BORN!!!!";
            while (true) {
                if (!msg.startsWith("/")) {
                    msg = reader.readLine();
                    server.broadcast("[" + name + "]: " + msg);
                }
            }
        }
        catch (IOException e) {
            System.out.println("Player connection error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    protected void sendChat(String msg) {
        System.out.println(msg);
    }
}
import java.io.*;
import java.net.Socket;

class PlayerThread extends Thread {
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
            InputStream in = new ObjectInputStream(socket.getInputStream());
            OutputStream out = new ObjectOutputStream(socket.getOutputStream());
            this.reader = new BufferedReader(new InputStreamReader(in));
            this.writer = new BufferedWriter(new OutputStreamWriter(out));

            System.out.println("What is your name?  ");
            this.name = reader.readLine();

            while (true) {
                server.broadcast(reader.readLine(), this);
            }
        }
        catch (IOException e) {
            System.out.println("Player connection error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    protected void send(Object msg) {
        System.out.println(msg);
    }
}

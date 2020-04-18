import java.io.*;
import java.net.Socket;

class serverThread extends Thread {
    Socket client;
    ChatServer server;
    ObjectInputStream inputStream;
    ObjectOutputStream outputStream;

    serverThread(Socket client, ChatServer server) {
        this.client = client;
        this.server = server;
    }

    public void run() {
        try {
            InputStream in = client.getInputStream();
            inputStream = new ObjectInputStream(in);

            OutputStream out = client.getOutputStream();
            outputStream = new ObjectOutputStream(out);

            Object message;
            while (true) {
                message = inputStream.readObject();
                if (message instanceof ChatObj) {
                    System.out.println(message.toString());
//                    outputStream.writeObject(new ChatObj("System", "Response..."));
                    server.broadcast(message, this);
                    outputStream.flush();
                }
                // TODO: Add conditions for other objects

            }
        }
        catch (IOException | ClassNotFoundException e) {
            System.out.println("Player connection error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    protected void toClient(Object payload) {
        try {
            outputStream.writeObject(payload);
            outputStream.flush();
        } catch (IOException e) {
            System.out.println("Error writing object to Client: " + this.client);
            e.printStackTrace();
        }
    }
}

//import java.io.IOException;
//import java.io.ObjectOutputStream;
//import java.net.Socket;
//import java.util.Scanner;
//
//public class WriterThread extends Thread {
//    private ObjectOutputStream outputStream;
//    private Client client;
//    private Socket socket;
//    private ChatGUI GUI;
//    protected String userName;
//
//
//    public WriterThread(Socket socket, Client client, ChatGUI GUI) {
//        this.client = client;
//        this.socket = socket;
//        this.userName = client.getPlayerName();
//        this.GUI = GUI;
//    }
//
//    public void run() {
//        System.out.println("Started the Writer Thread");
//
//        try {
//            outputStream = new ObjectOutputStream(socket.getOutputStream());
//
//            ChatObj chat;
//            Scanner scanner;
//
//            while (true) {
//                scanner = new Scanner(System.in);
//
//                System.out.print("> ");
//                chat = new ChatObj(userName, scanner.nextLine());
//
//                outputStream.writeObject(chat);
//                outputStream.flush();
//            }
//        } catch (IOException ex) {
//            System.out.println("I/O Error: " + ex.getMessage());
//            ex.printStackTrace();
//        }
//    }
//}

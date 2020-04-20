//import javafx.application.Application;
//import javafx.geometry.Pos;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.*;
//import javafx.scene.text.Font;
//import javafx.scene.text.Text;
//import javafx.stage.Stage;
//
//
//public class ChatGUI extends Application {
//    Client client;
//    VBox pane;
//    VBox chat;
//    HBox input;
//    Text name;
//
//    private String hostname;
//    private int port;
//
//    @Override
//    public void start(Stage primaryStage) {
//        setUpBoard();
//
////        name.labelForProperty()
//        primaryStage.setTitle("Chat");
//        primaryStage.setScene(new Scene(pane, 400, 600));
//        primaryStage.show();
//    }
//
//    private void setUpBoard() {
//        this.pane = new VBox();
//        this.chat = new VBox();
//        createChatInputPane();
//
//        pane.setSpacing(10);
//
//        pane.getChildren().add(chat);
//        pane.getChildren().add(input);
//        pane.setAlignment(Pos.BOTTOM_CENTER);
//    }
//
//    private void createChatInputPane() {
//        this.input = new HBox();
//        this.input.setSpacing(10);
//
//        name = new Text("...");
//        name.setFont(new Font("Ubuntu", 20));
//        TextField chatInput = new TextField();
//        Button sendButton = new Button("Send");
//
//        this.input.getChildren().add(name);
//        this.input.getChildren().add(chatInput);
//        this.input.getChildren().add(sendButton);
//
//        this.toGUI(new ChatObj("System", "What is your name?"));
//
//        sendButton.setOnMouseClicked(event -> {
//            ChatObj newChat;
//            if (this.client== null) {
//                if (this.name.getText().equals("...")) {
//                    this.name.setText(chatInput.getText());
//                    chatInput.setText("");
//                    this.toGUI(new ChatObj("System", "Setting your name to '" + name.getText() + "'"));
//                    this.toGUI(new ChatObj("System", "What is the host IP adress?"));
//                }
//                else if (this.hostname == null) {
//                    this.hostname = chatInput.getText();
//                    chatInput.setText("");
//                    this.toGUI(new ChatObj("System", "What is the host port?"));
//                }
//                else {
//                    try {
//                        this.port = Integer.parseInt(chatInput.getText().trim());
//                        this.toGUI(new ChatObj("System", "Connecting to " + this.hostname + ":" + this.port));
//                        this.client = new Client(this.hostname, this.port, this);
//                        this.client.start();
//                    }
//                    catch (NumberFormatException ex) {
//                        this.toGUI(new ChatObj("ERROR", "Invalid port number"));
//                    }
//                }
//            }
//            else {
//                newChat = new ChatObj(name.getText(), chatInput.getText());
//                this.toGUI(newChat);
//                this.client.toServer(newChat);
//            }
//        });
//    }
//
//    public void toGUI(ChatObj msg) {
//        Text text = new Text(msg.toString());
//        text.setFont(new Font("Ubuntu", 16));
//        this.chat.getChildren().add(text);
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}
//
//

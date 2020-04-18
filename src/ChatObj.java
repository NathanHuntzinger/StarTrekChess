import java.io.Serializable;

public class ChatObj implements Serializable {
    private String playerName;
    private String msg;

    ChatObj(String playerName, String msg){
        this.playerName = playerName;
        this.msg = msg;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "[" + playerName + "]: " + msg;
    }
}

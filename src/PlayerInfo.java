import java.io.Serializable;

public class PlayerInfo implements Serializable {
    int playerNumber;

    PlayerInfo(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }
}

import java.util.ArrayList;

public class Player {
    private int playerNumber;
    private ArrayList<Piece> pieces;

    Player(int playerNumber){
        this.playerNumber = playerNumber;
        for(int i = 0; i < 8; i ++){
            pieces.add(new Pawn());
        }
        pieces.add(new Rook());
        pieces.add(new Knight());
        pieces.add(new Bishop());
        if(this.playerNumber == 1){
            pieces.add(new Queen());
            pieces.add(new King());
        }
        else{
            pieces.add(new King());
            pieces.add(new Queen());
        }
        pieces.add(new Bishop());
        pieces.add(new Knight());
        pieces.add(new Rook());
    }

    boolean checkForCheck(){
        return false; //change this
    }

    boolean checkForCheckmate(){
        return false; //change this
    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }
}

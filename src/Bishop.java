import java.util.ArrayList;

public class Bishop extends Piece{
    Bishop(BoardPosition position, Player player, GameBoard gameBoard){
        this.gameBoard = gameBoard;
        this.position = position;
        this.player = player;
    }

    @Override
    public void print() {
        if(player.getPlayerNumber() == 1) {
            System.out.print("B");
        }
        else{
            System.out.print("b");
        }
    }

    ArrayList<BoardPosition> getMoves() {
        ArrayList<BoardPosition> moves = new ArrayList<>();

        return moves;
    }
}

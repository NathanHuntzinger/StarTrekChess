import java.util.ArrayList;

public class Pawn extends Piece{
    private boolean hasMoved;

    Pawn(){
        hasMoved = false;
    }

    @Override
    ArrayList<BoardPosition> getMoves() {
        ArrayList<BoardPosition> moves = new ArrayList<>();
        if(getPlayer().getPlayerNumber() == 1) {
            if (getGameBoard().getPosition(this.getRow() + 1, this.getCol(), this.getLevel()).getPiece() == null
                || getGameBoard().getPosition(this.getRow() + 1, this.getCol(), this.getLevel()).getPiece().getPlayer().getPlayerNumber() == 2) {
                moves.add(getGameBoard().getPosition(this.getRow() + 1, this.getCol(), this.getLevel()));
            }
            if (getGameBoard().getPosition(this.getRow() + 1, this.getCol(), this.getLevel() + 1).getPiece() == null
                    || getGameBoard().getPosition(this.getRow() + 1, this.getCol(), this.getLevel() + 1).getPiece().getPlayer().getPlayerNumber() == 2) {
                moves.add(getGameBoard().getPosition(this.getRow() + 1, this.getCol(), this.getLevel() + 1));
            }
            if (getGameBoard().getPosition(this.getRow() + 1, this.getCol(), this.getLevel() - 1).getPiece() == null
                    || getGameBoard().getPosition(this.getRow() + 1, this.getCol(), this.getLevel() - 1).getPiece().getPlayer().getPlayerNumber() == 2) {
                moves.add(getGameBoard().getPosition(this.getRow() + 1, this.getCol(), this.getLevel() - 1));
            }
        }
        else{

        }

        return moves;
    }
}

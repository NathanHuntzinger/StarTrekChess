import java.util.ArrayList;

public class King extends Piece{
    King(BoardPosition position, Player player, GameBoard gameBoard){
        this.position = position;
        this.player = player;
        this.gameBoard = gameBoard;
    }

    @Override
    public void print() {
        if(player.getPlayerNumber() == 1) {
            System.out.print("K");
        }
        else{
            System.out.print("k");
        }
    }
    ArrayList<BoardPosition> getMoves() {
        ArrayList<BoardPosition> opponentMoves = this.player.getOpponentMoves();
        ArrayList<BoardPosition> moves = new ArrayList<>();
        for(int r = -1; r <= 1; r++){
            for(int c = -1; c <= 1; c++){
                for(int l = -1; l <= 1; l++) {
                    if(getGameBoard().isValidPosition(this.getRow() + r, this.getCol() + c, this.getLevel() + l)
                            && !(opponentMoves.contains(getGameBoard().getPosition(this.getRow() + r, this.getCol() + c, this.getLevel() + l)))
                            && (getGameBoard().getPosition(this.getRow() + r, this.getCol() + c, this.getLevel() + l).getPiece() == null
                            || getGameBoard().getPosition(this.getRow() + r, this.getCol() + c, this.getLevel() + l).getPiece().getPlayer() != this.getPlayer())){
                        moves.add(getGameBoard().getPosition(this.getRow() + r, this.getCol() + c, this.getLevel() + l));

                    }
                }
            }
        }
        return moves;
    }

    ArrayList<BoardPosition> getMovesFull() {
        ArrayList<BoardPosition> moves = new ArrayList<>();
        for(int r = -1; r <= 1; r++){
            for(int c = -1; c <= 1; c++){
                for(int l = -1; l <= 1; l++) {
                    if(getGameBoard().isValidPosition(this.getRow() + r, this.getCol() + c, this.getLevel() + l)
                            && (getGameBoard().getPosition(this.getRow() + r, this.getCol() + c, this.getLevel() + l).getPiece() == null
                            || getGameBoard().getPosition(this.getRow() + r, this.getCol() + c, this.getLevel() + l).getPiece().getPlayer() != this.getPlayer())){
                        moves.add(getGameBoard().getPosition(this.getRow() + r, this.getCol() + c, this.getLevel() + l));

                    }
                }
            }
        }
        return moves;
    }
}

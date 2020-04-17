import java.util.ArrayList;

public class Pawn extends Piece{
    private boolean hasMoved;

    Pawn(BoardPosition position, Player player, GameBoard gameBoard){
        this.gameBoard = gameBoard;
        hasMoved = false;
        this.position = position;
        this.player = player;
    }

    @Override
    ArrayList<BoardPosition> getMoves() {
        ArrayList<BoardPosition> moves = new ArrayList<>();
        if(getPlayer().getPlayerNumber() == 1) {
            if(hasMoved == false){
                if(getGameBoard().isValidPosition(this.getRow() - 2, this.getCol(), this.getLevel()) && getGameBoard().getPosition(this.getRow() - 2, this.getCol(), this.getLevel()).getPiece() == null){
                    moves.add(getGameBoard().getPosition(this.getRow() - 2, this.getCol(), this.getLevel()));
                }
                if(getGameBoard().isValidPosition(this.getRow() - 2, this.getCol(), this.getLevel() + 1) && getGameBoard().getPosition(this.getRow() -2, this.getCol(), this.getLevel() + 1).getPiece() == null){
                    moves.add(getGameBoard().getPosition(this.getRow() - 2, this.getCol(), this.getLevel() + 1));
                }
                if(getGameBoard().isValidPosition(this.getRow() - 2, this.getCol(), this.getLevel()-1) && getGameBoard().getPosition(this.getRow() - 2, this.getCol(), this.getLevel() - 1).getPiece() == null){
                    moves.add(getGameBoard().getPosition(this.getRow() - 2, this.getCol(), this.getLevel() - 1));
                }
            }
            if(getGameBoard().isValidPosition(this.getRow() - 1, this.getCol(), this.getLevel()) && getGameBoard().getPosition(this.getRow() - 1, this.getCol(), this.getLevel()).getPiece() == null){
                moves.add(getGameBoard().getPosition(this.getRow() - 1, this.getCol(), this.getLevel()));
            }
            if(getGameBoard().isValidPosition(this.getRow() - 1, this.getCol(), this.getLevel() + 1) && getGameBoard().getPosition(this.getRow() - 1, this.getCol(), this.getLevel() + 1).getPiece() == null){
                moves.add(getGameBoard().getPosition(this.getRow() - 1, this.getCol(), this.getLevel() + 1));
            }
            if(getGameBoard().isValidPosition(this.getRow() - 1, this.getCol(), this.getLevel()-1) && getGameBoard().getPosition(this.getRow() - 1, this.getCol(), this.getLevel() - 1).getPiece() == null){
                moves.add(getGameBoard().getPosition(this.getRow() - 1, this.getCol(), this.getLevel() - 1));
            }
        }
        else{
            if(hasMoved == false){
                if(getGameBoard().isValidPosition(this.getRow() + 2, this.getCol(), this.getLevel()) && getGameBoard().getPosition(this.getRow() + 2, this.getCol(), this.getLevel()).getPiece() == null){
                    moves.add(getGameBoard().getPosition(this.getRow() + 2, this.getCol(), this.getLevel()));
                }
                if(getGameBoard().isValidPosition(this.getRow() + 2, this.getCol(), this.getLevel() + 1) && getGameBoard().getPosition(this.getRow() + 2, this.getCol(), this.getLevel() + 1).getPiece() == null){
                    moves.add(getGameBoard().getPosition(this.getRow() + 2, this.getCol(), this.getLevel() + 1));
                }
                if(getGameBoard().isValidPosition(this.getRow() + 2, this.getCol(), this.getLevel()-1) && getGameBoard().getPosition(this.getRow() + 2, this.getCol(), this.getLevel() - 1).getPiece() == null){
                    moves.add(getGameBoard().getPosition(this.getRow() + 2, this.getCol(), this.getLevel() - 1));
                }
                if(getGameBoard().isValidPosition(this.getRow() + 2, this.getCol(), this.getLevel() + 2) && getGameBoard().getPosition(this.getRow() + 2, this.getCol(), this.getLevel() + 2).getPiece() == null){
                    moves.add(getGameBoard().getPosition(this.getRow() + 2, this.getCol(), this.getLevel() + 2));
                }
                if(getGameBoard().isValidPosition(this.getRow() + 2, this.getCol(), this.getLevel()-2) && getGameBoard().getPosition(this.getRow() + 2, this.getCol(), this.getLevel() - 2).getPiece() == null){
                    moves.add(getGameBoard().getPosition(this.getRow() + 2, this.getCol(), this.getLevel() - 2));
                }
            }
            if(getGameBoard().isValidPosition(this.getRow() + 1, this.getCol(), this.getLevel()) && getGameBoard().getPosition(this.getRow() + 1, this.getCol(), this.getLevel()).getPiece() == null){
                moves.add(getGameBoard().getPosition(this.getRow() + 1, this.getCol(), this.getLevel()));
            }
            if(getGameBoard().isValidPosition(this.getRow() + 1, this.getCol(), this.getLevel() + 1) && getGameBoard().getPosition(this.getRow() + 1, this.getCol(), this.getLevel() + 1).getPiece() == null){
                moves.add(getGameBoard().getPosition(this.getRow() + 1, this.getCol(), this.getLevel() + 1));
            }
            if(getGameBoard().isValidPosition(this.getRow() + 1, this.getCol(), this.getLevel()) && getGameBoard().getPosition(this.getRow() + 1, this.getCol(), this.getLevel() - 1).getPiece() == null){
                moves.add(getGameBoard().getPosition(this.getRow() + 1, this.getCol(), this.getLevel() - 1));
            }
        }
        return moves;
    }

    @Override
    public void print() {
        if(player.getPlayerNumber() == 1) {
            System.out.print("P");
        }
        else{
            System.out.print("p");
        }
    }
}

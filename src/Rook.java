import java.util.ArrayList;

public class Rook extends Piece{
    ArrayList<BoardPosition> moves;

    Rook(BoardPosition position, Player player, GameBoard gameBoard){
        this.gameBoard = gameBoard;
        this.position = position;
        this.player = player;
        this.moves = new ArrayList<>();
        this.dead = false;
    }

    @Override
    public void print() {
        if(player.getPlayerNumber() == 1) {
            System.out.print("R");
        }
        else{
            System.out.print("r");
        }
    }

    ArrayList<BoardPosition> getMoves() {
        if(this.dead){
            return new ArrayList<>();
        }
        this.moves = new ArrayList<>();
        for(int iterator1 = -1; iterator1 <= 1; iterator1 += 2){
            for(int l = -1; l <= 1; l++) {
                    if(getGameBoard().isValidPosition(this.getRow() + iterator1, this.getCol(), this.getLevel() + l)
                            && (getGameBoard().getPosition(this.getRow() + iterator1, this.getCol(), this.getLevel() + l).getPiece() == null
                            || getGameBoard().getPosition(this.getRow() + iterator1, this.getCol(), this.getLevel() + l).getPiece().getPlayer() != this.getPlayer())){

                        getMovesRecursive(this.getRow() + iterator1 ,this.getCol(),this.getLevel() + l, iterator1, 0);
                    }
                if(getGameBoard().isValidPosition(this.getRow(), this.getCol() + iterator1, this.getLevel() + l)
                        && (getGameBoard().getPosition(this.getRow(), this.getCol() + iterator1, this.getLevel() + l).getPiece() == null
                        || getGameBoard().getPosition(this.getRow(), this.getCol() + iterator1, this.getLevel() + l).getPiece().getPlayer() != this.getPlayer())){

                    getMovesRecursive(this.getRow() ,this.getCol() + iterator1,this.getLevel() + l, 0, iterator1);
                }
            }
        }

        return this.moves;
    }

    void getMovesRecursive(int row, int col, int level, int rowDirection, int colDirection){
        for(int l = -1; l <= 1; l++) {
            if(getGameBoard().isValidPosition(row, col, level + l)
                    && (getGameBoard().getPosition(row, col, level + l).getPiece() == null
                    || getGameBoard().getPosition(row, col, level + l).getPiece().getPlayer() != this.getPlayer())){

                moves.add(getGameBoard().getPosition(row, col, level + l));
                if(getGameBoard().getPosition(row, col, level + l).getPiece() == null || (!getGameBoard().getPosition(row, col, level + l).getPiece().isDead() && getGameBoard().getPosition(row, col, level + l).getPiece() instanceof King)) {
                    getMovesRecursive(row + rowDirection, col + colDirection, level + l, rowDirection, colDirection);
                }
            }
        }

    }
}

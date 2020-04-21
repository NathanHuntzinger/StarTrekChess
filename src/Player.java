import java.io.Serializable;
import java.util.ArrayList;

public class Player implements Serializable {
    private int playerNumber;
    private ArrayList<Piece> pieces;
    private GameBoard gameBoard;
    private Player opponent;

    Player(GameBoard gameBoard, int playerNumber){
        this.playerNumber = playerNumber;
        this.gameBoard = gameBoard;
        this.pieces = new ArrayList<>();
        //set up player 1's pieces
        if(this.playerNumber == 1) {
            //setup pawns
            this.pieces.add(new Pawn(gameBoard.getPosition(8,0,6), this, this.gameBoard));
            gameBoard.getPosition(8,0,6).setPiece(this.pieces.get(0));

            this.pieces.add(new Pawn(gameBoard.getPosition(8,1,6), this, this.gameBoard));
            gameBoard.getPosition(8,1,6).setPiece(this.pieces.get(1));

            this.pieces.add(new Pawn(gameBoard.getPosition(7,1,5), this, this.gameBoard));
            gameBoard.getPosition(7,1,5).setPiece(this.pieces.get(2));

            this.pieces.add(new Pawn(gameBoard.getPosition(7,2,5), this, this.gameBoard));
            gameBoard.getPosition(7,2,5).setPiece(this.pieces.get(3));

            this.pieces.add(new Pawn(gameBoard.getPosition(7,3,5), this, this.gameBoard));
            gameBoard.getPosition(7,3,5).setPiece(this.pieces.get(4));

            this.pieces.add(new Pawn(gameBoard.getPosition(7,4,5), this, this.gameBoard));
            gameBoard.getPosition(7,4,5).setPiece(this.pieces.get(5));

            this.pieces.add(new Pawn(gameBoard.getPosition(8,4,6), this, this.gameBoard));
            gameBoard.getPosition(8,4,6).setPiece(this.pieces.get(6));

            this.pieces.add(new Pawn(gameBoard.getPosition(8,5,6), this, this.gameBoard));
            gameBoard.getPosition(8,5,6).setPiece(this.pieces.get(7));

            //setup back row
            this.pieces.add(new Rook(gameBoard.getPosition(9,0,6), this, this.gameBoard));
            gameBoard.getPosition(9,0,6).setPiece(this.pieces.get(8));

            this.pieces.add(new Knight(gameBoard.getPosition(9,1,6), this, this.gameBoard));
            gameBoard.getPosition(9,1,6).setPiece(this.pieces.get(9));

            this.pieces.add(new Bishop(gameBoard.getPosition(8,1,5), this, this.gameBoard));
            gameBoard.getPosition(8,1,5).setPiece(this.pieces.get(10));

            this.pieces.add(new Queen(gameBoard.getPosition(8,2,5), this, this.gameBoard));
            gameBoard.getPosition(8,2,5).setPiece(this.pieces.get(11));

            this.pieces.add(new King(gameBoard.getPosition(8,3,5),this, this.gameBoard));
            gameBoard.getPosition(8,3,5).setPiece(this.pieces.get(12));

            this.pieces.add(new Bishop(gameBoard.getPosition(8,4,5),this, this.gameBoard));
            gameBoard.getPosition(8,4,5).setPiece(this.pieces.get(13));

            this.pieces.add(new Knight(gameBoard.getPosition(9,4,6),this, this.gameBoard));
            gameBoard.getPosition(9,4,6).setPiece(this.pieces.get(14));

            this.pieces.add(new Rook(gameBoard.getPosition(9,5,6),this, this.gameBoard));
            gameBoard.getPosition(9,5,6).setPiece(this.pieces.get(15));
        }
        else{
            //setup pawns
            this.pieces.add(new Pawn(this.gameBoard.getPosition(1,0,2), this, this.gameBoard));
            this.gameBoard.getPosition(1,0,2).setPiece(this.pieces.get(0));

            this.pieces.add(new Pawn(this.gameBoard.getPosition(1,1,2), this, this.gameBoard));
            this.gameBoard.getPosition(1,1,2).setPiece(this.pieces.get(1));

            this.pieces.add(new Pawn(this.gameBoard.getPosition(2,1,1), this, this.gameBoard));
            this.gameBoard.getPosition(2,1,1).setPiece(this.pieces.get(2));

            this.pieces.add(new Pawn(this.gameBoard.getPosition(2,2,1), this, this.gameBoard));
            this.gameBoard.getPosition(2,2,1).setPiece(this.pieces.get(3));

            this.pieces.add(new Pawn(this.gameBoard.getPosition(2,3,1), this, this.gameBoard));
            this.gameBoard.getPosition(2,3,1).setPiece(this.pieces.get(4));

            this.pieces.add(new Pawn(this.gameBoard.getPosition(2,4,1), this, this.gameBoard));
            this.gameBoard.getPosition(2,4,1).setPiece(this.pieces.get(5));

            this.pieces.add(new Pawn(this.gameBoard.getPosition(1,4,2), this, this.gameBoard));
            this.gameBoard.getPosition(1,4,2).setPiece(this.pieces.get(6));

            this.pieces.add(new Pawn(this.gameBoard.getPosition(1,5,2), this, this.gameBoard));
            this.gameBoard.getPosition(1,5,2).setPiece(this.pieces.get(7));

            //setup back row
            this.pieces.add(new Rook(this.gameBoard.getPosition(0,0,2), this, this.gameBoard));
            this.gameBoard.getPosition(0,0,2).setPiece(this.pieces.get(8));

            this.pieces.add(new Knight(this.gameBoard.getPosition(0,1,2), this, this.gameBoard));
            this.gameBoard.getPosition(0,1,2).setPiece(this.pieces.get(9));

            this.pieces.add(new Bishop(this.gameBoard.getPosition(1,1,1), this, this.gameBoard));
            this.gameBoard.getPosition(1,1,1).setPiece(this.pieces.get(10));

            this.pieces.add(new Queen(this.gameBoard.getPosition(1,2,1), this, this.gameBoard));
            this.gameBoard.getPosition(1,2,1).setPiece(this.pieces.get(11));

            this.pieces.add(new King(this.gameBoard.getPosition(1,3,1),this, this.gameBoard));
            this.gameBoard.getPosition(1,3,1).setPiece(this.pieces.get(12));

            this.pieces.add(new Bishop(this.gameBoard.getPosition(1,4,1),this, this.gameBoard));
            this.gameBoard.getPosition(1,4,1).setPiece(this.pieces.get(13));

            this.pieces.add(new Knight(this.gameBoard.getPosition(0,4,2),this, this.gameBoard));
            this.gameBoard.getPosition(0,4,2).setPiece(this.pieces.get(14));

            this.pieces.add(new Rook(this.gameBoard.getPosition(0,5,2),this, this.gameBoard));
            this.gameBoard.getPosition(0,5,2).setPiece(this.pieces.get(15));
        }
    }

    public void setOpponent(Player opponent) {
        this.opponent = opponent;
    }

    public boolean checkForCheck(){
        if(this.getOpponentMoves().contains(this.getKing().getPosition())){
            return true;
        }
        return false;
    }

    public boolean checkForCheckmate(){
        if(this.checkForCheck() && this.getKing().getMoves().size() == 0){
            return true;
        }

        return false; //change this
    }

    public King getKing(){
        return (King) this.pieces.get(12);
    }

    public ArrayList<BoardPosition> getAllMoves(){
        ArrayList<BoardPosition> moves = new ArrayList<>();
        for (Piece piece : pieces){
            if(piece instanceof King){
                moves.addAll(((King) piece).getMovesFull());
            }
            else{
                moves.addAll(piece.getMoves());
            }
        }
        return moves;
    }

    public ArrayList<BoardPosition> getOpponentMoves(){
        return this.opponent.getAllMoves();
    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void print(){
        System.out.println("Player: " + playerNumber);
        for(int i = 0; i < pieces.size(); i++){
            pieces.get(i).print();
            System.out.println(pieces.get(i).getPosition().toString());
        }
        System.out.println();
    }
}

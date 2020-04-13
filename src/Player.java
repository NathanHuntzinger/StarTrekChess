import java.util.ArrayList;

public class Player {
    private int playerNumber;
    private ArrayList<Piece> pieces;
    private GameBoard gameBoard;

    Player(GameBoard gameBoard, int playerNumber){
        this.playerNumber = playerNumber;
        this.gameBoard = gameBoard;
        this.pieces = new ArrayList<>();
        //set up player 1's peices
        if(this.playerNumber == 1) {
            //setup pawns
            this.pieces.add(new Pawn(gameBoard.getPosition(9,1,7), this));
            gameBoard.getPosition(9,1,7).setPiece(this.pieces.get(0));

            this.pieces.add(new Pawn(gameBoard.getPosition(9,2,7), this));
            gameBoard.getPosition(9,2,7).setPiece(this.pieces.get(1));

            this.pieces.add(new Pawn(gameBoard.getPosition(8,2,6), this));
            gameBoard.getPosition(8,2,6).setPiece(this.pieces.get(2));

            this.pieces.add(new Pawn(gameBoard.getPosition(8,3,6), this));
            gameBoard.getPosition(8,3,6).setPiece(this.pieces.get(3));

            this.pieces.add(new Pawn(gameBoard.getPosition(8,4,6), this));
            gameBoard.getPosition(8,4,6).setPiece(this.pieces.get(4));

            this.pieces.add(new Pawn(gameBoard.getPosition(8,5,6), this));
            gameBoard.getPosition(8,5,6).setPiece(this.pieces.get(5));

            this.pieces.add(new Pawn(gameBoard.getPosition(9,5,7), this));
            gameBoard.getPosition(9,5,7).setPiece(this.pieces.get(6));

            this.pieces.add(new Pawn(gameBoard.getPosition(9,6,7), this));
            gameBoard.getPosition(9,6,7).setPiece(this.pieces.get(7));

            //setup back row
            this.pieces.add(new Rook(gameBoard.getPosition(10,1,7), this));
            gameBoard.getPosition(9,1,7).setPiece(this.pieces.get(8));

            this.pieces.add(new Knight(gameBoard.getPosition(10,2,7), this));
            gameBoard.getPosition(9,2,7).setPiece(this.pieces.get(9));

            this.pieces.add(new Bishop(gameBoard.getPosition(9,2,6), this));
            gameBoard.getPosition(8,2,6).setPiece(this.pieces.get(10));

            this.pieces.add(new Queen(gameBoard.getPosition(9,3,6), this));
            gameBoard.getPosition(8,3,6).setPiece(this.pieces.get(11));

            this.pieces.add(new King(gameBoard.getPosition(9,4,6),this));
            gameBoard.getPosition(8,4,6).setPiece(this.pieces.get(12));

            this.pieces.add(new Bishop(gameBoard.getPosition(9,5,6),this));
            gameBoard.getPosition(8,5,6).setPiece(this.pieces.get(13));

            this.pieces.add(new Knight(gameBoard.getPosition(10,5,7),this));
            gameBoard.getPosition(9,5,7).setPiece(this.pieces.get(14));

            this.pieces.add(new Rook(gameBoard.getPosition(10,6,7),this));
            gameBoard.getPosition(9,6,7).setPiece(this.pieces.get(15));
        }
        else{
            //setup pawns
            this.pieces.add(new Pawn(this.gameBoard.getPosition(2,1,3), this));
            this.gameBoard.getPosition(2,1,3).setPiece(this.pieces.get(0));

            this.pieces.add(new Pawn(this.gameBoard.getPosition(2,2,3), this));
            this.gameBoard.getPosition(2,2,3).setPiece(this.pieces.get(1));

            this.pieces.add(new Pawn(this.gameBoard.getPosition(3,2,2), this));
            this.gameBoard.getPosition(3,2,2).setPiece(this.pieces.get(2));

            this.pieces.add(new Pawn(this.gameBoard.getPosition(3,3,2), this));
            this.gameBoard.getPosition(3,3,2).setPiece(this.pieces.get(3));

            this.pieces.add(new Pawn(this.gameBoard.getPosition(3,4,2), this));
            this.gameBoard.getPosition(3,4,2).setPiece(this.pieces.get(4));

            this.pieces.add(new Pawn(this.gameBoard.getPosition(3,5,2), this));
            this.gameBoard.getPosition(3,5,2).setPiece(this.pieces.get(5));

            this.pieces.add(new Pawn(this.gameBoard.getPosition(2,5,3), this));
            this.gameBoard.getPosition(2,5,3).setPiece(this.pieces.get(6));

            this.pieces.add(new Pawn(this.gameBoard.getPosition(2,6,3), this));
            this.gameBoard.getPosition(2,6,3).setPiece(this.pieces.get(7));

            //setup back row
            this.pieces.add(new Rook(this.gameBoard.getPosition(1,1,3), this));
            this.gameBoard.getPosition(2,1,3).setPiece(this.pieces.get(8));

            this.pieces.add(new Knight(this.gameBoard.getPosition(1,2,3), this));
            this.gameBoard.getPosition(2,2,3).setPiece(this.pieces.get(9));

            this.pieces.add(new Bishop(this.gameBoard.getPosition(2,2,2), this));
            this.gameBoard.getPosition(3,2,2).setPiece(this.pieces.get(10));

            this.pieces.add(new Queen(this.gameBoard.getPosition(2,3,2), this));
            this.gameBoard.getPosition(3,3,2).setPiece(this.pieces.get(11));

            this.pieces.add(new King(this.gameBoard.getPosition(2,4,2),this));
            this.gameBoard.getPosition(3,4,2).setPiece(this.pieces.get(12));

            this.pieces.add(new Bishop(this.gameBoard.getPosition(2,5,2),this));
            this.gameBoard.getPosition(3,5,2).setPiece(this.pieces.get(13));

            this.pieces.add(new Knight(this.gameBoard.getPosition(1,5,3),this));
            this.gameBoard.getPosition(2,5,3).setPiece(this.pieces.get(14));

            this.pieces.add(new Rook(this.gameBoard.getPosition(1,6,3),this));
            this.gameBoard.getPosition(2,6,3).setPiece(this.pieces.get(15));
        }
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

import java.io.Serializable;
import java.util.ArrayList;

public class MovableBoard implements Serializable {
    private ArrayList<ArrayList<BoardPosition>> board;
    private int level;
    private MovableBoardPosition position;
    private GameBoard gameBoard;

    MovableBoard( int level, MovableBoardPosition movableBoardPosition, GameBoard gameBoard){
        this.board = movableBoardPosition.getBoardSection();
        this.gameBoard = gameBoard;
        for (int i = 0; i < this.board.size(); i++){
            for (int j = 0; j < this.board.get(i).size(); j++){
                this.board.get(i).get(j).setValidSpace(true);
            }
        }

        this.position = movableBoardPosition;
        this.level = level;
        position.setMovableBoard(this);
    }

    public ArrayList<BoardPosition> getMoves(){
        ArrayList<BoardPosition> moves = new ArrayList<>();
        if(isBoardEmptyExceptForOnePawn()){
            if(this.position.getId() % 4 == 0){
                if(this.gameBoard.getBoardPosition(this.position.getId() + 1).getMovableBoard() == null){
                    moves.addAll(this.gameBoard.getBoardPosition(this.position.getId() + 1).getAllPositions());
                }
                if(this.gameBoard.getBoardPosition(this.position.getId() + 2).getMovableBoard() == null){
                    moves.addAll(this.gameBoard.getBoardPosition(this.position.getId() + 2).getAllPositions());
                }
            }
            else if(this.position.getId() % 4 == 1){
                if(this.gameBoard.getBoardPosition(this.position.getId() - 1).getMovableBoard() == null){
                    moves.addAll(this.gameBoard.getBoardPosition(this.position.getId() - 1).getAllPositions());
                }
                if(this.gameBoard.getBoardPosition(this.position.getId() + 2).getMovableBoard() == null){
                    moves.addAll(this.gameBoard.getBoardPosition(this.position.getId() + 2).getAllPositions());
                }
            }
            else if(this.position.getId() % 4 == 2){
                if(this.gameBoard.getBoardPosition(this.position.getId() + 1).getMovableBoard() == null){
                    moves.addAll(this.gameBoard.getBoardPosition(this.position.getId() + 1).getAllPositions());
                }
                if(this.gameBoard.getBoardPosition(this.position.getId() - 2).getMovableBoard() == null){
                    moves.addAll(this.gameBoard.getBoardPosition(this.position.getId() - 2).getAllPositions());
                }
            }
            else if(this.position.getId() % 4 == 3){
                if(this.gameBoard.getBoardPosition(this.position.getId() - 1).getMovableBoard() == null){
                    moves.addAll(this.gameBoard.getBoardPosition(this.position.getId() - 1).getAllPositions());
                }
                if(this.gameBoard.getBoardPosition(this.position.getId() - 2).getMovableBoard() == null){
                    moves.addAll(this.gameBoard.getBoardPosition(this.position.getId() - 2).getAllPositions());
                }
            }
        }
        else if(isBoardEmpty()){
            if(this.position.getId() % 4 == 0){
                if(this.gameBoard.getBoardPosition(this.position.getId() + 1).getMovableBoard() == null){
                    moves.addAll(this.gameBoard.getBoardPosition(this.position.getId() + 1).getAllPositions());
                }
                if(this.gameBoard.getBoardPosition(this.position.getId() + 2).getMovableBoard() == null){
                    moves.addAll(this.gameBoard.getBoardPosition(this.position.getId() + 2).getAllPositions());
                }
            }
            else if(this.position.getId() % 4 == 1){
                if(this.gameBoard.getBoardPosition(this.position.getId() - 1).getMovableBoard() == null){
                    moves.addAll(this.gameBoard.getBoardPosition(this.position.getId() - 1).getAllPositions());
                }
                if(this.gameBoard.getBoardPosition(this.position.getId() + 2).getMovableBoard() == null){
                    moves.addAll(this.gameBoard.getBoardPosition(this.position.getId() + 2).getAllPositions());
                }
            }
            else if(this.position.getId() % 4 == 2){
                if(this.gameBoard.getBoardPosition(this.position.getId() + 1).getMovableBoard() == null){
                    moves.addAll(this.gameBoard.getBoardPosition(this.position.getId() + 1).getAllPositions());
                }
                if(this.gameBoard.getBoardPosition(this.position.getId() - 2).getMovableBoard() == null){
                    moves.addAll(this.gameBoard.getBoardPosition(this.position.getId() - 2).getAllPositions());
                }
            }
            else if(this.position.getId() % 4 == 3){
                if(this.gameBoard.getBoardPosition(this.position.getId() - 1).getMovableBoard() == null){
                    moves.addAll(this.gameBoard.getBoardPosition(this.position.getId() - 1).getAllPositions());
                }
                if(this.gameBoard.getBoardPosition(this.position.getId() - 2).getMovableBoard() == null){
                    moves.addAll(this.gameBoard.getBoardPosition(this.position.getId() - 2).getAllPositions());
                }
            }

            if(this.position.getId() < 20 && this.gameBoard.getBoardPosition(this.position.getId() + 4).getMovableBoard() == null){
                moves.addAll(this.gameBoard.getBoardPosition(this.position.getId() + 4).getAllPositions());
            }
            if(this.position.getId() > 3 && this.gameBoard.getBoardPosition(this.position.getId() - 4).getMovableBoard() == null){
                moves.addAll(this.gameBoard.getBoardPosition(this.position.getId() - 4).getAllPositions());
            }
        }
        return moves;
    }

    public boolean isBoardEmpty(){
        for (int r = 0; r < this.board.size(); r ++){
            for(int c = 0; c < this.board.get(r).size(); c++){
                if(this.board.get(r).get(c).getPiece() != null){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isBoardEmptyExceptForOnePawn(){
        int numberOfPawns = 0;
        for (int r = 0; r < this.board.size(); r ++){
            for(int c = 0; c < this.board.get(r).size(); c++){
                if(this.board.get(r).get(c).getPiece() != null){
                    if(this.board.get(r).get(c).getPiece() instanceof Pawn){
                     numberOfPawns ++;
                    }
                    else{
                        return false;
                    }
                }
            }
        }
        return (numberOfPawns == 1);
    }

    public ArrayList<ArrayList<BoardPosition>> getBoard() {
        return board;
    }

    public void setBoard(ArrayList<ArrayList<BoardPosition>> board) {
        this.board = board;
    }

    public void setPosition(MovableBoardPosition position) {
        this.position = position;
    }

    public int getLevel() {
        return level;
    }

    public MovableBoardPosition getPosition() {
        return position;
    }

    public void printBoard(){
        System.out.print("Positions: ");
        for(int i = board.size() - 1; i >= 0 ; i--){
            for(int j = 0; j < board.get(i).size() ; j++){
                System.out.print(board.get(i).get(j).toString() + "; ");
            }
        }
        System.out.println();
        for(int i = board.size() - 1; i >= 0 ; i--){
            for(int j = 0; j < board.get(i).size() ; j++){
                if(board.get(i).get(j).getPiece() == null) {
                    System.out.print(".");
                }
                else{
                    board.get(i).get(j).getPiece().print();
                }
            }
            System.out.println();
        }
        System.out.println();
//        printVerbose();
    }

    public void printVerbose(){
        for(int i = board.size() - 1; i >= 0 ; i--){
            for(int j = 0; j < board.get(i).size() ; j++){
                if(board.get(i).get(j).getPiece() == null) {
                    System.out.print(".");
                    System.out.print(": " + board.get(i).get(j).toString() + "; ");
                }
                else{
                    board.get(i).get(j).getPiece().print();
                    System.out.print(": " + board.get(i).get(j).toString() + "; ");
                }
                System.out.println();
            }
        }
    }
}

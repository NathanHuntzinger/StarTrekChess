import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class GUITest extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        AtomicInteger currentLevel = new AtomicInteger(6);
        primaryStage.setTitle("Star Trek Chess");
        Game myGame = new Game();

        AtomicReference<BoardPosition> moveFrom = new AtomicReference<>(new BoardPosition());
        AtomicReference<BoardPosition> moveTo = new AtomicReference<>(new BoardPosition());
        AtomicReference<Boolean> pieceSelected = new AtomicReference<>(false);
        AtomicReference<Boolean> boardSelected = new AtomicReference<>(false);
        AtomicReference<Boolean> selectMovableBoard = new AtomicReference<>(false);
        AtomicReference<MovableBoardPosition> boardMoveFrom = new AtomicReference<>(new MovableBoardPosition());
        AtomicReference<MovableBoardPosition> boardMoveTo = new AtomicReference<>(new MovableBoardPosition());


        StackPane stackPane = new StackPane();

        ArrayList<GridPane> levels = new ArrayList<>();
        for (int i = 0; i < 7; i++){
            levels.add(new GridPane());
            stackPane.getChildren().add(levels.get(i));
        }
        ArrayList<ArrayList<ArrayList<BoardPosition>>> board = myGame.getGameBoard().getBoard();


        class BoardSquare extends Rectangle {
            int row;
            int col;

            BoardSquare(int width, int height, int row, int col){
                super(width, height);
                this.row = row;
                this.col = col;

                this.setOnMouseClicked(e->{
                    System.out.println("Space: (" + this.row + ", " + this.col + ") at level: " + currentLevel.get() + " was clicked");
                    if(selectMovableBoard.get() == false) {
                        if (pieceSelected.get() == false) {
                            if (myGame.getGameBoard().getPosition(this.row, this.col, currentLevel.get()).getPiece() != null) {
                                BoardPosition pos = myGame.getGameBoard().getPosition(this.row, this.col, currentLevel.get());
                                System.out.println("A piece was selected!");
                                pieceSelected.set(true);
                                moveFrom.set(pos);
                                ArrayList<BoardPosition> possibleMoves = myGame.getGameBoard().getPosition(this.row, this.col, currentLevel.get()).getPiece().getMoves();
                                for (BoardPosition move : possibleMoves){
                                    System.out.println(move.toString());
                                    StackPane stack = (StackPane) getNodeFromGridPane(levels.get(move.getLevel()), move.getCol(), move.getRow());
                                    Rectangle rect = (Rectangle) stack.getChildren().get(0);
                                    if(move.getPiece() != null){
                                        rect.setFill(Color.RED);
                                    }
                                    else {
                                        rect.setFill(Color.BLUE);
                                    }
                                }
                            }
                        } else {
                            if (myGame.getGameBoard().getPosition(this.row, this.col, currentLevel.get()).isValidSpace()) {
                                moveTo.set(myGame.getGameBoard().getPosition(this.row, this.col, currentLevel.get()));
                                myGame.executeMove(new Move(moveFrom.get(), moveTo.get()));
                                pieceSelected.set(false);
                                System.out.println("A piece was moved");
                                updateBoard(myGame, board, levels);
                            }
                        }
                    }
                    else{
                        if(boardSelected.get() == false){
                            System.out.println("Selecting board to move");
                            for(int i = 0; i < myGame.getGameBoard().getMovableBoardPositions().size(); i++){
                                ArrayList<ArrayList<BoardPosition>> section = myGame.getGameBoard().getMovableBoardPositions().get(i).getBoardSection();
                                for(int r = 0; r < section.size(); r ++){
                                    for(int c = 0; c < section.get(r).size(); c++){
                                        if(section.get(r).get(c) == myGame.getGameBoard().getPosition(this.row, this.col, currentLevel.get()) && myGame.getGameBoard().getMovableBoardPositions().get(i).getMovableBoard() != null){
                                            boardMoveFrom.set(myGame.getGameBoard().getMovableBoardPositions().get(i));
                                            boardSelected.set(true);
                                            System.out.println("A board was selected");
                                        }
                                    }
                                }
                            }
                        }
                        else{
                            for(int i = 0; i < myGame.getGameBoard().getMovableBoardPositions().size(); i++){
                                ArrayList<ArrayList<BoardPosition>> section = myGame.getGameBoard().getMovableBoardPositions().get(i).getBoardSection();
                                for(int r = 0; r < section.size(); r ++){
                                    for(int c = 0; c < section.get(r).size(); c++){
                                        if(section.get(r).get(c) == myGame.getGameBoard().getPosition(this.row, this.col, currentLevel.get())){
                                            boardMoveTo.set(myGame.getGameBoard().getMovableBoardPositions().get(i));
                                            myGame.executeMovableBoardMove(new MovableBoardMove(boardMoveFrom.get(), boardMoveTo.get()));
                                            boardSelected.set(false);
                                            selectMovableBoard.set(false);
                                            System.out.println("A board was moved");
                                            updateBoard(myGame, board, levels);
                                        }
                                    }
                                }
                            }

                        }
                    }
                });
            }

            public int getRow() {
                return row;
            }

            public int getCol() {
                return col;
            }
        }

        //first initializes the board.
        for (int r = 0; r < board.size(); r++) {
            for (int c = 0; c < board.get(r).size(); c++) {
                for (int l = 0; l < board.get(r).get(c).size(); l++) {
                    Rectangle rect = new Rectangle(50,50);
                    if(!myGame.getGameBoard().getPosition(r,c,l).isValidSpace()){
                        rect.setFill(Color.TRANSPARENT);
                    }
                    else{
                        if((r % 2 == 0 && c % 2 == 0) || (r % 2 == 1 && c % 2 == 1)){
                            rect.setFill(Color.WHITE);
                            rect.setStroke(Color.BLACK);
                        }
                        else{
                            rect.setFill(Color.BLACK);
                            rect.setStroke(Color.BLACK);
                        }
                    }
                    levels.get(l).add(new StackPane(rect), c, r);

                    Rectangle piece = new Rectangle(0,0,25, 25);
                    if(myGame.getGameBoard().getPosition(r,c,l).getPiece() instanceof Bishop){
                        piece.setFill(Color.LIGHTBLUE);
                        piece.setStroke(Color.BLACK);
                    }
                    else if(myGame.getGameBoard().getPosition(r,c,l).getPiece() instanceof King){
                        piece.setFill(Color.GOLD);
                        piece.setStroke(Color.BLACK);
                    }
                    else if(myGame.getGameBoard().getPosition(r,c,l).getPiece() instanceof King){
                        piece.setFill(Color.GOLD);
                        piece.setStroke(Color.BLACK);
                    }
                    else if(myGame.getGameBoard().getPosition(r,c,l).getPiece() instanceof Knight){
                        piece.setFill(Color.GREEN);
                        piece.setStroke(Color.BLACK);
                    }
                    else if(myGame.getGameBoard().getPosition(r,c,l).getPiece() instanceof Pawn){
                        piece.setFill(Color.PINK);
                        piece.setStroke(Color.BLACK);
                    }
                    else if(myGame.getGameBoard().getPosition(r,c,l).getPiece() instanceof Queen){
                        piece.setFill(Color.SILVER);
                        piece.setStroke(Color.BLACK);
                    }
                    else if(myGame.getGameBoard().getPosition(r,c,l).getPiece() instanceof Rook){
                        piece.setFill(Color.RED);
                        piece.setStroke(Color.BLACK);
                    }
                    else{
                        piece.setFill(Color.TRANSPARENT);
                        piece.setStroke(Color.TRANSPARENT);
                    }
                    StackPane stack = (StackPane) getNodeFromGridPane(levels.get(l), c, r);
                    stack.getChildren().add(1,piece);

                    BoardSquare clickableSquare = new BoardSquare(50,50,r,c);
                    clickableSquare.setFill(Color.TRANSPARENT);
                    stack.getChildren().add(2,clickableSquare);
                }
            }
        }

        Scene scene = new Scene(stackPane, 600, 600);

        scene.setOnKeyTyped(e->{
            Character levelChar = e.getCharacter().charAt(0);
            if(levelChar == '`'){
                levelChar = '0';
            }
            for (int r = 0; r < board.size(); r++) {
                for (int c = 0; c < board.get(r).size(); c++) {
                    for (int l = 0; l < board.get(r).get(c).size(); l++) {
                        if(Character.isDigit(levelChar)) {
                            StackPane stack = (StackPane) getNodeFromGridPane(levels.get(l), c, r);
                            Rectangle rect = (Rectangle) stack.getChildren().get(0);
                            Rectangle piece = (Rectangle) stack.getChildren().get(1);

                            if(levelChar == '7'){
                                currentLevel.set(6);
                                rect.setOpacity(1);
                                piece.setOpacity(1);
                            }
                            else if (Character.getNumericValue(levelChar) != l) {
                                rect.setOpacity(0.15);
                                piece.setOpacity(0.15);
                            }

                            else{
                                currentLevel.set(l);
                                rect.setOpacity(1);
                                piece.setOpacity(1);
                            }
                        }

                    }
                }
            }
        });

        scene.setOnKeyPressed(e->{
            if (e.getCode() == KeyCode.ESCAPE) {
                System.out.println("Deselecting");
                selectMovableBoard.set(false);
                boardSelected.set(false);
                pieceSelected.set(false);
                moveFrom.set(null);
                boardMoveFrom.set(null);
                updateBoard(myGame, board, levels);
            }
            else if (e.getCode() == KeyCode.SHIFT) {
                System.out.println("Entering board selection mode");
                selectMovableBoard.set(true);
            }
        });

        scene.setOnKeyReleased(e->{
            if (e.getCode() == KeyCode.SHIFT && boardSelected.get() == false) {
                System.out.println("Exiting board selection mode");
                selectMovableBoard.set(false);
            }
        });

        //These are just guess values to try to get it in the center
        stackPane.layoutXProperty().bind(scene.widthProperty().divide(2).subtract(stackPane.getWidth()/4));
        stackPane.layoutYProperty().bind(scene.heightProperty().divide(2).subtract(stackPane.getHeight()/2.5));

        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                return node;
            }
        }
        return null;
    }

    private void updateBoard(Game myGame, ArrayList<ArrayList<ArrayList<BoardPosition>>> board, ArrayList<GridPane> levels){
        for (int r = 0; r < board.size(); r++) {
            for (int c = 0; c < board.get(r).size(); c++) {
                for (int l = 0; l < board.get(r).get(c).size(); l++) {
                    StackPane stack = (StackPane) getNodeFromGridPane(levels.get(l), c, r);
                    Rectangle rect = (Rectangle) stack.getChildren().get(0);
                    Rectangle piece = (Rectangle) stack.getChildren().get(1);

                    if(!myGame.getGameBoard().getPosition(r,c,l).isValidSpace()){
                        rect.setFill(Color.TRANSPARENT);
                        rect.setStroke(Color.TRANSPARENT);
                    }
                    else{
                        if((r % 2 == 0 && c % 2 == 0) || (r % 2 == 1 && c % 2 == 1)){
                            rect.setFill(Color.WHITE);
                            rect.setStroke(Color.BLACK);
                        }
                        else{
                            rect.setFill(Color.BLACK);
                            rect.setStroke(Color.BLACK);
                        }
                    }

                    if(myGame.getGameBoard().getPosition(r,c,l).getPiece() instanceof Bishop){
                        piece.setFill(Color.LIGHTBLUE);
                        piece.setStroke(Color.BLACK);
                    }
                    else if(myGame.getGameBoard().getPosition(r,c,l).getPiece() instanceof King){
                        piece.setFill(Color.GOLD);
                        piece.setStroke(Color.BLACK);
                    }
                    else if(myGame.getGameBoard().getPosition(r,c,l).getPiece() instanceof King){
                        piece.setFill(Color.GOLD);
                        piece.setStroke(Color.BLACK);
                    }
                    else if(myGame.getGameBoard().getPosition(r,c,l).getPiece() instanceof Knight){
                        piece.setFill(Color.GREEN);
                        piece.setStroke(Color.BLACK);
                    }
                    else if(myGame.getGameBoard().getPosition(r,c,l).getPiece() instanceof Pawn){
                        piece.setFill(Color.PINK);
                        piece.setStroke(Color.BLACK);
                    }
                    else if(myGame.getGameBoard().getPosition(r,c,l).getPiece() instanceof Queen){
                        piece.setFill(Color.SILVER);
                        piece.setStroke(Color.BLACK);
                    }
                    else if(myGame.getGameBoard().getPosition(r,c,l).getPiece() instanceof Rook){
                        piece.setFill(Color.RED);
                        piece.setStroke(Color.BLACK);
                    }
                    else{
                        piece.setFill(Color.TRANSPARENT);
                        piece.setStroke(Color.TRANSPARENT);
                    }
                }
            }
        }
    }

}

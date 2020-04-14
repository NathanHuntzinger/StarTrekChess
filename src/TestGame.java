public class TestGame {
    public static void main(String[] args) {
        Game game = new Game();
        game.getGameBoard().printBoard();
        game.getPlayer1().print();
        game.getPlayer2().print();

        Move myMove = new Move(game.getPlayer1().getPieces().get(0).getPosition(), game.getGameBoard().getPosition(1,3,1));
        game.executeMove(myMove);

        MovableBoardMove myBoardMove = new MovableBoardMove(game.getGameBoard().getMovableBoardPositions().get(4), game.getGameBoard().getMovableBoardPositions().get(0));
        game.executeMovableBoardMove(myBoardMove);

        MovableBoardMove myBoardMove2 = new MovableBoardMove(game.getGameBoard().getMovableBoardPositions().get(0), game.getGameBoard().getMovableBoardPositions().get(1));
        game.executeMovableBoardMove(myBoardMove2);

        game.getGameBoard().printBoard();

        game.getGameBoard().printVerbose();
    }
}

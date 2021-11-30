/**
 * Filler main class used to test out the methods.
 */
public class Main {
    public static void main(String[] args) {
        //init new board class :))
        Board board = new Board();

        Piece testPiece = new Piece(0, 0, 'R', "man");
        //Test piece should show up on the board
        board.changeBoard(testPiece.get_xCord(), testPiece.get_yCord(), testPiece.get_pieceColor());
        board.update();

    }
}

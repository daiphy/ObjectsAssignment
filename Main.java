/**
 * Filler main class used to test out the methods.
 */
public class Main {
    public static void main(String[] args) {
        //init new board class :))
        Board board = new Board();
        
        Piece testPiece = new Piece(0, 0, 'R', "man");
        //Test piece should show up on the board, does not show
        board.update();

        System.out.println("Piece type: " + testPiece.get_pieceType());

    }
}

/**
 * Filler main class used to test out the methods.
 */
public class Main {
    public static void main(String[] args) {
        //init new board class :))
        Board board = new Board();
        System.out.println(board.checkMove(1, 2, 2, 3, "red", "man"));
        board.update();

    }
}

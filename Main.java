/**
 * Filler main class used to test out the methods.
 */
public class Main {
  public static void main(String[] args) {
      //init new board class :))
      Board board = new Board();

      board.makeMove(5, 1, 4, 2, "red", "pawn");

      board.update();
      // Input input = new Input();
      // System.out.println(board.checkMove(1, 2, 2, 3, "red", "man"));

      // Piece testPiece = new Piece(0, 4, 'R', "man");

      // //Test piece should show up on the board
      // board.changeBoard(testPiece.get_xCord(), testPiece.get_yCord(), testPiece.get_pieceColor());
      // board.update();
      // char[] userMove = new char[4]; //create new char to store the user moves
      // userMove = input.inputMethod(userMove); //gets the coordinates the user wants
      
      // for (int i = 0; i < userMove.length; i++) {
      //   System.out.println(userMove[i]);
      // }

                                   
  }
}
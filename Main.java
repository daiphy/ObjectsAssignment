/**
 * Filler main class used to test out the methods.
 */

public class Main {
  public static void main(String[] args) {
      //init new board class :))
      Board board = new Board();
      board.makeMove(5, 1, 4, 2, "red", "pawn");

      board.update();
      int posX = 0, posY = 0, newPosX = 0, newPosY = 0; //variables stores the old and new data for the moves the user wants
      String colour = "", piece = "";
      char[] userMoves = new char[4];
      board.update();
        //while (checkmate condition)
      while (true) {//temporary 
         do {
             if (board.getTurn() == true) {
                System.out.println("It's black's turn ^_^");
             }
             
             else {
                System.out.println("It's red's turn ^_^");
             }
             
             userMoves = Input.inputMethod(userMoves);
             for (int i = 0; i < 4; i++) {
               System.out.println(userMoves[i]);
             }
             
             posX = userMoves[0];
             posY = userMoves[1];
             newPosX = userMoves[2];
             newPosY = userMoves[3];
             System.out.println(posX + " " + posY + " " + newPosX + " " + newPosY);
             //get the id using the method getSquareId
             switch (board.getSquareId(posX, posY)) {
               case 'r':
                 colour = "red";
                 piece = "pawn";
                 break;
               case 'b':
                 colour = "black";
                 piece = "pawn";
                 break;
               case 'R':
                 colour = "red";
                 piece = "king";
                 break;
               case 'B':
                 colour = "black";
                 piece = "king";
                 break;
               default:
                 colour = "";
                 piece = "";
                 break; //nothing on the square.
             }
             
           } while (board.makeMove(posX, posY, newPosX, newPosY, colour, piece) == false); //if move is illegal, cycle back and ask another time
           //the black and man are placeholders at the moment 
           
           board.update();
        }
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
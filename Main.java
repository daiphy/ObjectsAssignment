/**
 * Filler main class used to test out the methods.
 */
public class Main {
    public static void main(String[] args) {
        //init new board class :))
        Board board = new Board();
        Input input = new Input();
        String piece = "", colour = "";
        int posX = 0, posY = 0, newPosX = 0, newPosY = 0; //variables stores the old and new data for the moves the user wants
        
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
             
             userMoves = input.inputMethod(userMoves);
             posX = userMoves[0];
             posY = userMoves[1];
             newPosX = userMoves[2];
             newPosY = userMoves[3];
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
             
           } while (board.checkMove(posX, posY, newPosX, newPosY, colour, piece) == false); //if move is illegal, cycle back and ask another time
           //the black and man are placeholders at the moment 
           board.update();
        }
        

        //while true { 


    }
}

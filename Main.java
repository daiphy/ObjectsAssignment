/**
 * Filler main class used to test out the methods.
 */
public class Main {
    public static void main(String[] args) {
        //init new board class :))
        Board board = new Board();
        Input input = new Input();
        
        int posX = 0, posY = 0, newPosX = 0, newPosY = 0; //variables stores the old and new data for the moves the user wants
        
        char[] userMoves = new char[4];
        //while (checkmate condition)
        while (true) {
           do {
             userMoves = inputMethod(userMoves);
             posX = userMoves[0];
             posY = userMoves[1];
             newPosX = userMoves[2];
             newPosY = userMoves[3];
           } while (board.checkMove(posX, posY, newPosX, newPosY, "red", "man") == false); //if move is illegal, cycle back and ask another time
           //the red and man are placeholders at the moment 
        }
        

        //while true { 


    }
}

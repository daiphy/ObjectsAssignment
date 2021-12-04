/**
 * Filler main class used to test out the methods.
 */

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
      //init new board class :))
    Board board = new Board();
    String userChoice = "";
    int gameStatus = 0; //the game status where we check if the game continues, ends in a win for red or black, or draw.
    int posX = 0, posY = 0, newPosX = 0, newPosY = 0; //variables stores the old and new data for the moves the user wants
    String colour = "", piece = "";
    char[] userMoves = new char[4];
    board.update();//show inital board
      //while (checkmate condition)
    while (true) {//temporary 
        while (true) {
            if (board.getTurn() == true) {
              System.out.println("It's black's turn ^_^");
            }
            
            else {
              System.out.println("It's red's turn ^_^");
            }
            
            userMoves = Input.inputMethod(userMoves);
            
            posY = Character.getNumericValue(userMoves[0]);
            posX = Character.getNumericValue(userMoves[1]);
            newPosY = Character.getNumericValue(userMoves[2]);
            newPosX = Character.getNumericValue(userMoves[3]);

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
            //legal move, stop asking. 
            if (board.makeMove(posY, posX, newPosY, newPosX, colour, piece) == true) {
              board.changeTurn();
            }
          //if move is illegal, cycle back and ask another time
          
          gameStatus = board.update(); 
            if (gameStatus != 0) {
              if (gameStatus == 1) {
                System.out.println("GG, black wins! :)");
              }
             //black victory
              else if (gameStatus == 2) {
                System.out.println("GG, red wins! :)");
              } //red victory

              else { //game status 3, aka draw.
                System.out.println("GG, draw (10 moves in a row with no captures)! :)");
              }
            break; //get out of the loop
          }
        }
        

        //ask if they want to play again
        System.out.print("Do you want to play again? (y/n) ");
        userChoice = scanner.nextLine();

        if (userChoice.equalsIgnoreCase("y")) {
          if (board.getTurn() == false) {//we need to reset so that black starts again
            board.changeTurn(); //swap turns
          }
        }

        else if (userChoice.equalsIgnoreCase("n")) {
          System.out.println("Thank you for playing :D ");
          break;
        }
//illegal input, reloop.
        else {
          System.out.println("Illegal input, try again. o_o ");
        }
      }
  }
  
}


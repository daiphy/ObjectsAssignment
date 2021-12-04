/**
 * The board class, which contains the private grid, constructor and
 * the methods to update and display the basic grid.
 */
public class Board {
    //the grid is private
    private char[][] grid = new char[8][8];
    int redCaptures = 0;
    int blackCaptures = 0;
    int movesNoCaptures = 0;
    Piece piece = new Piece();
    private boolean isBlackTurn = true;
    /**
     * THE CONSTRUCTOR METHOD
     * we create the new board here and add the pieces to the correct spots.
     * 
     */
      public Board() {

      // Setting the pieces in the correct spots on board
      for (int row = 0; row < 8; row++) {
        for (int col = 0; col < 8; col++) {
            // conds if the remainder of the row and col are equal ie 1,1 or 1,3 
            if ( row % 2 == col % 2 ) {
                // its black if the row is at the top (less than 3)
                if (row < 3) {
                  grid[row][col] = 'b';
                // its red if the row is at the top (more than 4)
                } else if (row > 4) {
                  grid[row][col] = 'r';
                } else {
                  grid[row][col] = ' '; // empty spaces
                }
            } else {
                grid[row][col] = ' '; // empty spaces
            }
        }
      }
    }

/**
 * This method tries to make a move, and calls the canmovebemade and cancapturecanbemade method to verify if the pieces can capture. 
 * If
 * @author Kevin Cao, Daiphy L, Jack M.
 * @param y1 og y-coordinate
 * @param x1 og x-coordinate
 * @param y2 new y-coordinate
 * @param x2 new x-coordinate
 * @param player player colour
 * @param type piece, king or pawn.
 * @return true false to see if you can make the specified move.
 */
  public boolean makeMove(int y1, int x1, int y2, int x2, String player, String type) {
        // condition if the move can be made or capture.  
        if (piece.canCaptureBeMade(y1, x1, y2, x2, player, this.grid, this.isBlackTurn) == true || piece.canMoveBeMade(y1, x1, y2, x2, player, type, this.grid, this.isBlackTurn) == true) {
          if (piece.canCaptureBeMade(y1, x1, y2, x2, player, this.grid, this.isBlackTurn) == true) {
            // row of the piece that needs to be eliminated
            int eliminatedRow = (x1 + x2) / 2;
            // column of the piece that needs to be eliminated
            int eliminatedCol = (y1 + y2) / 2;
            System.out.println(eliminatedCol + " " + eliminatedRow);
            if (player == "red") {
              //the number of pieces that have been captured
              this.blackCaptures++;
            }

            else {
              this.redCaptures++;
            }

            this.grid[eliminatedCol][eliminatedRow] = ' ';
            this.movesNoCaptures = 0;
          }

          else {
            this.movesNoCaptures++; //a regular move performed, add to the counter.
          }
          this.grid[y2][x2] = this.grid[y1][x1];
          this.grid[y1][x1] = ' ';
          // royal ascension
          if( y2 == 0 && this.grid[y2][x2] == 'r'){
            this.grid[y2][x2] = 'R';
          }
          if( y2 == 7 && grid[y2][x2] == 'b'){
            this.grid[y2][x2] = 'B';
          }
          // removing the enemy piece when the player has legally jumped over it
          
          return true;
        }
        //default case
        System.out.println("Sorry the move/capture is illegal. Please input another play. :/");
        return false;
      }
  /**
   * @author Kevin Cao
   * Get whose turn it is via the priv isBlackTurn variable.
   * 
   * @return
   */
  public boolean getTurn() {
    if (this.isBlackTurn == true) {
      return true;
    }
    else {
      return false;
    }
  }
  
  /**
   * Gets the id of the specified cell, as in colour and type.
   * @author Kevin C.
   * @param posX
   * @param posY
   * @return the char in the specified cell
   */
  public char getSquareId (int posX, int posY) {
    return this.grid[posX][posY];
  }
  
  /**
   * this method changes turns for the private blackturn bool.
   */
  public void changeTurn() {
    this.isBlackTurn = !(this.isBlackTurn);
  }
  
  /**
   * this method updates the grid, formats and prints the checkers grid to the screen.
   * @return
   */
  public int update() {
      System.out.println("-----  Pieces captured by black: " + this.redCaptures + " -----"); //Shows the number of red pieces captured
      System.out.println("   0  1  2  3  4  5  6  7");
      for(int i = 0; i < this.grid.length; i++) {
          System.out.print(i + " ");
          for (int j = 0; j < this.grid[0].length; j++) {
              System.out.print("[" + this.grid[i][j] + "]");
          }
          System.out.println(""); //newline
      }
      System.out.println("-----  Pieces captured by red: " + this.blackCaptures + " -----"); //shows number of black pieces captured
      int gameStatus = endCondition(); // get the number from endcondition to return to main
      return gameStatus;
  }
/**
 * /**This method checks whether any of the conditions below have been met to end the game
     * - All pieces of one color have been captured
     * - 10 moves were made without capturing any pieces
     * It will return a 1 for a black victory, 2 for a red victory, 3 for a tie, and 0 if the game continues
     
     We could have made this part of update method, but we chose to keep it more clean and separate.
 * @return the number which the game will check for end conditions.
 */
  public int endCondition() {
    
    if (this.redCaptures == 12) {
      return 1;
    }
    if (this.blackCaptures == 12) {
      return 2;
    }
    if (this.movesNoCaptures == 15) {
      return 3;
    }
    return 0;
  }
}

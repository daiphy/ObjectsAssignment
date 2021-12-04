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
 * @author Daiphy Lee, Kevin Cao, Jack Moore
 * Description : calls on validation methods to check if it is a valid move||capture -> if it is valid then it moves the pieces and deletes jumped pieces (if it's capture)
 * This method tries to make a move, and calls the canmovebemade and cancapturecanbemade method to verify if the pieces can capture. 
 * @param y1 row coord of the position user inputted to move from
 * @param x1 column coord of the position user inputted to move from
 * @param y2 row coord of the position user inputted to move to
 * @param x2 column coord of the position user inputted to move to
 * @param player define which player colour the current user is
 * @param type defines the type of checkers piece (pawn or royal)
 * @return true if move || capture is legal and changes the pieces on the board 
 *         false if move || capture is illegal
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
   * @author Kevin Cao, Jack Moore
   * Description : Determines which player's turn
   * Get whose turn it is via the priv isBlackTurn variable.
   * @return true if it is black pieces' turn
   * false if it is the red piece's turn
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
   * @author Kevin Cao
   * Description : Determines the element on the board
   * @param posY row coord 
   * @param posX column coord
   * @return the char element in the specified cell on the board
   */
  public char getSquareId (int posY, int posX) {
    return this.grid[posY][posX];
  }
  
  /**
   * @author Kevin Cao, Jack Moore
   * Description : Switches the player turn
   */
  public void changeTurn() {
    this.isBlackTurn = !(this.isBlackTurn);
  }
  
  /**
   * @author Kevin Cao, James Zheng
   * Description : Prints Board and checks end conditions
   * this method updates the grid, formats and prints the checkers grid to the screen.
   * @return gameStatus -> endConditions method
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
   * @author James Zheng
   * Description : Determines the winner of the game (or if it's a stale)
   * @return 1 -> Black Wins
   *         2 -> Red Wins
   *         3 -> Draw || Stalemate || Tied
   *         0 -> Continue
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

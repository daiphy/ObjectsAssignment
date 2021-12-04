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
        public Board() {
        //init constructor, temporairly all spaces, might add initial grid spaces later 
        // for(int i = 0; i < this.grid.length; i++) {
        //     for (int j = 0; j < this.grid[0].length; j++) {
        //         this.grid[i][j] = ' '; //empty space as we are initalizing :)
        //     }
        // }

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
    
    //might add on to this, very rough way to change values
    public void changeBoard(int posX, int posY, char value) {
        this.grid[posX][posY] = value;
    }

    //private method that checks for if a regular move (not capture can be made)
    private boolean canMoveBeMade(int posX, int posY, int newPosX, int newPosY, String colour, String type) {
      
      // Checks if the move made is on the board
      if (newPosX < 1 || newPosX > 8 || newPosY < 1 || newPosY > 8) {
        return false;
      }
            
      // Checks if the move made is diagonal of the current position
      int xDifference = Math.abs(posX - newPosX);
      int yDifference = Math.abs(posY - newPosY);
      if (xDifference != 1 || yDifference != 1) {
        return false;
      }
      
      // Checks if the move made is forward (unless the piece is a royal)
      //inverse for red and black, as red can only move from top to bottom and vice versa.
      if (type.equals("pawn") && colour.equals("black") && newPosY - posY != 1) {
            return false;
      }
      else if (type.equals("pawn") && colour.equals("red") && posY - newPosY != 1) {
            return false;
      }
      
      
    //   // Checks if new position isn't already taken by another piece
      if (grid[newPosX][newPosY] != ' ') {
        return false;
      }
      //default return true.
      movesNoCaptures++;
      return true;
    }
//move cancapture and canmove in piece.java
    public boolean makeMove(int x1, int y1, int x2, int y2, String player, String type){
      if (piece.canMoveBeMade(x1, y1, x2, y2, player, type)){
        grid[x2][y2] = grid[x1][y1];
        grid[x1][y1] = ' ';
        // royal ascension
        if( x2 == 0 && grid[x2][y2] == 'r'){
          grid[x2][y2] = 'R';
        }
        if( x2 == 7 && grid[x2][y2] == 'b'){
          grid[x2][y2] = 'B';
        }
        
        return true;//legit move already done
      }
      
        // removing the enemy piece when the player has legally jumped over it
      else if (x1 - x2 == 2 || x1 - x2 == -2){

        boolean extraCaptures = true;
        if (piece.canCaptureBeMade(x1,y1,x1+1,y1+1,x1+2,y1+2, player, type) == true 
        || piece.canCaptureBeMade(x1,y1,x1-1,y1+1,x1-2,y1+2, player, type) == true
        || piece.canCaptureBeMade(x1,y1,x1+1,y1-1,x1+2,y1-2, player,type) == true
        || piece.canCaptureBeMade(x1,y1,x1-1,y1-1,x1-2,y1-2, player, type) == true ){
         // row of the piece that needs to be eliminated
          int eliminatedRow = (x1 + x2) / 2;
          // column of the piece that needs to be eliminated
          int eliminatedCol = (y1 + y2) / 2;
          grid[eliminatedRow][eliminatedCol] = ' ';
          grid[x2][y2] = grid[x1][y1];
          grid[x1][y1] = ' ';
          // Checks to see whether more captures can be made after the current capture
          do{
            x1 = x2;
            y1 = y2;
            char[] userMoves = new char[2];
            // Checks to see if a capture is possible from the cell the piece jumped to
            if (piece.canCaptureBeMade(x1,y1,x1+1,y1+1,x1+2,y1+2, player, type) == true 
            || piece.canCaptureBeMade(x1,y1,x1-1,y1+1,x1-2,y1+2, player, type) == true
            || piece.canCaptureBeMade(x1,y1,x1+1,y1-1,x1+2,y1-2, player,type) == true
            || piece.canCaptureBeMade(x1,y1,x1-1,y1-1,x1-2,y1-2, player, type) == true ){
              int choice = Input.multiCaptures(); // Gives the player the choice of making the capture or not
              if (choice == 1){
                userMoves = Input.inputMethod(userMoves);
                x2 = userMoves[0];
                y2 = userMoves[1];
                // if (x2-x1 != |2| || y2-y1 != |2|){
                  
                // }
                if (piece.canCaptureBeMade(x1,y1,(x1+x2)/2,(y1+y2)/2,x2,y2, player, type) == true){
                  grid[(x1+x2)/2][(y1+y2)/2] = ' ';
                  grid[x2][y2] = grid[x1][y1];
                  grid[x1][y1] = ' ';
                }
              }
              else{
                extraCaptures = false;
              }
            }
            else{
              extraCaptures = false;
            }
          }while(extraCaptures == true);
          return true;
        }
        //default case
        System.out.println("Sorry the move/capture is illegal. Please input another play. :/");
        return false;
      }
      

  public void findForceCaptures() {
    for (int i=0; i<grid.length; i++) {
      for (int e=0; e<grid[i].length; e++) {
        
        char piece = grid[i][e];
        System.out.println(piece);
        
        // Execeutes if the piece is red
        if (piece == 'r' || piece == 'R') {

          if (i + 2 <= 7 && e - 2 >= 0) {
            char emptyPiece = grid[i + 2][e - 2];
            char enemyPiece = grid[i + 1][e - 1];
            if (emptyPiece == ' ') {
              if (enemyPiece == 'b' || enemyPiece == 'B') {
                System.out.println("Force take");
              }
            }
          }
          
          if (i + 2 <= 7 && e + 2 <= 7) {
            char emptyPiece = grid[i + 2][e + 2];
            char enemyPiece = grid[i + 1][e + 1];
            if (emptyPiece == ' ') {
              if (enemyPiece == 'b' || enemyPiece == 'B') {
                System.out.println("Force take");
              }
            }
          }
          
          if (piece == 'R') {
            
            if (i - 2 >= 0 && e - 2 >= 0) {
             
            }
            
          }
          

        }
        
        // Execeutes if the piece is a regular black piece
        else if (piece == 'b') {
        
        }
      }
    }
  }
  
  public boolean getTurn() {
    if (this.isBlackTurn == true) {
      return true;
    }
    else {
      return false;
    }
  }
  
  public char getSquareId (int posX, int posY) {
    return this.grid[posX][posY];
  }
  
  public void changeTurn() {
    this.isBlackTurn = !(this.isBlackTurn);
  }
  
  public int update() {
      System.out.println("-----  Pieces captured by black: " + redCaptures + " -----"); //Shows the number of red pieces captured
      System.out.println("   0  1  2  3  4  5  6  7");
      for(int i = 0; i < this.grid.length; i++) {
          System.out.print(i + " ");
          for (int j = 0; j < this.grid[0].length; j++) {
              System.out.print("[" + this.grid[i][j] + "]");
          }
          System.out.println(""); //newline
      }
      System.out.println("-----  Pieces captured by red: " + blackCaptures + " -----");
      int gameStatus = endCondition(redCaptures, blackCaptures, movesNoCaptures); 
      return gameStatus;
  }

  public int endCondition(int redCaptures, int blackCaptures, int movesNoCaptures) {
    /**This method checks whether any of the conditions below have been met to end the game
     * - All pieces of one color have been captured
     * - 10 moves were made without capturing any pieces
     * It will return a 1 for a black victory, 2 for a red victory, 3 for a tie, and 0 if the game continues
     */
    if (redCaptures == 12){
      return 1;
    }
    if (blackCaptures == 12){
      return 2;
    }
    if (movesNoCaptures == 10){
      return 3;
    }
    return 0;
  }
}

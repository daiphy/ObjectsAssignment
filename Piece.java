public class Piece {
    
    //protected char[][] grid = new char[8][8];
    // Fields
    protected int yCord;
    protected int xCord;
    protected char color;
    protected String type;

    public Piece (){
        //Ascension process assumes that red starts on the top, and black starts on the bottom
    }

    public int get_yCord(){

        return this.yCord;

    }

    public int get_xCord(){

        return this.xCord;

    }

    //protected method that checks for if a regular move (not capture can be made)
    /**
     * @author Oscar Law, Kevin Cao, Jack Moore, Daiphy Lee, James Zheng
     * Description : Determines if the move is legal by checking if the coords entered are valid moves
     * @param posX row coord of the position user inputted to move from
     * @param posY column coord of the position user inputted to move from
     * @param newPosX row coord of the position user inputted to move to
     * @param newPosY column coord of the position user inputted to move to
     * @param colour define which player colour the current user is
     * @param type defines the type of checkers piece (pawn or royal)
     * @param grid the 2d array checker board 
     * @return true -> if it is legal move
     *         false -> if the move is illegal
     */
    protected boolean canMoveBeMade(int posY, int posX, int newPosY, int newPosX, String colour, String type, char[][] grid, boolean isBlackTurn) {
    
        // Checks if the move made is on the board
        if (newPosX < 0 || newPosX > 7 || newPosY < 0 || newPosY > 7) {
          return false;
        }
              
        // Checks if the move made is diagonal of the current position
        int xDifference = Math.abs(newPosX - posX);
        int yDifference = Math.abs(newPosY - posY);
        if (xDifference != 1 || yDifference != 1) {
          //System.out.println("not diagonal");
          return false;
        }
        
        //inverse for red and black, as red can only move from top to bottom and vice versa.
        if (colour.equals("black")) {
          //cannot move if you are moving an enemy piece 
          if (isBlackTurn == false) {
            System.out.println("You cannot move an enemy piece on your turn! ");
            return false;
          }
          // Checks if the move made is forward (unless the piece is a royal)

          if (type.equals("pawn") && (newPosY < posY)) {
            System.out.println("regular pieces cannot move backwards! ");
            System.out.println(newPosY + " " + posY);
            return false;
          }
        }
        
        else if (colour.equals("red")) {
          if (isBlackTurn == true) {
            System.out.println("You cannot move an enemy piece on your turn! ");
            return false;
          }
          if (type.equals("pawn") && (newPosY > posY)) {
            System.out.println("regular pieces cannot move backwards! ");
            return false;
          } 
        }
   
        // Checks if new position isn't already taken by another piece
  
        if (grid[newPosY][newPosX] != ' ') {
          System.out.println("space is already taken!");
          System.out.println(grid[newPosX][newPosY]);
          return false;
        }
        //default return true.
        return true;
      }
  
    /**
     * @author Daiphy Lee, Oscar Law, Kevin Cao
     * Description : Determines if capture is legal by checking the coords entered and all illegal capture tries
     * @param posX row coord of the position user inputted to move from
     * @param posY column coord of the position user inputted to move from
     * @param newPosX row coord of the position user inputted to move to
     * @param newPosY column coord of the position user inputted to move to
     * @param colour define which player colour the current user is
     * @param grid the 2d array checker board 
     * @param isBlackTurn the boolean to check which player's turn it is
     * @return true -> if capture is legal
     *         false -> if capture is illegal
     */
    protected boolean canCaptureBeMade(int posX, int posY, int newPosX, int newPosY, String colour, char[][] grid, boolean isBlackTurn) {
      
      // Checks if the move made is on the board
      if (newPosX < 0 || newPosX > 7 || newPosY < 0 || newPosY > 7) {
        System.out.println("off the board ");
        return false;
      }
      
      // checks if there's an empty space at the current position
      if (grid[posX][posY] == ' ') {
        //System.out.println(grid[posX][posY]);
        //System.out.println("no piece at chosen position! ");
        return false;
      }
      
      // checks if there's an empty space at the new position
      if (grid[newPosX][newPosY] != ' ') {
        System.out.println("full space at new position! ");
        return false;
      }
      
      // conds if the difference between the 2 points is not 2
      int xDifference = Math.abs(posX - newPosX);
      int yDifference = Math.abs(posY - newPosY);
      if (xDifference != 2 || yDifference != 2) {
        //System.out.println("2 part difference");
        return false;
      }
      
      // finds the middle piece coords (from the diagonal)       
      int middleX = (posX + newPosX) / 2;
      int middleY = (posY + newPosY) / 2;

      char piece = grid[posX][posY];
      System.out.println("Colour: " + colour + " is it black's turn: " + isBlackTurn);
      if (colour.equals("red") == true) {

        if (isBlackTurn == true) {
          System.out.println("You cannot move enemy pieces on your turn! ");
          return false;
        }
        
        char middlePiece = grid[middleX][middleY];


        if (middlePiece == 'r' || middlePiece == 'R') {
          System.out.println("cannot capture your own piece! ");
          return false; 
        }

        if (middleX > posX && piece == 'r') {
          System.out.println("Cannot capture backwards (normal pawn)! ");
          return false;
        }

        //default case you can capture!! :)
        return true;
      }

      else { //black pieces
        
        if (isBlackTurn == false) {
          System.out.println("You cannot move enemy pieces on your turn! ");
          return false;
        }
        char middlePiece = grid[middleX][middleY];

        if (middlePiece == 'b' || middlePiece == 'B') {
          System.out.println("cannot capture your own piece! ");
          return false; 
        }

        if (middleX < posX && piece == 'b') {
          System.out.println("Cannot capture backwards (normal pawn)! ");
          return false;
        }
        
        //default case, you can capture.
        return true;
            
      }
    }

}


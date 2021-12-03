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

    /**
     * Note: after the move is validated  and the loop exited
     * I will grab the last 2 numbers in the array and update the piece object being moved with those numbers
     * - James Z
     */

   
    //protected method that checks for if a regular move (not capture can be made)
    protected boolean canMoveBeMade(int posX, int posY, int newPosX, int newPosY, String colour, String type, char[] grid) {
      
        // Checks if the move made is on the board
        if (newPosX < 1 || newPosX > 8 || newPosY < 1 || newPosY > 8) {
          return false;
        }
              
        // Checks if the move made is diagonal of the current position
        int xDifference = Math.abs(newPosX - posX);
        int yDifference = Math.abs(newPosY - posY);
        if (xDifference != 1 || yDifference != 1) {
          System.out.println("1");
          return false;
        }
        
        // Checks if the move made is forward (unless the piece is a royal)
        //inverse for red and black, as red can only move from top to bottom and vice versa.
        if (type.equals("pawn") && colour.equals("black") && newPosY - posY != 1) {
              System.out.println("2");
              return false;
        }
        else if (type.equals("pawn") && colour.equals("red") && posY - newPosY != 1) {
              System.out.println("3");
              return false;
        }
        
        
        // Checks if new position isn't already taken by another piece
  
        if (grid[newPosY][newPosX] != ' ') {
          
          System.out.println("4");
          return false;
        }
        //default return true.
        return true;
      }
  
    protected boolean canCaptureBeMade(int posX, int posY, int newPosX, int newPosY, String colour, char[] grid) {
      
      // Checks if the move made is on the board
      if (newPosX < 0 || newPosX > 7 || newPosY < 0 || newPosY > 7) {
        System.out.println("off the board");
        return false;
      }
      
      // checks if there's an empty space at the current position
      if (grid[posX][posY] == ' ') {
        System.out.println("empty space");
        return false;
      }
      
      // checks if there's an empty space at the new position
      if (grid[newPosX][newPosY] != ' ') {
        System.out.println("empty space at new position");
        return false;
      }
      
      // conds if the difference between the 2 points is not 2
      int xDifference = Math.abs(posX - newPosX);
      int yDifference = Math.abs(posY - newPosY);
      if (xDifference != 2 || yDifference != 2) {
        System.out.println("2 part difference");
        return false;
      }
      
      // finds the middle piece coords        
      int middleX = (posX + newPosX) / 2;
      int middleY = (posY + newPosY) / 2;

      char piece = grid[posX][posY];
      if (colour.equals("red")) {
        
        char middlePiece = grid[middleX][middleY];
        if (middleX > posX && piece == 'r') {
          return false;
        }
        
        if (middlePiece == 'b' || middlePiece == 'B') {
          return true;
        }
      }
      else {
        
        char middlePiece = grid[middleX][middleY];
        if (middleX < posX && piece == 'b') {
          return false;
        }
        
        if (middlePiece == 'r' || middlePiece == 'R') {
          return true;
        }     
      }
      return false;
    }

}


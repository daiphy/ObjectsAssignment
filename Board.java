/**
 * The board class, which contains the private grid, constructor and
 * the methods to update and display the basic grid.
 */
public class Board {
    //the grid is private
    private char[][] grid = new char[8][8];

    public Board() {
        //init constructor, temporairly all spaces, might add initial grid spaces later 
        for(int i = 0; i < this.grid.length; i++) {
            for (int j = 0; j < this.grid[0].length; j++) {
                this.grid[i][j] = ' '; //empty space as we are initalizing :)
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
      if (type.equals("man") && colour.equals("black") && newPosY - posY != 1) {
            return false;
      }
      else if (type.equals("man") && colour.equals("red") && posY - newPosY != 1) {
            return false;
      }
      
      
      // Checks if new position isn't already taken by another piece

      if (grid[newPosX][newPosY] != ' ') {
        return false;
      }
      //default return true.
      return true;
    }
    
    public boolean canCaptureBeMade(int posX, int posY, int newPosX, int newPosY, String colour) {
      
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
    // the public method that will be called when a move is made, if both methods return false then the move is illegal
//     public boolean checkMove(int posX, int posY, int newPosX, int newPosY, String colour, String type) {
//       if (canMoveBeMade(posX, posY, newPosX, newPosY, colour, type) == false && 
//           canCaptureBeMade(posX, posY, newPosX, newPosY, colour) == false) {
//         return false;
//       }
//       else {
//         return true;
//       }
//     }
      public void update() {
        System.out.println("------------------------");
        for(int i = 0; i < this.grid.length; i++) {
            for (int j = 0; j < this.grid[0].length; j++) {
                System.out.print("[" + this.grid[i][j] + "]");
            }
            System.out.println(""); //newline
        }
        System.out.println("------------------------"); 
    }
}

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

    public boolean canMoveBeMade(int posX, int posY, int newPosX, int newPosY, String colour, String type) {
      
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
      if (type == "man") {
        if (colour == "black") {
          if (newPosY - posY != 1) {
            return false;
          }
        }
        else if (colour == "red") {
          if (posY - newPosY != 1) {
            return false;
          }
        }
      }
      
      // Checks if new position isn't already taken by another piece
      if (grid[newPosX][newPosY] != ' ') {
        return false;
      }
      
      return true;
    }
    
    private boolean canCaptureBeMade(int posX, int posY, int newPosX, int newPosY, String colour, String type) {
      
      
      
      return false;
    }
    
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
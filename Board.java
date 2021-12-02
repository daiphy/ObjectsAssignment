/**
 * The board class, which contains the private grid, constructor and
 * the methods to update and display the basic grid.
 */
public class Board {
    //the grid is private
    private char[][] grid = new char[8][8];
    Piece piece = new Piece();
    boolean isBlackTurn = true;
    
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

    // //private method that checks for if a regular move (not capture can be made)
    // private boolean canMoveBeMade(int posX, int posY, int newPosX, int newPosY, String colour, String type) {
      
    //   // Checks if the move made is on the board
    //   if (newPosX < 1 || newPosX > 8 || newPosY < 1 || newPosY > 8) {
    //     return false;
    //   }
            
    //   // Checks if the move made is diagonal of the current position
    //   int xDifference = Math.abs(posX - newPosX);
    //   int yDifference = Math.abs(posY - newPosY);
    //   if (xDifference != 1 || yDifference != 1) {
    //     return false;
    //   }
      
    //   // Checks if the move made is forward (unless the piece is a royal)
    //   //inverse for red and black, as red can only move from top to bottom and vice versa.
    //   if (type.equals("pawn") && colour.equals("black") && newPosY - posY != 1) {
    //         return false;
    //   }
    //   else if (type.equals("pawn") && colour.equals("red") && posY - newPosY != 1) {
    //         return false;
    //   }
      
      
    //   // Checks if new position isn't already taken by another piece

    //   if (grid[newPosX][newPosY] != ' ') {
    //     return false;
    //   }
    //   //default return true.
    //   return true;
    // }

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
        if (piece.canCaptureBeMade(x1,y1,x1+1,y1+1,x1+2,y1+2, player, type) == true 
        || piece.canCaptureBeMade(x1,y1,x1-1,y1+1,x1-2,y1+2, player, type) == true
        || piece.canCaptureBeMade(x1,y1,x1+1,y1-1,x1+2,y1-2, player,type) == true
        || piece.canCaptureBeMade(x1,y1,x1-1,y1-1,x1-2,y1-2, player, type) == true ){
         // row of the piece that needs to be eliminated
          int eliminatedRow = (x1 + x2) / 2;
          // column of the piece that needs to be eliminated
          int eliminatedCol = (y1 + y2) / 2;
          grid[eliminatedRow][eliminatedCol] = ' ';
          return true;
        }
      }
       //base case
       System.out.println("Sorry the move/capture is illegal. Please input another play. :/");
       return false;
         
    }
    
    // public boolean canCaptureBeMade(int x1, int y1, int x2, int y2, int x3, int y3, String colour, String type) {

    //   boolean capture = false;

    //     // kill can not be made if the second coords inputted are off board
    //     if (x3 < 0 || x3 >= 8 || y3 < 0 || y3 >= 8){
    //       return false;
    //     }
    //     // (x2,y2) has another piece there
    //     if (grid[x3][y3] == 'r' || grid[x3][y3] == 'R' || grid[x3][y3] == 'B' ||grid[x3][y3] == 'B'){
    //       return false;
    //     }
    //     if (type.equalsIgnoreCase("pawn")){ 
    //       // only applies to red pieces
    //       if (colour.equalsIgnoreCase("red")){
    //         // piece can not move down (can only move up)
    //         if ((grid[x1][y1] == 'r') && x3 > x1){
    //           return false;
    //         }
    //         // no black pieces to jump over
    //         if (grid[x2][y2] == 'b' || grid[x2][y2] == 'B'){
    //           return false;
    //         }
    //         return true;
    //         // capture = canCaptureBeMade(x3, y3, (x3+2), (y3+2), colour, type);
    //       }
    //       // only applies to black pieces
    //       else{
    //         // piece can not move up (can only move down)
    //         if ((grid[x1][y1] == 'b') && x3 < x1){
    //           return false;
    //         }
    //         // no red pieces to jump over
    //         if (grid[x2][y2] == 'r' || grid[x2][y2] == 'R'){
    //           return false;
    //         }
    //         return true;
    //         // capture = canCaptureBeMade(newPosX, newPosY, (newPosX+2), (newPosY+2), colour, type);
    //       }
    //     }
    //     else if(type.equalsIgnoreCase("royal")) {
    //       // only applies to red pieces
    //       if (colour.equalsIgnoreCase("red")){
    //         if (grid[x2][y2] == 'b' || grid[x2][y2] == 'B'){
    //           return false;
    //         }
    //         return true;
    //         // capture = canCaptureBeMade(x3, y3, (x3+2), (y3+2), colour, type);
    //       }
    //       // only applies to black pieces
    //       else{
    //         // no red pieces to jump over
    //         if (grid[x2][y2] == 'r' || grid[x2][y2] == 'R'){
    //           return false;
    //         }
    //         return true;
    //         // capture = canCaptureBeMade(newPosX, newPosY, (newPosX+2), (newPosY+2), colour, type);
    //       }
    //     }
    //     return false;
          
    // }
    
    public boolean getTurn() {
      if (isBlackTurn == true) {
        return true;
      }
      else {
        return false;
      }
    }
    
    public char getSquareId (int posX, int posY) {
      System.out.print(posX + " " + posY);
      return grid[posX][posY];
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
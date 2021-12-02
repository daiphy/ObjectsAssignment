public class Piece {
    
    protected char[][] grid = new char[8][8];
    // Fields
    protected int yCord;
    protected int xCord;
    protected char color;
    protected String type;

    public Piece (int inputyCord, int inputxCord, char pieceColor, String pieceType){
  // int inputyCord, int inputxCord, char pieceColor, String pieceType
        /**
         * This assumes that the object initializer includes the coordinates of the piece
         * As well as the color and type of the piece
         * Assumed format for piece traits is (row number, column number, piece color, piece type)
         */

        yCord = inputyCord;
        xCord = inputxCord;
        color = pieceColor;
        type = pieceType;

    }

    public int get_yCord(){

        return this.yCord;

    }

    public int get_xCord(){

        return this.xCord;
        // yCord = inputyCord;
        // xCord = inputxCord;
        // color = pieceColor;
        // type = pieceType;

    }

    /**
     * Note: after the move is validated  and the loop exited
     * I will grab the last 2 numbers in the array and update the piece object being moved with those numbers
     * - James Z
     */

    // public int get_yCord(){
    //     return this.yCord;
    // }

    // public int get_xCord(){
    //     return this.xCord;
    // }

    // public char get_pieceColor(){
    //     return this.color;
  // }

    // }
    // public String get_pieceType(){
    //     return this.type;

    // }
    //private method that checks for if a regular move (not capture can be made)
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
        //inverse for red and black, as red can only move from top to bottom and vice versa.
        if (type.equals("pawn") && colour.equals("black") && newPosY - posY != 1) {
              return false;
        }
        else if (type.equals("pawn") && colour.equals("red") && posY - newPosY != 1) {
              return false;
        }
        
        
        // Checks if new position isn't already taken by another piece
  
        if (grid[newPosX][newPosY] != ' ') {
          return false;
        }
        //default return true.
        return true;
      }
  
    //   public void makeMove(int x1, int y1, int x2, int y2, String player, String type){
    //     if (canMoveBeMade(x1, y1, x2, y2, player, type)){
    //       // removing the enemy piece when the player has legally jumped over it
    //       if ( x1 - x2 == 2 || x1 - x2 == -2){
    //         if (canCaptureBeMade(x1,y1,x1+1,y1+1,x1+2,y1+2, player, type) == true 
    //         || canCaptureBeMade(x1,y1,x1-1,y1+1,x1-2,y1+2, player, type) == true
    //         || canCaptureBeMade(x1,y1,x1+1,y1-1,x1+2,y1-2, player,type) == true
    //         || canCaptureBeMade(x1,y1,x1-1,y1-1,x1-2,y1-2, player, type) == true ){
    //           // row of the piece that needs to be eliminated
    //           int eliminatedRow = (x1 + x2) / 2;
    //           // column of the piece that needs to be eliminated
    //           int eliminatedCol = (y1 + y2) / 2;
    //           grid[eliminatedRow][eliminatedCol] = ' ';
    //         }
    //         else {
    //           System.out.println("Sorry the capture is illegal. Please input another play.");
    //         }
    //       }
    //       grid[x2][y2] = grid[x1][y1];
    //       grid[x1][y1] = ' ';
    //       // royal ascension
    //       if( x2 == 0 && grid[x2][y2] == 'r'){
    //         grid[x2][y2] = 'R';
    //       }
    //       if( x2 == 7 && grid[x2][y2] == 'b'){
    //         grid[x2][y2] = 'B';
    //       }
    //     }
    //     else {
    //       System.out.println("Sorry the move is illegal. Please input another play.");
    //     }
    //   }
      
      public boolean canCaptureBeMade(int x1, int y1, int x2, int y2, int x3, int y3, String colour, String type) {
  
          // kill can not be made if the second coords inputted are off board
          if (x3 < 0 || x3 >= 8 || y3 < 0 || y3 >= 8){
            return false;
          }
          // (x2,y2) has another piece there
          if (grid[x3][y3] == 'r' || grid[x3][y3] == 'R' || grid[x3][y3] == 'B' ||grid[x3][y3] == 'B'){
            return false;
          }
          if (type.equalsIgnoreCase("pawn")){ 
            // only applies to red pieces
            if (colour.equalsIgnoreCase("red")){
              // piece can not move down (can only move up)
              if ((grid[x1][y1] == 'r') && x3 > x1){
                return false;
              }
              // no black pieces to jump over
              if (grid[x2][y2] == 'b' || grid[x2][y2] == 'B'){
                return false;
              }
              return true;
              // capture = canCaptureBeMade(x3, y3, (x3+2), (y3+2), colour, type);
            }
            // only applies to black pieces
            else{
              // piece can not move up (can only move down)
              if ((grid[x1][y1] == 'b') && x3 < x1){
                return false;
              }
              // no red pieces to jump over
              if (grid[x2][y2] == 'r' || grid[x2][y2] == 'R'){
                return false;
              }
              return true;
              // capture = canCaptureBeMade(newPosX, newPosY, (newPosX+2), (newPosY+2), colour, type);
            }
          }
          else if(type.equalsIgnoreCase("royal")) {
            // only applies to red pieces
            if (colour.equalsIgnoreCase("red")){
              if (grid[x2][y2] == 'b' || grid[x2][y2] == 'B'){
                return false;
              }
              return true;
              // capture = canCaptureBeMade(x3, y3, (x3+2), (y3+2), colour, type);
            }
            // only applies to black pieces
            else{
              // no red pieces to jump over
              if (grid[x2][y2] == 'r' || grid[x2][y2] == 'R'){
                return false;
              }
              return true;
              // capture = canCaptureBeMade(newPosX, newPosY, (newPosX+2), (newPosY+2), colour, type);
            }
          }
          return false;
            
      }

}

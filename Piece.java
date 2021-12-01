public class Piece {
    
    // Fields
    protected int yCord;
    protected int xCord;
    protected char color;
    protected String type;

    public Piece (int inputyCord, int inputxCord, char pieceColor, String pieceType){

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

    /**
     * Note: after the move is validated  and the loop exited
     * I will grab the last 2 numbers in the array and update the piece object being moved with those numbers
     * - James Z
     */

    public int get_yCord(){
        return this.yCord;
    }

    public int get_xCord(){
        return this.xCord;
    }

    public char get_pieceColor(){
        return this.color;

    }
    public String get_pieceType(){
        return this.type;

    }

}


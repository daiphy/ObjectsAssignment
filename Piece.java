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

        //Ascension process assumes that red starts on the top, and black starts on the bottom
        if (color == 'R' && yCord == 7 && type.equals("man")){

            type = "king";

        }

        if (color == 'B' && yCord == 0 && type.equals("man")){

            type = "king";

        }

    }

    public int get_yCord(){

        return yCord;

    }

    public int get_xCord(){

        return xCord;

    }

    public char get_pieceColor(){

        return color;

    }
    
    public String get_pieceType(){

        return type;

    }

}


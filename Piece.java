public class Piece {
    
    // Fields
    private int yCord;
    private int xCord;
    private char color;
    private char type;

    public Piece (int inputyCord, int inputxCord, char pieceColor, char pieceType){

        yCord = inputyCord;
        xCord = inputxCord;
        color = pieceColor;
        type = pieceType;

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
    
    public int get_pieceType(){

        return type;

    }

}

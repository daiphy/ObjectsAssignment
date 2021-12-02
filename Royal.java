public class King extends Piece{

    public King (int inputyCord, int inputxCord, char pieceColor, String pieceType){

        super(inputyCord, inputxCord, pieceColor, pieceType);
        type = "king";

    }
    
    public String get_pieceType(){

        return type;

    }
}

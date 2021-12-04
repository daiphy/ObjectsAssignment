public class Royal extends Piece{

    /**
     * @author James Zheng
     * Description : Changes a pawn piece to a royal piece
     */
    public Royal (int inputyCord, int inputxCord, char pieceColor, String pieceType){

        this.type = "royal";
    }
    
    /**
     * @author James Zheng
     * Description : Determines the type of the piece
     */
    public String get_pieceType(){

        return this.type;

    }
}


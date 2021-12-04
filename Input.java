import java.util.Scanner;

public class Input{
    /**
     * @author Jack Moore, Kevin Cao
     * Description : Takes the user input and stores it in an char array
     * @param array stores all the coords of the user inputs
     * @return array -> arr with all the coords of user inputs stored
     *         array[0] -> y value of the move from coords
     *         array[1] -> x value of the move from coords
     *         array[2] -> y value of the move to coords
     *         array[3] -> x value of the move to coords
     */
    public static char[] inputMethod(char[] array){
        /* 
         * User Input Method
        */
        Scanner s = new Scanner(System.in);
        String string = "";
        boolean ansValid=false;
        //loop for x coord of piece
        System.out.print("Please enter the coordinates of your piece ");
        System.out.print("and then the coordinate you wish to move it to ");
        System.out.println("in the format (y,x);(newY,newX)");
        int f=0;       
            //Current input should look something like (1,2);(3,4)    
        do {
            string = s.nextLine();
            if (string.charAt(0) == '(' && string.charAt(2) == ','&& string.charAt(4) == ')'&& string.charAt(5) == ';'
            && string.charAt(6) == '('&& string.charAt(8) ==',' && string.charAt(10) == ')') {
                ansValid=true;
            }

            else {
                ansValid=false;
                System.out.println("Invalid input, try again! :/ ");
            }
        } while(!ansValid);
            String[] b=string.split(";",2);
            //Should now look like (1,2)
            //(3,4)
            for (int z=0;z<b.length;z++){
            String[] c=b[z].split(",",3);
            /**
             * Will look like (1
             * 2) //Iteration 1
             * (3
             * 4) //Iteration 2
             */
                for (int y=0;y<c.length;y++){
                    String sub = c[y];//a substituted and simplified thingie
                    for (int x=0; x < (sub.length()); x++){

                        if (sub.charAt(x) !='('&&sub.charAt(x) !=')'){
                            
                            array[f]=c[y].charAt(x);
                            f++;
                        }
                        
                    }
                //System.out.println(c[y]);
                }
            }
            return array;
        }
}

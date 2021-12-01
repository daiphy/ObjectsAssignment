import java.util.Scanner;

public class Input{
    public static char[] inputMethod(char[] array){

        /* 
         * User Input Method
         * 
         * 
        */
        Scanner s=new Scanner(System.in);
        boolean ask=true;
        String string="";
        int count=0;
        do{//loop for x coord of piece
                System.out.print("Please enter the coordinates of your piece ");
                System.out.print("and then the coordinate you wish to move it to ");
                System.out.println("in the format (x,y);(x,y)");
                int f=0;
/*(1
 * 1)
 *(2
 * 2)*/
                string=s.nextLine();
                String[] b=string.split(";",2);
                for (int z=0;z<b.length;z++){
                    String[] c=b[z].split(",",3);

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
            
//(1,1);(2,2)              
            ask=placeholder(array);
        } while(ask);
        s.close();
        return array;
    }
    public static boolean placeholder(char[] array){
        /*
         * Placeholder method for the validation inputs made by other members
         * 
        */
        return false;
    }
}
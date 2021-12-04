import java.util.Scanner;

public class Input{
    public static char[] inputMethod(char[] array){

        /* 
         * User Input Method
         * 
         * 
        */
        Scanner s=new Scanner(System.in);
        String string="";
        //loop for x coord of piece
            System.out.print("Please enter the coordinates of your piece ");
            System.out.print("and then the coordinate you wish to move it to ");
            System.out.println("in the format (y,x);(newY,newX)");
            int f=0;
            //Current input should look something like (1,2);(3,4)
            string=s.nextLine();
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
            
//(1,1);(2,2)              
        return array;
    }

    public static char[] multiMove(char[] array){

        /* 
         * User Input Method
         * 
         * 
        */
        Scanner s=new Scanner(System.in);
        String string="";
        System.out.print("Please enter the coordinates of your piece ");
        System.out.print("and then the coordinate you wish to move it to ");
        System.out.println("in the format (x,y)");
        int f=0;
        //Current input should look something like (1,2);(3,4)
        string=s.nextLine();
        String[] b=string.split(",",2);
        //Should now look like (1,2)
        //(3,4)
        for (int z=0;z<b.length;z++){
            String sub = b[z];//a substituted and simplified thingie
                for (int x=0; x < (sub.length()); x++){
                    if (sub.charAt(x) !='('&&sub.charAt(x) !=')'){
                        
                        array[f]=b[z].charAt(x);
                        f++;
                    }
                    
            }
            //System.out.println(c[y]);
            }
        s.close();
        return array;
        }

    public static int multiCaptures(){
        Scanner s=new Scanner(System.in);
        System.out.println("You are able to make another capture. ");
        System.out.println("Enter 1 if you wish to capture more pieces, ");
        System.out.println("Or enter 2 to end your turn. ");
        int playerChoice = s.nextInt();
        s.close();
        return playerChoice;
    }

    public static boolean placeholder(char[] array){
        /*
         * Placeholder method for the validation inputs made by other members
         * 
        */
        return false;
    }
}
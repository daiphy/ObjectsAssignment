import java.util.Scanner;

public class Input {

    public static char[] inputMethod(char[] array){

        /* 
         * User Input Method
         * returns char values of the inputed coors 
         * in an array
        */
        Scanner s=new Scanner(System.in);
        boolean ask=true;
        String string="";
        int count=0;
            System.out.print("Please enter the coordinates of your piece ");
            System.out.print("and then the coordinate you wish to move it to ");
            System.out.println("in the format (x,y);(x,y)");
            int f=0;
            //Current input should look something like (1, 2);(3, 4)
            string=s.nextLine();
            String[] b=string.split(";",2);
            //Should now look like (1, 2)
            //(3, 4)
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

                    }
            }
            
//(1,1);(2,2)              
        return array;
    }

}

import java.util.Scanner;

public class checkers_input{
    public static char[] inputMethod(char[] a){
        Scanner s=new Scanner(System.in);
        boolean ask=true;
        String string="";
        do{//loop for x coord of piece
                System.out.print("Please enter the coordinates of your piece ");
                System.out.print("and then the coordinate you wish to move it to ");
                System.out.println("in the format (x,y);(x,y)");

                string=s.nextLine();
                //for (int i=0;i<string.length();i++){
                    String[] c=string.split(";",0);
                    for (int i=0;i<c.length;i++){
                        System.out.println(c[i]);
                }
                    //if (string.charAt(i)==(','){
                       // a[0]=string.charAt(index-1);
                        //a[0]=f.parseInt();
                   // }
               // }                
            ask=placeholder(a);
        }while(ask);
        s.close();
        return a;
    }
    public static boolean placeholder(char[] array){

        for (int i=0;i<4l;i++)
            if (array[i]>10||array[0]<0){
                return true;
        }        
        return false;
    }
    public static void main(String[]args){
        char[] inputs = new char[4];
        inputs=inputMethod(inputs);


    }
}
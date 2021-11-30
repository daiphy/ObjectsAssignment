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
                String[] b=string.split(";",2);
                for (int z=0;z<b.length;z++){
                    String[] c=b[z].split(",",3);

                        for (int y=0;y<c.length;y++){
                        
                            if(c[y]!="("||c[y]!=")"){
                                a[x]=c[y].charAt(y);
                            }
                        //System.out.println(c[y]);
                        }
                }
            
//(1,1);(2,2)              
            ask=placeholder(a);
        }while(ask);
        s.close();
        return a;
    }
    public static boolean placeholder(char[] array){
        return false;
    }
}
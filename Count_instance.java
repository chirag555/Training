import  java.io.*;
import java.util.*;
class Count_instance{
    public static Count_instance obj[]=new Count_instance[10];
    public static int counter=0;
    private Count_instance()
     {
        ++counter;
     }
     
    public static Count_instance get()
        {   
            if(counter<=2){
            
                 obj[counter] =new Count_instance();
                System.out.println("Created "+counter+" Instance ");
                         }
            else
                {
            System.out.println("limit reached");
            

                }
                return obj[counter];
                
         }
           
        
}
public class Main
{
	public static void main(String[] args) {
	    
       Count_instance A=Count_instance.get();
	   Count_instance B=Count_instance.get();
	   Count_instance C=Count_instance.get();
	   Count_instance D=Count_instance.get();
	   
	       
	    }
	    
	
}

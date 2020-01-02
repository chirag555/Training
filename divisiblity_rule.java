import java.io.*;
import java.util.*;
class rules{
  StringBuffer output=new StringBuffer("Number is divisible by ");
  void check(int input,int divisor)
    {	int temp=input;
        for(int i=0;temp>0;i++)
        {   if(temp==divisor )
            {System.out.println("\t"+divisor);
             break;            }
            else if(temp<divisor)
            {	break;            }
            else
            {temp=temp-divisor;
            }}}}
public class divisiblity_rule
{public static void main(String[] args)
	{	int input=0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Number");
		try{
    	    input=scanner.nextInt();
    	    rules r=new rules();
			System.out.println("\n"+input+" is divisible by \n");
			for(int divisor=2;divisor<=9;divisor++)
			   {  r.check(input,divisor);
	       	   }
		   }
		catch(Exception e)
		   {      System.out.println("Please Enter a Valid Number");
		   }

	}
}

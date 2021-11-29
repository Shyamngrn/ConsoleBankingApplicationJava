import java.util.Scanner;

class AgeException extends Exception{  
	AgeException(String s){  
    super(s);  
 }  
}  
class AspireSystems{  
	
	static void validate(int age)throws AgeException
	{  
     if(age<18)  
      throw new AgeException("not eligible to vote");  
     else  
      System.out.println("welcome to vote");  
   }  
     		
     public static void main(String args[]){  
    	 
    	 Scanner scanner = new Scanner(System.in);
    	 System.out.println("Enter your age :- ");
		 int votersAge=scanner.nextInt();     
    	 try
    	 {  
		      validate(votersAge);  
		 }
    	 catch(Exception m)
    	 {
    		 System.out.println("Exception occured: "+m);
    	  } 
    	 
   } 
}

package akm.tutorialpoint;

public class LamdaExprGreeter 
{
	public static String GREETING_PREFIX ="Hello ! ";
	public static void main(String[] args) 
	{
	
		GreetingService greetingService= (p) ->System.out.println(GREETING_PREFIX+p) ;
		
		greetingService.greet("Manvindar");
		greetingService.greet("Suresh");
		greetingService.greet("Sagar");
		
	}
	
	interface GreetingService
	{
		
		public void greet(String message);
	}

}

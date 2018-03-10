package akm.tutorialpoint;

public class InjectLambdaInOwnClass 
{

	public static void main(String[] args) 
	{
	
		MyClass myClass= new MyClass(()->
		{for(int i=0 ;i<10;i++)
			{
				System.out.println(i);
			}
		}
		);
		
		myClass.execute();
	}
}

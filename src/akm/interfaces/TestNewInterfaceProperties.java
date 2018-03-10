package akm.interfaces;

public class TestNewInterfaceProperties 
{
	
	@SuppressWarnings("unused")
	public static void main(String[] args) 
	{
		Integer integer= new Integer(100);
		
		SomeClass<String, Integer> someClass= new SomeClass<String, Integer>(integer);
		
	}
	
	public static class SomeClass <T,I>
	{
		I data;
		
		public SomeClass(I data)
		{
			this.data=data;
		}
		
	}
	
	public interface SomeMethod <T,I>
	{
		
		public T transForm(I i);
	}
	
	

}

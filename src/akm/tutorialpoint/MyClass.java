package akm.tutorialpoint;

import java.util.Collection;

public class MyClass
{
	
	MyInterface myInterface;
	
	public MyClass(MyInterface myInterface)
	{
		this.myInterface=myInterface;
	}

	public void execute()
	{
		if(myInterface==null)
			return ;
		myInterface.myMethod();
	}
	
	@SuppressWarnings("unchecked")
	public void printAll(@SuppressWarnings("rawtypes") Collection structure,MyInterface myInterface)
	{
		if(structure==null || myInterface==null)
			return ;
		structure.stream().forEach(p->System.out.println(p));
	}

}

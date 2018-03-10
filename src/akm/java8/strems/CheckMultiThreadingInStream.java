package akm.java8.strems;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class CheckMultiThreadingInStream 
{
	
	public static void main(String[] args) 
	{
		Random random= new Random();
		List<Integer> listIfInts=random.ints()
									   .limit(5)
									   .mapToObj(p-> (p> 0?p:-1*p)%200 )
									   .collect(Collectors.toList());
		System.out.println("No Of Processor in System:="+Runtime.getRuntime().availableProcessors());
		boolean isParallel=true;
		if(isParallel)
		{
			listIfInts.parallelStream()
				      .map(p->p*p)
				      .forEach( p->
						{
							System.out.println(Thread.currentThread().getName()+" Starts");
							System.out.println(Thread.currentThread().getName()+": Value is "+p);
							System.out.println(Thread.currentThread().getName()+" Ends");
						});
		}else
		{
			listIfInts.stream()
				      .map(p->p*p)
				      .forEach( p->
						{
							System.out.println(Thread.currentThread().getName()+" Starts");
							System.out.println(Thread.currentThread().getName()+": Value is "+p);
							System.out.println(Thread.currentThread().getName()+" Ends");
						});
			
		}
	}

}

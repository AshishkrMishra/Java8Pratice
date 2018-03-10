package akm.forkandjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;

public class ForkAndJoinExample
{
	
	public static void main(String[] args) 
	{
		ForkJoinPool forkJoinPool= new ForkJoinPool(5);
		int NO_OF_INPUT=30;
		Random random= new Random();
		List<Integer> listOfRandomInt= random.ints()
											.limit(NO_OF_INPUT)
											.mapToObj(p->{ return (p>0?p:-1*p) %100 ; })
											.collect(Collectors.toList());
		GetDoubleOfListTask getDoubleOfListTask=new GetDoubleOfListTask(listOfRandomInt);
		forkJoinPool.invoke(getDoubleOfListTask);
		List<Integer> listOfResultInt=getDoubleOfListTask.join();
		System.out.printf("INPUT\tOUTPUT(Double)\n");
		System.out.println("############################");
		for(int i=0;i<NO_OF_INPUT;i++)
		{
			System.out.printf("%d\t%d\n",listOfRandomInt.get(i),listOfResultInt.get(i));
		}
		System.out.println("############################");
		System.out.println("Total Double Integers::"+listOfResultInt.size());
		
		
	}
	
	public static  class GetDoubleOfListTask extends RecursiveTask<List<Integer>>
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 13223432342L;
		public static int GET_TASK_SIZE=5;
		List<Integer> listOfInput=null;
		
		public GetDoubleOfListTask(List<Integer> listOfInput)
		{
			this.listOfInput=listOfInput;
		}

		@Override
		protected List<Integer> compute() 
		{
			System.out.printf(" %s Thread  starts \n",Thread.currentThread().getName());
			List<Integer>  result= new ArrayList<Integer>();
			if(listOfInput==null)
			{
				System.out.printf(" %s Thread  ends \n",Thread.currentThread().getName());
				return result;
			}
			if(listOfInput.size()<=GET_TASK_SIZE)
			{
				result.addAll(listOfInput.stream().map(p->p*p).collect(Collectors.toList()));
			}else
			{		
				int size=listOfInput.size();
				int mid=(size-1)/2;
				System.out.printf(" %s : %s \n",Thread.currentThread().getName(),listOfInput.toString());
				List<Integer>  partOne=listOfInput.subList(0,mid);
				List<Integer>  partwo=listOfInput.subList(mid, size);
				GetDoubleOfListTask task1=new GetDoubleOfListTask(partOne);
				GetDoubleOfListTask task2=new GetDoubleOfListTask(partwo);
				task1.fork();
				task2.fork();
				result.addAll(task1.join());
				result.addAll(task2.join());
			}
			System.out.printf(" %s Thread  ends \n",Thread.currentThread().getName());
			return result;
			
		}
		
	}

}

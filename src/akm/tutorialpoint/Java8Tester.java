/**
 * 
 */
package akm.tutorialpoint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author ashishkumarmishra
 *
 */
public class Java8Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		List<String> namesList1= new ArrayList<String>();
		namesList1.add("Smarika");
		namesList1.add("NandKishor");
		namesList1.add("Ashish");
		namesList1.add("khushboo");
		System.out.println("Print List before Sorting namesList1 ....");
		for (String string : namesList1) 
		{
			System.out.println(string);
		}
		
		List<String> namesList2= new ArrayList<String>();
		namesList2.add("Smarika");
		namesList2.add("NandKishor");
		namesList2.add("Ashish");
		namesList2.add("khushboo");
		System.out.println("Print List before Sorting namesList2 ....");
		int  choice=(int)(System.currentTimeMillis()%3);
		System.out.println("I am Choosing Case :="+choice);
		/**
		 * Different Ways of Writing Same Lambda Expression 
		 * Below is java8 way to Print the list 
		 */
		switch (choice) 
		{
		case 0:
			namesList2.stream().forEach(s -> System.out.println(s));
			break;
		case 1:
			namesList2.stream().forEach((s) -> System.out.println(s));
			break;
		case 2:
			namesList2.stream().forEach(s -> {System.out.println(s);});
			break;
		default:
			namesList2.stream().forEach((s) -> {System.out.println(s);});
			break;
		}
		//Lets Sort 
		sortListUsingOldWay(namesList1);
		for (String string : namesList1) 
		{
			System.out.println(string);
		}
		sortListUsingJava8Way(namesList2);
		namesList2.stream().forEach(s -> System.out.println(s));
		
		
		
	}

	/**
	 * Using Java8 Lambda Expression to Sort the List 
	 * @param namesList2
	 */
	private static void sortListUsingJava8Way(List<String> namesList2) 
	{
		if(namesList2==null)
		{
			return ;
		}
		long startTime=System.currentTimeMillis();
		Collections.sort(namesList2,(s1,s2)-> s1.compareTo(s2));
		System.out.println("TImeTaken  by  sortListUsingJava8Way:="+(System.currentTimeMillis()-startTime));
		
	}

	/**
	 * How we use to sort List before java8 
	 * @param namesList1
	 */
	private static void sortListUsingOldWay(List<String> namesList1) 
	{
		if(namesList1==null)
		{
			return ;
		}
		long startTime=System.currentTimeMillis();
		Collections.sort(namesList1,new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
		});
		System.out.println("TImeTaken by sortListUsingOldWay() :="+(System.currentTimeMillis()-startTime));
		
	}

}

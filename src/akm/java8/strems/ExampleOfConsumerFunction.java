package akm.java8.strems;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
/**
 * ExampleOfConsumerFunction :- This Example shows how lazy operation is getting performed on String 
 * It will execute all operation of current element of String and than Move to Next Element 
 * @author Ashish Kr Mishra  
 * @email (er.ashish.kr.mishra@gmail.com)
 */
public class ExampleOfConsumerFunction 
{
	public static void main(String[] args) 
	{
		List<String> string= new ArrayList<String>();
		string.add("Ashish");
		string.add("Kumar");
		string.add("Aamar");
		string.add("Akash");
		string.add("Nitesh");
		string.add("Raman");
		string.add("Suman");
		string.add("Mohan");
		
		Consumer<String> printUpperCase=(c)->System.out.println(c.toUpperCase());
		Consumer<String> printLowerCase=(c)->System.out.println(c.toLowerCase());
		Consumer<String> printReverse=	(c)->{ 
											StringBuilder stringBuilder= new StringBuilder();
											for(int index=c.length()-1;index>=0;index--)
												{
													stringBuilder.append(c.charAt(index));
												}
												System.out.println(stringBuilder.toString());
											};
		
		Consumer< String> chainOfOperations=printLowerCase.andThen(printUpperCase).andThen(printReverse);
		
		string.forEach(chainOfOperations);
		
		
	}
}

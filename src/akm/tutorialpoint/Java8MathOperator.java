package akm.tutorialpoint;

public class Java8MathOperator <E>
{
	
	public static void main(String[] args) 
	{
		Java8MathOperator<Integer> java8MathOperator= new Java8MathOperator<Integer>();
		//with type declaration
	      MathOperation<Integer> addition = (Integer a, Integer b) -> a + b;
			
	      //with out type declaration
	      MathOperation<Integer> subtraction =(Integer a, Integer b) -> a - b;
			
	      //with return statement along with curly braces
	      MathOperation<Integer> multiplication =(Integer a, Integer b) ->{ return  a * b; };
			
	      //without return statement and without curly braces
	      MathOperation<Integer> division = (Integer a, Integer b) -> a / b;
	      
	      System.out.println("Adding :="+java8MathOperator.operate(1, 2, addition));
	      System.out.println("Substraction :="+java8MathOperator.operate(1, 2, subtraction));
	      System.out.println("Multiplication :="+java8MathOperator.operate(1, 2, multiplication));
	      System.out.println("Division :="+java8MathOperator.operate(1, 2, division));
	      
	      
	      Java8MathOperator<Double> mathOperator= new Java8MathOperator<Double>();
			//with type declaration
		      MathOperation<Double> addDouble = (Double a, Double b) -> a + b;
				
		      //with out type declaration
		      MathOperation<Double> subDouble =(Double a, Double b) -> a - b;
				
		      //with return statement along with curly braces
		      MathOperation<Double> mulDouble =(Double a, Double b) ->{ return  a * b; };
				
		      //without return statement and without curly braces
		      MathOperation<Double> divDouble = (Double a, Double b) -> a / b;
		      
		      System.out.println("Adding Double:="+mathOperator.operate(11.00, 22.00, addDouble));
		      System.out.println("Substraction  Double:="+mathOperator.operate(130.0, 12.0, subDouble));
		      System.out.println("Multiplication Double :="+mathOperator.operate(111.0, 2.0, mulDouble));
		      System.out.println("Division  Double :="+mathOperator.operate(1.0, 2.0, divDouble));
		
	}
	
	interface MathOperation<E>
	{
		 E operation(E e1 , E e2);
	} 
	
	
	interface GreetingService<E>
	{
		void sayMessage(E e);
	}
	
	public   E operate(E e1 , E e2 ,MathOperation<E> mathOperator)
	{
		return  mathOperator.operation(e1, e2);
	}

}

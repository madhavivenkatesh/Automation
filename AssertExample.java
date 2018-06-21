package junit;
/*assert is a Java keyword used to define an assert statement. An assert statement is used to declare an expected boolean condition in a program. 
If the program is running with assertions enabled, then the condition is checked at runtime. If the condition is false, 
the Java runtime system throws an AssertionError.Assertions may be declared using the following syntax:
assert expression1 [: expression2];
expression1 is a boolean that will throw the assertion if it is false. When it is thrown, the assertion error exception is created with 
the parameter 
expression2 (if applicable).
assert list != null && list.size() > 0 : "list variable is null or empty";
Object value = list.get(0);
Assertions are usually used as a debugging aid. They should not be used instead of validating arguments to public methods, or in place of a more 
precise runtime error exception. Assertions are enabled with the Java -ea or -enableassertions runtime option. */

import java.util.Scanner;

public class AssertExample {
	
	public static void main(String[] args){
		 int number = Integer.parseInt(args[0]);
	     assert number <= 10; // stops if number > 10
	     System.out.println("Pass");
	     
	     int argCount = args.length;
	     assert argCount == 5 : "The number of arguments must be 5";
	     System.out.println("OK");
		
		Scanner scanInput = new Scanner(System.in);
		System.out.println("Enter integer value less than 100");
		int inputInt = scanInput.nextInt();
		assert inputInt<100:"Not a valid value";
		System.out.println("Value "+inputInt+" is valid");
		
	}

}

 package candystore.jmeter;

import static org.junit.Assert.*;

import org.junit.Test;

public class JUnit_JMeterCalculatorTest
{
	@Test
	public void addTwoNumbers(String test)
	{
		int num1 = 15;
		int num2 = 30;
		int expectedResult = 45;

		assertTrue((num1 + num2) == expectedResult);
	}
	
	@Test
	public void addTwoNumbersFAIL(String test)
	{
		int num1 = 15;
		int num2 = 30;
		int expectedResult = 45;

		assertTrue((num1 + num2) != expectedResult);
	}
}

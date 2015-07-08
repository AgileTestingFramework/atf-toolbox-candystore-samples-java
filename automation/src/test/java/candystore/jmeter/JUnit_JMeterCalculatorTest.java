 package candystore.jmeter;

 import org.junit.Test;

 import static org.junit.Assert.assertTrue;

public class JUnit_JMeterCalculatorTest
{

	@Test
	public void addTwoNumbers()
	{
		int num1 = 15;
		int num2 = 30;
		int expectedResult = 45;

		assertTrue((num1 + num2) == expectedResult);
	}
	
	@Test
	public void addTwoNumbersFAIL()
	{
		int num1 = 15;
		int num2 = 30;
		int expectedResult = 45;

		assertTrue((num1 + num2) != expectedResult);
	}
}

package com.agiletestingframework.candystore.jmeter;

import org.testng.annotations.Test;

import static org.fest.assertions.api.Assertions.assertThat;

// https://docs.wso2.com/display/TA100/Running+a+JMeter+Test+Script+Programmatically

public class TestNG_JMeterCalculatorTest
{
	@Test
	public void addTwoNumbers()
	{
		int num1 = 15;
		int num2 = 30;
		int expectedResult = 45;

		assertThat((num1 + num2)).isEqualTo(expectedResult);
	}
}

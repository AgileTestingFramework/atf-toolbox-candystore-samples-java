package com.agiletestingframework.candystore.datainjection;

import com.agiletestingframework.toolbox.data.ScenarioData;
import com.agiletestingframework.toolbox.data.TestDataProvider;
import com.agiletestingframework.toolbox.data.XMLDataDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * CalculatorTest 1. Use the ATF Toolbox DataProvider 2. Use the ATF Toolbox
 * XMLDataDriver to drive data from xml into the tests
 */
public class CalculatorTest
{

	private static TestDataProvider atfTestDataProvider;
	private static String testDataFilename = "datainjection-calculator-test-data.xml";

	@BeforeClass(alwaysRun = true)
	public static void beforeClassSetup()
	{
		atfTestDataProvider = new TestDataProvider();
	}

	@DataProvider(name = "AddTwoNumbers")
	public static Object[][] additionData()
	{
		String testCaseName = "Test Case: Add 2 Numbers";
		return atfTestDataProvider.initialize(new XMLDataDriver(testDataFilename, testCaseName));
	}

	@DataProvider(name = "MultipleTwoNumbers")
	public static Object[][] multiplicationData()
	{
		String testCaseName = "Test Case: Multiply 2 Numbers";
		return atfTestDataProvider.initialize(new XMLDataDriver(testDataFilename, testCaseName));
	}

	@Test(dataProvider = "AddTwoNumbers", groups = { "datainjection" })
	public void addTwoNumbers(ScenarioData scenario)
	{
		int num1 = scenario.getIntParameterData("firstNumber");
		int num2 = scenario.getIntParameterData("secondNumber");
		int expectedResult = scenario.getIntParameterData("expectedSum");

		assertThat((num1 + num2)).isEqualTo(expectedResult);
	}

	@Test(dataProvider = "MultipleTwoNumbers", groups = { "datainjection" })
	public void multiplyTwoNumbers(ScenarioData scenario)
	{
		int num1 = scenario.getIntParameterData("firstNumber");
		int num2 = scenario.getIntParameterData("secondNumber");
		int expectedResult = scenario.getIntParameterData("expectedProduct");

		assertThat((num1 * num2)).isEqualTo(expectedResult);
	}
}

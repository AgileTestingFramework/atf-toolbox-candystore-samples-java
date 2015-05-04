package candystore.common;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import atf.toolbox.ATFHandler;

public class SuiteInitializer {

	@BeforeSuite(alwaysRun=true)
	public static void BeforeSuiteSetup()
	{
		
	}
	
	@AfterSuite(alwaysRun=true)
	public static void AfterSuiteTeardown()
	{
		ATFHandler.getInstance().teardown();
	}
}

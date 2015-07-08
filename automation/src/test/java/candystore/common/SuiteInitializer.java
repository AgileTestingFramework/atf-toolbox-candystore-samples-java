package candystore.common;

import atf.toolbox.ATFHandler;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

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

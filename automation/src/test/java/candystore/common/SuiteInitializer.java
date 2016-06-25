package candystore.common;

import com.agiletestingframework.toolbox.ATFHandler;
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

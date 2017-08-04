package com.agiletestingframework.automationpractice.website;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.agiletestingframework.automationpractice.website.pageobjects.SignInPage;
import com.agiletestingframework.toolbox.ATFHandler;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(features = "src/test/resources/com/agiletestingframework/automationpractice/features/create-new-account.feature", 
tags = {"@create-account"},
glue= {"com.agiletestingframework.automationpractice.stepdefinitions"})
public class CreateNewAccountCucumberTest {
    private TestNGCucumberRunner testNGCucumberRunner;
    private SignInPage signInPage;
    
    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
//		signInPage = (SignInPage)AutomationPracticePageFactory.getInstance(AutomationPracticePageFactory.SIGNIN);
//		signInPage.load();
    }
    
    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }

    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }
    
	@AfterClass(alwaysRun = true)
	public void ClassTeardown() {
		ATFHandler.getInstance().teardown();
		testNGCucumberRunner.finish();
	}
    

}

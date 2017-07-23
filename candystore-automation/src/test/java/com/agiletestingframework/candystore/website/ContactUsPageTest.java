package com.agiletestingframework.candystore.website;

import com.agiletestingframework.toolbox.ATFHandler;
import com.agiletestingframework.toolbox.managers.ConfigurationManager;

import com.agiletestingframework.candystore.website.CandyStorePageFactory;
import com.agiletestingframework.candystore.website.pageobjects.ContactUsPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

public class ContactUsPageTest {

	public ContactUsPage contactUsPage;
	
	@BeforeMethod(alwaysRun=true)
	public void BeforeMethodSetup()
	{
		contactUsPage = (ContactUsPage)CandyStorePageFactory.getInstance(CandyStorePageFactory.CONTACTUS);
		contactUsPage.load();
	}

	@AfterMethod(alwaysRun=true)
	public void takeScreenShotOnFailure(ITestResult testResult, Method method) throws IOException { 
		if (testResult.getStatus() == ITestResult.FAILURE) { 
			File scrFile = ((TakesScreenshot)ATFHandler.getInstance().getWebAutomation().getWebDriver()).getScreenshotAs(OutputType.FILE); 
			FileUtils.copyFile(scrFile, new File(ConfigurationManager.getInstance().getTakesScreenshotSaveLocation()+"\\"+method.getName()+".jpg")); 
		}		
	}
	
	@AfterClass
	public void ClassTeardown() {
		ATFHandler.getInstance().teardown();
	}
	
    /**
     * Validate the expected logo for Candy Store is displayed
     */
    @Test(groups = { "smoke" } )
    public void contactUsFormIsDisplayed() {
        assertThat(contactUsPage.contactUsFormIsDisplayed()).isTrue();
    }
    
    /**
     * the max char this textbox should accept is 25
     */
    @Test
    public void validateFirstNameAcceptsNoMoreThanMaxChar() {
        String tooLongName = "AbcdefgHijklmnoPqrstuvWxyz";
        String expectedFirstName = "AbcdefgHijklmnoPqrstuvWxy";

        contactUsPage.enterFirstName(tooLongName);

        assertThat(contactUsPage.getFirstNameValue().length()).isEqualTo(25);
        assertThat(contactUsPage.getFirstNameValue()).isEqualTo(expectedFirstName);
    }
    
    /**
     * THIS TEST CASE SHOULD FAIL AND TAKE A SCREENSHOT
     */
    @Test
    public void validateFirstNameAcceptsNoMoreThanMaxCharFAIL() {
        String tooLongName = "AbcdefgHijklmnoPqrstuvWxyz";
        String expectedFirstName = "AbcdefgHijklmnoPqrstuv";

        contactUsPage.enterFirstName(tooLongName);

        assertThat(contactUsPage.getFirstNameValue()).isEqualTo(expectedFirstName);
    }
    
}

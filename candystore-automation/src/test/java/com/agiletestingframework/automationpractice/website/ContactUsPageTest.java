package com.agiletestingframework.automationpractice.website;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.agiletestingframework.automationpractice.website.pageobjects.ContactUsPage;
import com.agiletestingframework.toolbox.ATFHandler;
import com.agiletestingframework.toolbox.managers.ConfigurationManager;

public class ContactUsPageTest {

	public ContactUsPage contactUsPage;
	
	@BeforeMethod(alwaysRun=true)
	public void BeforeMethodSetup()
	{
		contactUsPage = (ContactUsPage)AutomationPracticePageFactory.getInstance(AutomationPracticePageFactory.CONTACTUS);
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
     * Validate the form for the ContactUs page is displayed
     */
    @Test(groups = { "smoke" } )
    public void contactUsFormIsDisplayed() {
        assertThat(contactUsPage.contactUsFormIsDisplayed()).isTrue();
    }
    
    @Test
    public void enterValidEmail(){
    	String email = "email@email.com";
    	
    	contactUsPage.enterEmail(email);
    	contactUsPage.removeFocus();
    	assertThat(contactUsPage.checkIfValidEmail()).isTrue();
    	
    }
    
    @Test
    public void enterInvalidEmail(){
    	String email = "emailemail.com";
    	
    	contactUsPage.enterEmail(email);
    	contactUsPage.removeFocus();
    	assertThat(contactUsPage.checkIfValidEmail()).isFalse();
    	
    }
}

package com.agiletestingframework.automationpractice.website.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.LoadableComponent;

import com.agiletestingframework.automationpractice.website.AutomationPracticePageFactory;
import com.agiletestingframework.toolbox.ATFHandler;

public class ContactUsPage  extends LoadableComponent<ContactUsPage>{
	private WebDriver wd;

	@FindBy(id = "id_contact")
	WebElement subjectHeadingDrpDwn;
	
	@FindBy(css = ".contact-form-box")
	WebElement frmContactUs;
	
	@FindBy(css = "#email")
	private WebElement emailTxtFld;
	
	@FindBy(id = "submitMessage")
	private WebElement submitMessage;
	
	@FindBy(css = "p.form-group.form-ok")
	private WebElement emailValidation;

	@Override
	public void load(){
		((IndexPage)AutomationPracticePageFactory.getInstance(AutomationPracticePageFactory.INDEX)).load();
		((IndexPage)AutomationPracticePageFactory.getInstance(AutomationPracticePageFactory.INDEX)).clickContactUsLink();
		isLoaded();
		wd = ATFHandler.getInstance().getWebAutomation().getWebDriver();
	}
	
	@Override
	protected void isLoaded() throws Error{
		
	}
	
	public boolean contactUsFormIsDisplayed()
	{
		boolean success = true;
		
		isLoaded();
		success = frmContactUs.isDisplayed();
		return success;
	}
	
	public void clickSubmitMessage()
	{
		submitMessage.click();
	}
	
	public void selectSubjectHeader(String option)
	{
		//TODO
	}
	
	public void enterEmail(String text)
	{
		emailTxtFld.click();
		emailTxtFld.sendKeys(text);
	}
	
	public void removeFocus()
	{
		frmContactUs.click();
	}
	
	public String getEmailValue()
	{
		return emailTxtFld.getAttribute("value").toString();
	}
	
	public boolean checkIfValidEmail(){
		boolean valid = false;
		if(wd.findElements(By.cssSelector("p.form-group.form-ok")).size() > 0 )
		{
			valid = true;
		}
		
		return valid;
	}
	
	
}

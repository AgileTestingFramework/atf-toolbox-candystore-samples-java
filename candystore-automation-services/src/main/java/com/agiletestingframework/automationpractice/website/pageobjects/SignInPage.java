package com.agiletestingframework.automationpractice.website.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.LoadableComponent;

import com.agiletestingframework.automationpractice.website.AutomationPracticePageFactory;

public class SignInPage extends LoadableComponent<SignInPage>{
	
	@FindBy(name="SubmitCreate")
	private WebElement createAnAccountBtn;
	
	@FindBy(id="email_create")
	private WebElement emailField;
	
	
	@Override
	public void load(){
		((IndexPage)AutomationPracticePageFactory.getInstance(AutomationPracticePageFactory.INDEX)).load();
		((IndexPage)AutomationPracticePageFactory.getInstance(AutomationPracticePageFactory.INDEX)).clickSignInLink();
		isLoaded();
	}
	
	@Override
	protected void isLoaded() throws Error {
		
	}
	
	public boolean createAnAccountBtnIsDisplayed()
	{
		boolean success = false;
		isLoaded();
		success = createAnAccountBtn.isDisplayed();
		return success;
	}
	
	public void clickCreateAnAccount()
	{
		createAnAccountBtn.click();
	}
	
	public void enterEmailAddress(String email){
		emailField.click();
		emailField.sendKeys(email);
	}

}

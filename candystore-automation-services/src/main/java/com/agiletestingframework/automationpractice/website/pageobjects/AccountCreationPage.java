package com.agiletestingframework.automationpractice.website.pageobjects;

import org.apache.poi.util.StringUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.agiletestingframework.automationpractice.website.AutomationPracticePageFactory;
import com.agiletestingframework.toolbox.ATFHandler;
import com.agiletestingframework.toolbox.managers.ConfigurationManager;

public class AccountCreationPage extends LoadableComponent<AccountCreationPage>{
	
	@FindBy(css=".account_creation")
	private WebElement accountCreationFrm;
	
	@FindBy(id="customer_firstname")
	private WebElement firstNameField;
	
	@Override
	public void load(){
//		String creationUrl = String.format("%s%s", ConfigurationManager.getInstance().getWebBaseUrl(), "?controller=authentication&back=my-account#account-creation");
//		ATFHandler.getInstance().getWebAutomation().getWebDriver().get(creationUrl);
		isLoaded();
	}
	
	@Override
	protected void isLoaded() throws Error{
		WebDriverWait wait = new WebDriverWait(ATFHandler.getInstance().getWebAutomation().getWebDriver(), 10);
		wait.until(ExpectedConditions.visibilityOf(accountCreationFrm));
	}
	
	public boolean firstNameFieldIsDisplayed()
	{
		boolean success = false;
		isLoaded();
		success = firstNameField.isDisplayed();
		return success;
	}

}

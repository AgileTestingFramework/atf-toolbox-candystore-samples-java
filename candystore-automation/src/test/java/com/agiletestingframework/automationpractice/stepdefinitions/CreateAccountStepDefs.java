package com.agiletestingframework.automationpractice.stepdefinitions;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agiletestingframework.automationpractice.website.AutomationPracticePageFactory;
import com.agiletestingframework.automationpractice.website.pageobjects.AccountCreationPage;
import com.agiletestingframework.automationpractice.website.pageobjects.IndexPage;
import com.agiletestingframework.automationpractice.website.pageobjects.SignInPage;
import com.agiletestingframework.toolbox.ATFHandler;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java8.En;

public class CreateAccountStepDefs implements En {
	private WebDriver webdriver = ATFHandler.getInstance().getWebAutomation().getWebDriver();
	private Scenario scenario;
	private AccountCreationPage accountCreation;
	private SignInPage signInPage;
	private IndexPage index;

    public CreateAccountStepDefs() {
		super();
		
		index = (IndexPage)AutomationPracticePageFactory.getInstance(AutomationPracticePageFactory.INDEX);
		signInPage = (SignInPage)AutomationPracticePageFactory.getInstance(AutomationPracticePageFactory.SIGNIN);
		accountCreation = (AccountCreationPage)AutomationPracticePageFactory.getInstance(AutomationPracticePageFactory.ACCOUNTCREATION);
		
		Given("^I navigate to \"([^\"]*)\"$", (String link) -> {
			webdriver.get(link);
		});

		And("^I click the \"([^\"]*)\" link$", (String element) -> {
			index.clickSignInLink();
		});

		Then("^I should see the \"([^\"]*)\" button$", (String element) -> {
			WebElement el = webdriver.findElement(By.name(element));
			assertThat(el.isDisplayed()).isTrue();
		});
		
		Given("^I enter \"(.*?)\" address into the email field$", (String email) -> {
			signInPage.enterEmailAddress(email);
		});
		
		And("^I click the \"([^\"]*)\" button$", (String element) -> {
			signInPage.clickCreateAnAccount();
			accountCreation.load();
		});
		
		Then("^I should be able to create a new account$", () -> {
				assertThat(accountCreation.firstNameFieldIsDisplayed()).isTrue();
		});
		
	}

	@Before
    public void beforescenario(Scenario scenario){
        this.scenario = scenario;
    }
    
}

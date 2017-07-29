package com.agiletestingframework.automationpractice.stepDefinitions;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agiletestingframework.toolbox.ATFHandler;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java8.En;

public class CreateAccountStepDefs implements En {
	private WebDriver webdriver = ATFHandler.getInstance().getWebAutomation().getWebDriver();
	private Scenario scenario;

    @Before
    public void beforescenario(Scenario scenario){
        this.scenario = scenario;
    }
    
	public void navigate_to()
	{
		Given("^I navigate to \"([^\"]*)\"$", (String link) -> {
			webdriver.get(link);
		});
		
	}
	
	public void click()
	{
		And("^I click \"([^\"]*)\"$", (WebElement element) -> {
			element.click();
		});
	}
	
	public void isDisplayed()
	{
		Then("^I should see \"([^\"]*)\"$", (WebElement element) -> {
			assertThat(element.isDisplayed()).isTrue();
		});
	}
}

package com.agiletestingframework.automationpractice.website.pageobjects;

import com.agiletestingframework.toolbox.ATFHandler;
import com.agiletestingframework.toolbox.managers.ConfigurationManager;
import org.assertj.core.api.Fail;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.LoadableComponent;

import java.util.ArrayList;
import java.util.List;

public class IndexPage extends LoadableComponent<IndexPage>{
	
	@FindBy(id = "search_query_top")
	private WebElement searchField;
	
	@FindBy(name = "submit_search")
	private WebElement sumbitSearch;
	
	@FindBy(className = "img-responsive")
	private WebElement topSaleImage;
	
	@FindBy(linkText = "ContactUs")
	private WebElement contactUsLink;
	
	@FindBy(css = "#block_top_menu > ul > li:nth-child:contains('Women')")
	private WebElement womenTab;
	
	@FindBy(xpath = "//*[@id='header_logo']/a/img")
	private WebElement yourLogo;
	
	@Override
	public void load(){
		ATFHandler.getInstance().getWebAutomation().getWebDriver().get(ConfigurationManager.getInstance().getWebBaseUrl());
		isLoaded();
	}
	
	@Override
	protected void isLoaded() throws Error {
		
	}

	/**
	 * logoIsDisplayed
	 * @return TRUE if the logo is displayed, FALSE if the logo is not displayed
	 */
	public boolean logoIsDisplayed(){
		try { return yourLogo.isDisplayed(); }
		catch (StaleElementReferenceException | NoSuchElementException ex)
		{
			Fail.fail("IndexPage.Logo", ex);
		}
		return false;
	}
}

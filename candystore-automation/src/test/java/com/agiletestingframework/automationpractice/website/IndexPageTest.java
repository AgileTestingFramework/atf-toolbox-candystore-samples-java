package com.agiletestingframework.automationpractice.website;

import com.agiletestingframework.automationpractice.website.AutomationPracticePageFactory;
import com.agiletestingframework.automationpractice.website.pageobjects.IndexPage;
import com.agiletestingframework.toolbox.ATFHandler;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IndexPageTest {

	public IndexPage indexPage;
	
	@BeforeMethod(alwaysRun=true)
	public void BeforeMethodSetup()
	{
		indexPage = (IndexPage)AutomationPracticePageFactory.getInstance(AutomationPracticePageFactory.INDEX);
		indexPage.load();
	}
	
	@AfterClass
	public void ClassTeardown() {
		ATFHandler.getInstance().teardown();
	}
	
	/**
	 * Validate the expected image appears on the page
	 */
	@Test(groups = { "smoke" })
	public void topSaleImageIsDisplayed(){
		assertThat(indexPage.topSaleImageIsDisplayed()).isTrue();
	}
	
	@Test
	public void contactUsLinkIsDsiplayed(){
		assertThat(indexPage.contactUsLinkIsDisplayed()).isTrue();
	}
}

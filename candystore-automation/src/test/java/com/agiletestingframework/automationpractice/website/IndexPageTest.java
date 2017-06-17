package com.agiletestingframework.automationpractice.website;

import com.agiletestingframework.automationpractice.website.AutomationPracticePageFactory;
import com.agiletestingframework.automationpractice.website.pageobjects.IndexPage;
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
	
	
}

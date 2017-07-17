package com.agiletestingframework.automationpractice.website.pageobjects;

import org.openqa.selenium.support.ui.LoadableComponent;

import com.agiletestingframework.automationpractice.website.AutomationPracticePageFactory;
import com.agiletestingframework.toolbox.ATFHandler;
import com.agiletestingframework.toolbox.managers.ConfigurationManager;

public class ContactUsPage  extends LoadableComponent<ContactUsPage>{

	@Override
	public void load(){
		//((IndexPage)(AutomationPracticePageFactory.getInstance(AutomationPracticePageFactory.INDEX)).load();
		//((IndexPage)(AutomationPracticePageFactory.getInstance(AutomationPracticePageFactory.INDEX)).clickContactUsLink();
		isLoaded();
	}
	
	@Override
	protected void isLoaded() throws Error{
		
	}
}

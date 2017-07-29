package com.agiletestingframework.automationpractice.website.pageobjects;

import org.openqa.selenium.support.ui.LoadableComponent;

import com.agiletestingframework.automationpractice.website.AutomationPracticePageFactory;

public class SignInPage extends LoadableComponent<SignInPage>{
	
	@Override
	public void load(){
		((IndexPage)AutomationPracticePageFactory.getInstance(AutomationPracticePageFactory.INDEX)).load();
		((IndexPage)AutomationPracticePageFactory.getInstance(AutomationPracticePageFactory.INDEX)).clickSignInLink();
		isLoaded();
	}
	
	@Override
	protected void isLoaded() throws Error {
		
	}

}

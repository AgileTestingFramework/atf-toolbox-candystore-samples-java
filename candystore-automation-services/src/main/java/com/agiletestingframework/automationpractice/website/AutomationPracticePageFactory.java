package com.agiletestingframework.automationpractice.website;

import java.util.HashMap;
import java.util.Map;

import com.agiletestingframework.automationpractice.website.pageobjects.ContactUsPage;
import com.agiletestingframework.automationpractice.website.pageobjects.IndexPage;
import com.agiletestingframework.automationpractice.website.pageobjects.SignInPage;
import com.agiletestingframework.toolbox.ATFHandler;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

@SuppressWarnings("rawtypes")
public class AutomationPracticePageFactory {
	private static final Map<String, LoadableComponent> instances = new HashMap<String, LoadableComponent>();

    /** Create all page object constants here for easy access **/
	public static final String INDEX = "index";
	public static final String CONTACTUS = "contactUs";
	public static final String SIGNIN = "signIn";
	
	private AutomationPracticePageFactory(){}
	
	public static synchronized LoadableComponent getInstance(String pageObjectType){
		
        // Our "per key" singleton
        LoadableComponent instance = instances.get(pageObjectType);
        
        if (instance == null) {
            // Lazily create instance
			switch (pageObjectType){
			case INDEX:
				instance = new IndexPage();
				break;
			case CONTACTUS:
				instance = new ContactUsPage();
				break;
			case SIGNIN:
				instance = new SignInPage();
				break;
			default:
				instance = new IndexPage();
				break;
			}

			// Add it to map
            instances.put(pageObjectType, instance);
        }
        
		// Initialize the page object elements
        PageFactory.initElements(ATFHandler.getInstance().getWebAutomation().getWebDriver(), instance);

        return instance;
	}
}

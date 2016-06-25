package candystore.website.pageobjects;

import candystore.website.CandyStorePageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.LoadableComponent;

public class ContactUsPage extends LoadableComponent<ContactUsPage>{

	WebElement firstName;
	WebElement frmContactUs;
	
	@Override
	public void load() {
		// Nested Page Navigation, load the parent
		((IndexPage)CandyStorePageFactory.getInstance(CandyStorePageFactory.INDEX)).load();
		((IndexPage)CandyStorePageFactory.getInstance(CandyStorePageFactory.INDEX)).clickContactUsLink();
		isLoaded();		
	}

	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub
		
	}

	/**
	 * contactUsPageIsDisplayed
	 * @return TRUE if the contactUsPage form is displayed, FALSE if contactUsPage form is not displayed
	 */
	public boolean contactUsFormIsDisplayed()
	{
		boolean success = true;
		
		isLoaded();
		success = frmContactUs.isDisplayed();
		return success;
	}
	
	public void enterFirstName(String nameToEnter)
	{
		firstName.click();
		firstName.sendKeys(nameToEnter);
	}
	
	public String getFirstNameValue()
	{
		return firstName.getAttribute("value").toString();
	}
	
}

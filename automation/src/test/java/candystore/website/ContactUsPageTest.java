package candystore.website;

import static org.fest.assertions.api.Assertions.assertThat;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import candystore.website.pageobjects.*;

public class ContactUsPageTest {

	public ContactUsPage contactUsPage;
	
	@BeforeMethod(alwaysRun=true)
	public void BeforeMethodSetup()
	{
		contactUsPage = (ContactUsPage)CandyStorePageFactory.getInstance(CandyStorePageFactory.CONTACTUS);
		contactUsPage.load();
	}

    /**
     * Validate the expected logo for Candy Store is displayed
     */
    @Test(groups = { "smoke" } )
    public void contactUsFormIsDisplayed() {
        assertThat(contactUsPage.contactUsFormIsDisplayed()).isTrue();
    }
    
    /**
     * the max char this textbox should accept is 25
     */
    @Test
    public void validateFirstNameAcceptsNoMoreThanMaxChar() {
        String tooLongName = "AbcdefgHijklmnoPqrstuvWxyz";
        String expectedFirstName = "AbcdefgHijklmnoPqrstuvWxy";

        contactUsPage.enterFirstName(tooLongName);

        assertThat(contactUsPage.getFirstNameValue().length()).isEqualTo(25);
        assertThat(contactUsPage.getFirstNameValue()).isEqualTo(expectedFirstName);
    }
    
    
}

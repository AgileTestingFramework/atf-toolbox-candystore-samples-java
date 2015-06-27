package candystore.jmeter;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import candystore.website.CandyStorePageFactory;
import candystore.website.pageobjects.ContactUsPage;

public class JUnit_JMeter_ContactUsTest
{
	public ContactUsPage contactUsPage;
	
	@Before()
	public void BeforeMethodSetup()
	{
		contactUsPage = (ContactUsPage)CandyStorePageFactory.getInstance(CandyStorePageFactory.CONTACTUS);
		contactUsPage.load();
	}
	
	@Test
    public void validateFirstNameAcceptsNoMoreThanMaxChar(String test) {
        String tooLongName = "AbcdefgHijklmnoPqrstuvWxyz";
        String expectedFirstName = "AbcdefgHijklmnoPqrstuvWxy";

        contactUsPage.enterFirstName(tooLongName);

        assertThat(contactUsPage.getFirstNameValue().length()).isEqualTo(25);
        assertThat(contactUsPage.getFirstNameValue()).isEqualTo(expectedFirstName);
    }
}

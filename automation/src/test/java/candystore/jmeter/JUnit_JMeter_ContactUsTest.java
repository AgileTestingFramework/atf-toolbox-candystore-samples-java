package candystore.jmeter;

import atf.toolbox.ATFHandler;
import candystore.website.CandyStorePageFactory;
import candystore.website.pageobjects.ContactUsPage;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class JUnit_JMeter_ContactUsTest
{
	public ContactUsPage contactUsPage;

	@Before()
	public void beforeMethodSetup()
	{
		contactUsPage = (ContactUsPage)CandyStorePageFactory.getInstance(CandyStorePageFactory.CONTACTUS);
		contactUsPage.load();
	}

	@AfterClass
	public static void afterClassSetup()
	{
		ATFHandler.getInstance().teardown();
	}

	@Test
    public void validateFirstNameAcceptsNoMoreThanMaxChar() {
        String tooLongName = "AbcdefgHijklmnoPqrstuvWxyz";
        String expectedFirstName = "AbcdefgHijklmnoPqrstuvWxy";

        contactUsPage.enterFirstName(tooLongName);

        assertThat(contactUsPage.getFirstNameValue().length()).isEqualTo(25);
        assertThat(contactUsPage.getFirstNameValue()).isEqualTo(expectedFirstName);
    }
}

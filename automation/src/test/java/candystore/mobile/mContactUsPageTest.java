package candystore.mobile;

import static org.fest.assertions.api.Assertions.assertThat;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class mContactUsPageTest {

public mContactUsPage contactUsPage;
	
	@BeforeMethod(alwaysRun=true)
	public void BeforeMethodSetup()
	{
		contactUsPage = new mContactUsPage();
		contactUsPage.load();
	}
    
    /**
     * the max char this textbox should accept is 25
     */
    @Test(groups = { "android" })
    public void validateFirstNameAcceptsNoMoreThanMaxChar() {
        String tooLongName = "AbcdefgHijklmnoPqrstuvWxyz";
        String expectedFirstName = "AbcdefgHijklmnoPqrstuvWxy";

        contactUsPage.enterFirstName(tooLongName);

        assertThat(contactUsPage.getFirstNameValue().length()).isEqualTo(25);
        assertThat(contactUsPage.getFirstNameValue()).isEqualTo(expectedFirstName);
    }
    
    @Test(groups = { "ios" })
    public void validateFirstNameAcceptChar() {
        String expectedFirstName = "AbcdefgHijklmnoPqrstuvWxy";
        String expectedLastName = "ReallyCoolLastName";

        contactUsPage.enterFirstName(expectedFirstName);
        contactUsPage.enterLastName(expectedLastName);

        assertThat(contactUsPage.getFirstNameValue()).isEqualTo(expectedFirstName);
        assertThat(contactUsPage.getLastNameValue()).isEqualTo(expectedLastName);
    }
}

package candystore.mobile;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class mContactUsPageTest {

public mContactUsPage contactUsPage;
	
	@BeforeMethod(alwaysRun=true)
	public void BeforeMethodSetup()
	{
		contactUsPage = new mContactUsPage();
		contactUsPage.load();
	}
    
	/**
	 * "C:\Program Files (x86)\appium\Android\android-sdk\platform-tools\adb.exe" devices
	 * 
	 * Hardware device setup
	 * To make it visible, go to Settings > About phone and tap Build number seven times. 
	 * Return to the previous screen to find Developer options at the bottom.
	 */
	
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

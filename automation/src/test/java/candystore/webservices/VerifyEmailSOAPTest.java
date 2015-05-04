package candystore.webservices;

import static org.fest.assertions.api.Assertions.assertThat;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VerifyEmailSOAPTest {
	public VerifyEmailSOAPService verifyEmailService;
	
	@BeforeClass(alwaysRun=true)
	public void BeforeGroupsSetup()
	{
		verifyEmailService = new VerifyEmailSOAPService();
	}
	@AfterClass(alwaysRun=true)
	public void AfterGroupsTeardown()
	{
		verifyEmailService.teardown();
	}

    /**
     * Validate the expected logo for Candy Store is displayed
     */
    @Test(groups = { "soap" } )
    public void shouldEmailForLicenseBeNotFound() {
    	String emailToVerify = "test@test.com";
    	String licenseKey = "123";
    	
    	String expectedBody = "<VerifyEmailResult><ResponseText>User Not Found</ResponseText><ResponseCode>4</ResponseCode><LastMailServer>mx.spamexperts.com</LastMailServer><GoodEmail>false</GoodEmail></VerifyEmailResult>";
    	
    	String response = verifyEmailService.verifyEmail(emailToVerify, licenseKey);
    	
    	assertThat(response).isNotNull();
    	assertThat(response).containsIgnoringCase(expectedBody);
    }
    
}

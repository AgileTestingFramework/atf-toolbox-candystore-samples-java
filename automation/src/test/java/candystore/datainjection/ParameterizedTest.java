package candystore.datainjection;

import static org.fest.assertions.api.Assertions.assertThat;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterizedTest {

    /**
     * Validate the global Zip Code is overridden
     * Validate the zipCode is as expected
     * Validate that the global string comes in from the master suite
     */
    @Parameters({ "globalZipCode", "zipCode", "global"})
    @Test(groups = { "datainjection" } )
    public void shouldZipCodeParameterTest(int gloablZipCode, int zipCode, String global) {   	
    	assertThat(gloablZipCode).isEqualTo(55555);
    	assertThat(zipCode).isEqualTo(85260);
    	assertThat(global).isEqualToIgnoringCase("This is a global value");
    }
}

package candystore.webservices;

import static org.fest.assertions.api.Assertions.assertThat;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import candystore.webservices.schemas.com.cdyne.ws.weatherws.ForecastReturn;

/**
 * Weather SOAP Service
 * http://wsf.cdyne.com/WeatherWS/Weather.asmx
 *
 */
public class WeatherSOAPTest {

	public WeatherSOAPService weatherService;
	
	@BeforeClass(alwaysRun=true)
	public void BeforeGroupsSetup()
	{
		weatherService = new WeatherSOAPService();
	}

    /**
     * Validate the expected city is returned for the zip code provided
     */
    @Test(groups = { "soap" } )
    public void shouldCityForecastByZipBeScottsdale() {
    	String zipCode = "85260";
    	
    	ForecastReturn response = weatherService.getForecastByZIP(zipCode);
    	
    	assertThat(response).isNotNull();
    	assertThat(response.getCity()).isEqualToIgnoringCase("Scottsdale");
    }
}

package com.agiletestingframework.candystore.webservices;

import com.jayway.restassured.path.xml.XmlPath;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;


/**
 * WeatherRESTTest
 * import the static packages below to use all of the fluent REST syntax
 * import static com.jayway.restassured.RestAssured.*;
 * import static com.jayway.restassured.matcher.RestAssuredMatchers.*;
 * import static org.hamcrest.Matchers.*;
 * 
 * http://wsf.cdyne.com/WeatherWS/Weather.asmx?op=GetCityForecastByZIP
 */
public class WeatherRESTTest {

	public URL getCityForecastByZIP;
	public URL getCityForecastByZIP2;
	public URL getCityByPostalCode;
	
	@BeforeClass(alwaysRun=true)
	public void BeforeClassSetup() throws MalformedURLException, URISyntaxException
	{
		// Recommended that you load this from configuration or use a datadriver
		getCityForecastByZIP = new URL("http://wsf.cdyne.com/WeatherWS/Weather.asmx/GetCityForecastByZIP?ZIP=85260");
		getCityForecastByZIP2 = new URL("http://wsf.cdyne.com/WeatherWS/Weather.asmx/GetCityForecastByZIP");
		getCityByPostalCode = new URL("http://api.geonames.org/postalCodeLookupJSON");
	}
	
	@Test(groups="rest")
	public void shouldCityForecastByZipBeScottsdale() {
		// HTTP GET Example
		String expectedState = "AZ";
		String expectedCity = "Scottsdale";
		
		String response = get(getCityForecastByZIP).asString();
		
		assertThat(XmlPath.from(response).get("ForecastReturn.City").toString()).isEqualTo(expectedCity);
		assertThat(XmlPath.from(response).get("ForecastReturn.State").toString()).isEqualTo(expectedState);
	}
	
	@Test(groups="rest")
	public void shouldCityForecastByZipBeScottsdale2() {
		// HTTP POST Example using a more fluent assertion
		String expectedState = "AZ";
		String expectedCity = "Scottsdale";
		String zipcode = "85260";
		
		given().parameters("ZIP", zipcode).
			when().post(getCityForecastByZIP2).
			then().body("ForecastReturn.City", equalTo(expectedCity)).
			and().body("ForecastReturn.State", equalTo(expectedState));
	}
}

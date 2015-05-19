package candystore.webservices;

import static org.fest.assertions.api.Assertions.assertThat;
import static com.jayway.restassured.RestAssured.*;
import static com.jayway.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jayway.restassured.path.xml.XmlPath;
import com.jayway.restassured.response.Response;


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
	public URL orderCandyURL;
	public URL getOrderCandyURL;
	
	@BeforeClass(alwaysRun=true)
	public void BeforeClassSetup() throws MalformedURLException, URISyntaxException
	{
		// Recommended that you load this from configuration or use a datadriver
		getCityForecastByZIP = new URL("http://wsf.cdyne.com/WeatherWS/Weather.asmx/GetCityForecastByZIP?ZIP=85260");
		getCityForecastByZIP2 = new URL("http://wsf.cdyne.com/WeatherWS/Weather.asmx/GetCityForecastByZIP");
		getCityByPostalCode = new URL("http://api.geonames.org/postalCodeLookupJSON");
		
		orderCandyURL = new URL("http://192.168.1.111:8080/CandyStore-0.0.3/candyorderREST/orderCandy");
		getOrderCandyURL = new URL("http://192.168.1.111:8080/CandyStore-0.0.3/candyorderREST/getOrder");
	}
	
	@Test
	public void shouldCityForecastByZipBeScottsdale() {
		// HTTP GET Example
		String expectedState = "AZ";
		String expectedCity = "Scottsdale";
		
		String response = get(getCityForecastByZIP).asString();
		XmlPath path = new XmlPath(response).setRoot("ForecastResult");
		
		assertThat(path.from(response).get("ForecastReturn.City").toString()).isEqualTo(expectedCity);
		assertThat(path.from(response).get("ForecastReturn.State").toString()).isEqualTo(expectedState);
	}
	
	@Test
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
	
	@Test
	public void shouldOrderCandy() {
		// JSON POST Example
		float expectedOrderTotal = 1.8f;
		int expectedSuccessCode = 200;
		Object[] expectedCandyNames = new String[] {"Twix", "Milky Way"};
		String unexpectedCandyNames = "Sour";
		
		OrderCandyJSONService jSONService = new OrderCandyJSONService();
		
		Map<String, Integer> orderLines = new HashMap<String, Integer>();
		orderLines.put("000000001", 1);
		orderLines.put("000000002", 2);
		
		String request = jSONService.buildOrderCandyRequest(orderLines);
		
		Response response = given().body(request).when().post(orderCandyURL).thenReturn();
		assertThat(response.getStatusCode()).isEqualTo(expectedSuccessCode);
		assertThat(response.jsonPath().getFloat("orderTotal")).isEqualTo(expectedOrderTotal);
		assertThat(response.jsonPath().getList("orderLines.candy.candyName")).contains(expectedCandyNames).doesNotContain(unexpectedCandyNames);
	}
	
	@Test
	public void shouldGetOrder() throws MalformedURLException {
		// JSON GET Example
		int expectedSuccessCode = 200;
		int orderId = 167;
		float expectedOrderTotal = 1.8f;
		
		URL extendedGetORderCandyURL = new URL(getOrderCandyURL.toString()+"/"+orderId);
		
		Response response = get(extendedGetORderCandyURL).thenReturn();
		
		assertThat(response.getStatusCode()).isEqualTo(expectedSuccessCode);
		assertThat(response.jsonPath().getFloat("orderTotal")).isEqualTo(expectedOrderTotal);
	}
}

package candystore.webservices;

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;
import static org.fest.assertions.api.Assertions.assertThat;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;

public class CandyOrderRESTTest {

	public URL orderCandyURL;
	public URL getOrderCandyURL;
	
	@BeforeClass(alwaysRun=true)
	public void BeforeClassSetup() throws MalformedURLException, URISyntaxException
	{
		orderCandyURL = new URL("http://54.173.199.137:8080/CandyStore-0.0.3/candyorderREST/orderCandy");
		getOrderCandyURL = new URL("http://54.173.199.137:8080/CandyStore-0.0.3/candyorderREST/getOrder");
	}
	
	@Test(groups="rest")
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
	
	@Test(groups="rest")
	public void shouldGetOrder() throws MalformedURLException {
		// JSON GET Example
		int expectedSuccessCode = 200;
		int orderId = 1;
		float expectedOrderTotal = 1.8f;
		
		URL extendedGetORderCandyURL = new URL(getOrderCandyURL.toString()+"/"+orderId);
		
		Response response = get(extendedGetORderCandyURL).thenReturn();
		
		assertThat(response.getStatusCode()).isEqualTo(expectedSuccessCode);
		assertThat(response.jsonPath().getFloat("orderTotal")).isEqualTo(expectedOrderTotal);
	}
}

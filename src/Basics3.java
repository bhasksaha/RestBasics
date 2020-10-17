import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Basics3 {

	// String a;
	// https://192.168.104.17/VP_POM_Service/v2/contactlists/62/contacts/list
	@Test
	public void getRequest() {
		RestAssured.baseURI = "https://192.168.104.19:7443";
		RestAssured.useRelaxedHTTPSValidation();
		Response res = given().header("tenantId", "HKTS").header("agentId", "34009").when()
				.get("/avayascb-widget-dataprocessor/api/avayascb/link-reference-widgets").then().assertThat().statusCode(200).extract()
				.response();


		System.out.println(res.asString());

	}

	public static JsonPath function(Response r) {
		String raw = r.asString();
		System.out.println(raw);
		JsonPath js = new JsonPath(raw);
		return js;
	}

}

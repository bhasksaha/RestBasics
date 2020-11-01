import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Getcontactlist {
	
	//can practise extract parameter from reponse, with complex json flow

	// String a;
	// https://192.168.104.17/VP_POM_Service/v2/contactlists/62/contacts/list
	@Test
	public void getRequest() {
		RestAssured.baseURI = "https://192.168.104.17";
		RestAssured.useRelaxedHTTPSValidation();
		Response res = given().auth().basic("gslab", "Avaya@123").header("X-Requested-With", "rest").when()
				.get("/VP_POM_Service/v2/contactlists/1/contacts/list").then().assertThat().statusCode(200).extract()
				.response();

		JsonPath ajs = function(res);
		String data = ajs.getString("contactBatch[0].contactListName");
		//System.out.println(data);

	}

	public static JsonPath function(Response r) {
		String raw = r.asString();
		System.out.println(raw);
		JsonPath js = new JsonPath(raw);
		return js;
	}

}

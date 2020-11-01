import org.apache.http.params.CoreConnectionPNames;
import org.testng.annotations.Test;

import files.resources;
import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Basics2 {
	
	//can practise post from external file post operation
	//conversion from response string to json and  
	// String a;
	// https://192.168.104.17/VP_POM_Service/v2/contactlists/62/contacts/list
	@Test
	public void getRequest() throws IOException {
		
		//String postdata=resources.generateStringFromResource("C:\\Users\\GS-2094\\Documents\\postdata.json");
		
		RestAssured.baseURI = "https://192.168.104.19:7443";
		RestAssured.useRelaxedHTTPSValidation();
		Response res = 
				given().
				auth(). preemptive().basic("dialler_manager_hk", "Avaya123!").
				header("Content-Type", "application/json").header("tenantId", "HKTS").
				body("{\"linkDisplayName\":\"kpmg12\",\"linkPurpose\":\"testing\",\"linkUrl\":\"www.kpmg.com\",\"linkDescription\":\"kpmg Link\",\"isLinkACtivated\":true,\"linkCreatedBy\":1,\"linkWithAttachment\":false,\"tenantId\":\"HKTS\"}").log().all().
				//body(postdata).
				when().
				post("/avayascb-widget-dataprocessor/api/link-reference-widgets").
				then().assertThat().statusCode(201).
				extract()
				.response();
		
		

		JsonPath ajs = resources.function(res);
		String data = ajs.getString("id");
		System.out.println(data);

	}
	

}

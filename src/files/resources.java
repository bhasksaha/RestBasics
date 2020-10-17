package files;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class resources {
	
	public static Properties prop = new Properties();
	
	public static String generateStringFromResource(String path) throws IOException{
		return new String(Files.readAllBytes(Paths.get(path)));} 
	
	public static JsonPath function(Response r) {
		String raw = r.asString();
		System.out.println(raw);
		JsonPath js = new JsonPath(raw);
		return js;
	}
	
	public static String returnId() throws IOException {
		String postdata=generateStringFromResource("C:\\Users\\GS-2094\\Documents\\postdata.json");

		RestAssured.baseURI = "https://192.168.104.19:7443";
		RestAssured.useRelaxedHTTPSValidation();
		Response res=given().
		auth(). preemptive().basic("dialler_manager_hk", "Avaya123!").
		header("Content-Type", "application/json").header("tenantId", "HKTS").
		//body("{\"linkDisplayName\":\"kpmg12\",\"linkPurpose\":\"testing\",\"linkUrl\":\"www.kpmg.com\",\"linkDescription\":\"kpmg Link\",\"isLinkACtivated\":true,\"linkCreatedBy\":1,\"linkWithAttachment\":false,\"tenantId\":\"HKTS\"}").log().all().
		body(postdata).
		when().
		post("/avayascb-widget-dataprocessor/api/link-reference-widgets").
		then().assertThat().statusCode(201).
		extract()
		.response();
		
		JsonPath ajs = resources.function(res);
		String data = ajs.getString("id");
		System.out.println(data);
		return data;
		
	}

}

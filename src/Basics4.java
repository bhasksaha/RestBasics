import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import files.resources;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Basics4 {
	
	Properties prop = new Properties();
	
	
	
	
	@BeforeTest
	public void setup() throws IOException {
				FileInputStream ip = new FileInputStream("C:\\Users\\GS-2094\\eclipse-workspace\\RestAssuredBasics\\src\\files\\env.properties");
		prop.load(ip);
		
		
	}
	
	
	@Test
	public void endToEnd() throws IOException {
		
		RestAssured.baseURI = prop.getProperty("HOST");
		RestAssured.useRelaxedHTTPSValidation();
	given().auth(). preemptive().basic("dialler_manager_hk", "Avaya123!").
	header("Content-Type", "application/json").header("tenantId", "HKTS").
	body("{\"id\":"+resources.returnId()+",\"linkDisplayName\":\"kpmgupdate\",\"linkUrl\":\"http%3A%2F%2Fwww.kpmg.com\",\"linkPurpose\":\"testing1\",\"linkCreatedAt\":\"2019-11-06T12:16:00Z\",\"linkCreatedBy\":\"dialler_manager_hk\",\"linkModifiedAt\":\"2019-11-06T12:16:00Z\",\"linkModifiedBy\":\"dialler_manager_hk\",\"linkWithAttachment\":false,\"attachment\":null,\"attachmentContentType\":null,\"fileName\":null}").
	when().put(prop.getProperty("Resource")).
	then().assertThat().statusCode(200).
	extract().response();
	
	
	
	}
}

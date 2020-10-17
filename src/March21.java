import static io.restassured.RestAssured.given;

import java.sql.Timestamp;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
//import io.restassured.RestAssured.*;

public class March21 {
	
	
	static Timestamp TS() {
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		return ts;
	}
	
	@Test
	public void arrayloop() {
		
		
		
//		Response res=given().relaxedHTTPSValidation().
//		auth(). preemptive().basic("dialler_manager_hk", "Avaya123!").
//		header("Content-Type", "application/json").header("tenantId", "HKTS").header("agentId","34006").
//		when().get("https://192.168.104.19:7443/avayascb-widget-dataprocessor/api/avayascb/call-informations/last-ten-calls").
//		
//		then().assertThat().statusCode(200).
//		extract()
//		.response();
//		
//		String r=res.asString();
//		System.out.println(r);
		
		//static String str="abc";
		
		
		Object[][] obj=new Object[][] {{TS()+"isbn1",TS()+"aisle1"},{TS()+"isbn2",TS()+"aisle2"},{TS()+"isbn3",TS()+"aisle3"},{TS()+"isbn4",TS()+"aisle4"}};
		for(int i=0;i<=3;i++) {
			
			for(int j=0;j<=1;j++) {
			System.out.print(obj[i][j]+" ");
			
		}
			System.out.println("");
			
	}

}
}

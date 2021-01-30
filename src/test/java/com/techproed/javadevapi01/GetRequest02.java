package com.techproed.javadevapi01;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.response.Response;

public class GetRequest02 {

	/*	Test the API if it is working for negative scenarios:
	 	When
	  	I send a GET request to REST API URL https://restful-booker.herokuapp.com/booking/1001
	  Then
		 HTTP Status code should be 404
	  And
		 Status Line should be HTTP/1.1 404 Not Found
	  And
	     Response body contains "Not Found"
	  And
	     Response body does not contain "TechProEd"
	 */
	@Test
	public void get01() {
		
		//1.Step: Set the URL
		String url = "https://restful-booker.herokuapp.com/booking/1001";
		
		//2.Step: Set the expected data
		
		//3.Step: Send the request to the API
		Response response = given().accept("application/json").when().get(url); //ContentType.JSON also works
		
		response.prettyPrint();
		
		//4.Step: Make assertions
		//Java stops execution in first failure. This is "Hard Assertion"(assertion)
		response.then().assertThat()
									.statusCode(404)
									.statusLine("HTTP/1.1 404 Not Found");
//		assertTrue(response.asString().contains("Not Found"));									
//		assertFalse(response.asString().contains("TechProEd"));
		
		//Execute all assertion even some of them fails. This is called "Soft Assertion"
		//How to do "Soft Assertion"
		
			//a) Create SoftAssert object
			SoftAssert softAssert = new SoftAssert();
			
			//b) USe assertion with SoftAssert(verification) object
			System.out.println("-------------------------------");
			softAssert.assertTrue(response.asString().contains("Not Fund"));
			System.out.println("-------------------------------");
			softAssert.assertFalse(response.asString().contains("TechProEd"));
			System.out.println("-------------------------------");
			
			//c) Use assertAll() <== Do not forget
			softAssert.assertAll();
	}
	
}

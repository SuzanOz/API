package com.techproed.javadevapi01;

import testbaseclasses.TestBaseDummyRestApi;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojos.Todos;


public class DeleteRequest01 extends TestBaseDummyRestApi{

	/*
	 	When
	 		I send DELETE Request to the Url http://dummy.restapiexample.com/api/v1/delete/2	 		
	 	Then 
		 	Status code is 200
		 	And Response body is {
								    "status": "success",
								    "data": "2",
								    "message": "Successfully! Record has been deleted"
								 }
	 */
	
	@Test
	public void delete01() {
		//Set the URL
		spec.pathParams("api", "api",
				        "version", "v1",
				        "delete", "delete",
				        "id", 2);
		
		//Set the expected Data
		HashMap<String, String> expectedData = new HashMap<>();
		
		expectedData.put("status", "success");
		expectedData.put("data", "2");
		expectedData.put("message", "Successfully! Record has been deleted");
		
		//Send Delete Request
		Response response = given().spec(spec).contentType(ContentType.JSON).when().delete("/{api}/{version}/{delete}/{id}");
		response.prettyPrint();
			
		//Assertion
		HashMap<String, String> actualData = response.as(HashMap.class);
		
		assertEquals(expectedData.get("status"), actualData.get("status"));
		assertEquals(expectedData.get("data"), actualData.get("data"));
		assertEquals(expectedData.get("message"), actualData.get("message"));
	}
	
}

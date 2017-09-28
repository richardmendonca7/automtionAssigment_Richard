package pages;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class ApiCalls {

	public String  sendGetRequestToGetAllUser() {
		RestAssured.baseURI = "http://85.93.17.135:9000/user/all/json";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get();
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
		return responseBody;
	}

	public void  sendDeleteREquestToDeleteAllUser() {
		RestAssured.baseURI = "http://85.93.17.135:9000/user/all";
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.delete();
		System.out.println("Deleted all user");
	}

}

package Ecommerce_API_functions;

import org.junit.Assert;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class login {

	private static RequestSpecification spec1 = ecommerceBase.API_base_login();

	public static loginResponse loginRequest(login_details loginDetails) {

		Response res = RestAssured.given().spec(spec1).contentType(ContentType.JSON).body(loginDetails).when()
				.post("/api/ecom/auth/login").then().log().all().extract().response();
		loginResponse loginR = new loginResponse();
		try {
			Assert.assertEquals(res.getStatusCode(), 200);
			loginR = res.as(loginResponse.class);
		} catch (Exception e) {
			System.out.println(res.getStatusCode());
			System.out.println(res.getBody().toString());
		}
		return loginR;

	}

	public static void main(String args[]) {
		login_details loginDetails = new login_details();
		loginDetails.setUserEmail("beheramanishkumar@gmail.com");
		loginDetails.setUserPassword("Manish@456");
		loginResponse response = loginRequest(loginDetails);
		System.out.println(response.getToken());
	}
}

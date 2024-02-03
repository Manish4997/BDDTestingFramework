package Ecommerce_API_functions;

import org.junit.Assert;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class create_product {
	private static RequestSpecification spec1 = ecommerceBase.API_base_login();
	public static createProductResponse loginRequest(login_details loginDetails) {

		Response res = RestAssured.given().spec(spec1).contentType(ContentType.JSON).body(loginDetails).when()
				.post("api/ecom/product/add-product").then().extract().response();
		createProductResponse productresponse = new createProductResponse();
		try {
			Assert.assertEquals(res.getStatusCode(), 200);
			productresponse = res.as(createProductResponse.class);
		} catch (Exception e) {
			System.out.println(res.getStatusCode());
			System.out.println(res.getBody().toString());
		}
		return productresponse;

	}
}

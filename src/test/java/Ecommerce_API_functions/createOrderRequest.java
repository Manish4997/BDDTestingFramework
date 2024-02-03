package Ecommerce_API_functions;

import java.util.ArrayList;

import org.junit.Assert;

import edu.emory.mathcs.backport.java.util.Arrays;
import io.restassured.response.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class createOrderRequest {

	static RequestSpecification createspec = ecommerceBase.API_base_login();

	@SuppressWarnings("unchecked")
	public static createorderResponse createOrderRequestfn(ArrayList<String> productOrderedId, String Country,
			String AuthorizationToken) {
//		List<create_order> orders=new ArrayList<create_order>();
		createorderResponse orderResponse=new createorderResponse();
		order_details[] orders = new order_details[productOrderedId.size()];
		for (int i = 0; i < productOrderedId.size(); i++) {
			orders[i] = new order_details();
			orders[i].setCountry(Country);
			orders[i].setProductOrderedId(productOrderedId.get(i));

		}
		create_order totalOrder = new create_order();
		totalOrder.setOrders(Arrays.asList(orders));
		Response createResponsedata = RestAssured.given().spec(createspec).contentType(ContentType.JSON)
				.header("Authorization", AuthorizationToken.trim()).body(totalOrder).when()
				.post("/api/ecom/order/create-order").then().extract().response();

		try {
			Assert.assertEquals(createResponsedata.getStatusCode(), 201);
			orderResponse = createResponsedata.as(createorderResponse.class);
		} catch (Exception e) {
			System.out.println(createResponsedata.getStatusCode());
			System.out.println(createResponsedata.getBody().toString());
		}
		
      return orderResponse;
      
      
	}
	
	public static void main(String args[])
	{
		
		ArrayList<String> productOrderedId = new ArrayList<String>();
		productOrderedId.add("6581cade9fd99c85e8ee7ff5");
		productOrderedId.add("6581ca979fd99c85e8ee7faf");
		productOrderedId.add("6581ca399fd99c85e8ee7f45");
		String Country="India";
		String authToken="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWI1ZmZlNmE4NmY4Zjc0ZGM2NDRmYTQiLCJ1c2VyRW1haWwiOiJiZWhlcmFtYW5pc2hrdW1hckBnbWFpbC5jb20iLCJ1c2VyTW9iaWxlIjo2MzcyMDM3Mzc3LCJ1c2VyUm9sZSI6ImN1c3RvbWVyIiwiaWF0IjoxNzA2OTU4MTE4LCJleHAiOjE3Mzg1MTU3MTh9.H0ItunamRMcAvRTjBI3Bywt-c0rkh8gXEoxmpiqQArg";
		
		createorderResponse responseOutput= new createorderResponse();
		responseOutput=createOrderRequestfn(productOrderedId, Country, authToken);
		System.out.println(responseOutput.getOrders());
		
		
		
	}
	
	
	

}

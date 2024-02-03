package Ecommerce_API_functions;

import Utilities.ProjectConfiguration;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class ecommerceBase {

	private static String base_uri= ProjectConfiguration.LoadProperties("APIbase_url");
	public static RequestSpecification API_base_login() {
		
		return new RequestSpecBuilder().setBaseUri(base_uri).build();
		
	}
}

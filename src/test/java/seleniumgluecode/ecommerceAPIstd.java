package seleniumgluecode;

import Utilities.ProjectConfiguration;
import io.restassured.response.*;
import Utilities.encryptDecrypt;
import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.asserts.*;

import Ecommerce_API_functions.*;

public class ecommerceAPIstd extends BaseClass
{
	
	
	public static String keyword;
	public static String AuthToken;
	public static String username;
	public static String password;
	public static String secretKey;
	public static String IV;
	public static loginResponse loginResponse;
	public static createorderResponse createOrderResponse;
	public static String base_url;
//	public static Scenario scenario;
	public static ArrayList<String> productOrderedId;
	public static String country;
	
	@Before("@EcommerceE2E")
	public void Before(Scenario scenario) throws Exception {
		initscenario(scenario);
		keyword="";
		AuthToken="";
		secretKey=ProjectConfiguration.LoadProperties("SecretKey");
		IV=ProjectConfiguration.LoadProperties("IV");
		username=encryptDecrypt.decriptionWithSecretKey(ProjectConfiguration.LoadProperties("UserName"), secretKey, IV);
		password=encryptDecrypt.decriptionWithSecretKey(ProjectConfiguration.LoadProperties("Password"), secretKey, IV);
	    loginResponse=new loginResponse();
	    createOrderResponse= new createorderResponse();
	    productOrderedId = new ArrayList<String>();
		productOrderedId.add("6581cade9fd99c85e8ee7ff5");
		productOrderedId.add("6581ca979fd99c85e8ee7faf");
		productOrderedId.add("6581ca399fd99c85e8ee7f45");
		country="India";
	}
	@After("@EcommerceE2E")
	public void after() {
		
	}
	
	
	@Given("^The Keword for Validate User is able to login and create product successfully using API is \"([^\"]*)\"$")
	public void the_keword_for_validate_user_is_able_to_login_and_create_product_successfully_using_api_is(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Given("^The Keword for Validate User is able to login and create order successfully using API is \"([^\"]*)\"$")
	public void the_keword_for_validate_user_is_able_to_login_and_create_order_successfully_using_api_is(String Keyword) {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("keyword", Keyword);
		keyword=System.getProperty("keyword");
	       
	}

	@When("^User logins to Ecommerce Website using the Login API$")
	public void user_logins_to_ecommerce_website_using_the_login_api() {
	    // Write code here that turns the phrase above into concrete actions
		login_details loginDetails = new login_details();
		loginDetails.setUserEmail(username);
		loginDetails.setUserPassword(password);
		loginResponse = login.loginRequest(loginDetails);
		
	    System.out.println("User successfully logged in to ecommerce Website through API");
	    StepLog("User successfully logged in to ecommerce Website through API");
	}

	@Then("^Validate that user is able to get the Authorization token and userId from the Response$")
	public void validate_that_user_is_able_to_get_the_authorization_token_and_user_id_from_the_response() {
	    if(loginResponse.getToken().length() > 0) {
	    	Assert.assertTrue(true);
	    	System.out.println("User able to retrieve the Auth Token "+loginResponse.getToken()+" and UserID "+loginResponse.getUserId()+" from the Login response");
	    	StepLog("User able to retrieve the Auth Token "+loginResponse.getToken()+" and UserID "+loginResponse.getUserId()+" from the Login response");
	    	AuthToken=loginResponse.getToken().trim();
	    }
	    else
	    {
	    	Assert.assertTrue(false);
	    }
	    
	}

	@Then("^User creates a product in the website using Create Product API using the \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_creates_a_product_in_the_website_using_create_product_api_using_the_and(String AuthorizationToken, String UserId) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("^User validates that the product is created successfully$")
	public void user_validates_that_the_product_is_created_successfully() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("User creates a Order in the website using Create Order API using the \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_creates_a_order_in_the_website_using_create_order_api_using_the_and_and(String AuthorizationToken, String ProductId, String Country) {
	    // Write code here that turns the phrase above into concrete actions
		createOrderResponse=createOrderRequest.createOrderRequestfn(productOrderedId, Country, AuthToken);
		System.out.println("User successfully created a order....Response Message: "+createOrderResponse.getMessage());
		StepLog("User successfully created a order....Response Message: "+createOrderResponse.getMessage());
		
	    
	}

	@Then("User validates that the order is created successfully")
	public void user_validates_that_the_order_is_created_successfully() {
		 if(createOrderResponse.getOrders().size() > 0) {
		    	Assert.assertTrue(true);
		    	System.out.println("Orders created are: "+createOrderResponse.getOrders());
		    	StepLog("Orders created are: "+createOrderResponse.getOrders());
		    }
		    else
		    {
		    	Assert.assertTrue(false);
		    }
	}
}

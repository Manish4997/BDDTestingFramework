package seleniumgluecode;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import Utilities.ProjectConfiguration;

public class stepdefiniton {
	
	 private WebDriver driver;
	@Before
	public void setup() {
		ChromeOptions chromeoptions=new ChromeOptions();
		  chromeoptions.addArguments("--remote-allow-origins=*");
		  chromeoptions.addArguments("--disable-notifications");
		  chromeoptions.addArguments("--disable-popup-blocking");
		  chromeoptions.addArguments("--start-maximized");
		  DesiredCapabilities SSLcertificate=new DesiredCapabilities();
		  SSLcertificate.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		  SSLcertificate.setCapability(ChromeOptions.CAPABILITY, chromeoptions);
		  chromeoptions.merge(SSLcertificate);
		   WebDriverManager.chromedriver().setup();
		   driver=new ChromeDriver(chromeoptions);
		   driver.manage().window().maximize();
	}
	@After
	public void logout() {
		driver.quit();
		
	}
	
	@Given("User navigates to the webpage using the web url")
	public void user_navigates_to_the_webpage_using_the_web_url() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		driver.get(ProjectConfiguration.LoadProperties("base_url"));
		
	}

	@When("User navigates to the Home page")
	public void user_navigates_to_the_home_page() {
	    // Write code here that turns the phrase above into concrete actions
	    String s=driver.getTitle();
	    System.out.println(s);
	}

	@Then("User validates the title of the page")
	public void user_validates_the_title_of_the_page() {
	    // Write code here that turns the phrase above into concrete actions
	    Assert.assertTrue("It is not navigated to the correct page",!driver.getTitle().isEmpty());
	    
	    
	}
}

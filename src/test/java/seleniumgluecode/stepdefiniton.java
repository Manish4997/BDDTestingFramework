package seleniumgluecode;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import webUtils.ActionUtils;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import PageUtils.OrangeHRMfunctions;
import PageUtils.worldpopulation_utils;
import Utilities.ProjectConfiguration;
import Utilities.ReportUtils;
import base.TestBase;

public class stepdefiniton extends TestBase {
	private static final Logger LOGGER = LogManager.getLogger(stepdefiniton.class);
	private static WebDriver driver;
	private static OrangeHRMfunctions orangeHRMfunctions;
	private static worldpopulation_utils worldpopulation_utils;

	@Before
	public void setup(Scenario scenario) {

		LOGGER.info("Staring the test Execution for scenario " + scenario.getName());
		ReportUtils.setScenario(scenario);
		StartWebDriver();
		driver = getDriver();
		orangeHRMfunctions = new OrangeHRMfunctions(driver);
		worldpopulation_utils = new worldpopulation_utils(driver);
		driver.manage().timeouts().implicitlyWait(
				Duration.ofSeconds(Integer.parseInt(ProjectConfiguration.LoadProperties("implicitwaitTime"))));
		driver.manage().window().maximize();

	}

	@After
	public void logout() {
//		if(driver!=null) {
//		driver.quit();
//		}
	}

	@Given("User navigates to the webpage using the web url")
	public void user_navigates_to_the_webpage_using_the_web_url() throws IOException {
		// Write code here that turns the phrase above into concrete actions
		driver.get(ProjectConfiguration.LoadProperties("base_url"));
		ActionUtils.ActionWait(10);
		ReportUtils.StepLog("Navigating to to OrangeHRM portal");
		ReportUtils.CaptureScreenshot(driver, "Navigating to to OrangeHRM portal");

	}

	@When("User navigates to the Home page")
	public void user_navigates_to_the_home_page() {
		// Write code here that turns the phrase above into concrete actions
		String s = driver.getTitle();
		System.out.println(s);
		ReportUtils.StepLog("Title of the Page " + s);
	}

	@Then("User logins into OrangeHRM with {string} and {string}")
	public void user_logins_into_orange_hrm_with_and(String UserName, String Password) {
		ReportUtils.StepLog("Logging in to OrangeHRM portal");
		UserName = ProjectConfiguration.LoadProperties(UserName);
		Password = ProjectConfiguration.LoadProperties(Password);
		orangeHRMfunctions.user_logins_to_OrangeHRM(UserName, Password);

	}

	@Given("User navigates to World Population site")
	public void user_navigates_to_world_population_site() {
		driver.get(ProjectConfiguration.LoadProperties("Population_base_url"));
		ActionUtils.ActionWait(10);
		ReportUtils.StepLog("Navigating to to OrangeHRM portal");
		ReportUtils.CaptureScreenshot(driver, "Navigating to to OrangeHRM portal");
	}

	@Then("User validates population data is displayed on hovering on the graph and user writes the data in an Excel Sheet")
	public void user_validates_population_data_is_displayed_and_user_writes_the_data_in_an_excel_sheet() {
		ReportUtils.StepLog(
				"User validates population data is displayed on hovering on the graph and user writes the data in an Excel Sheet");
		worldpopulation_utils.user_collects_data_from_graph_and_writes_in_excel();
		ReportUtils.CaptureScreenshot(driver,
				"User validates population data is displayed on hovering on the graph and user writes the data in an Excel Sheet");
	}

}

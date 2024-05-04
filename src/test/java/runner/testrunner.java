package runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import Utilities.ReportUtils;
import base.BrowserName;
import base.DriverManager;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(tags = "@parallel", features = { "src/test/java/features" }, glue = { "seleniumgluecode" }, plugin = {
		"json:Results/cucumberjson/cucumberjson.json" }, publish = false, dryRun = false)

public class testrunner {

	@BeforeClass
	public static void start()
	{
		DriverManager.setBrowser(BrowserName.CHROME);
	}
	@AfterClass
	public static void TearDown()
	{
		ReportUtils.generateHTMLReport();
	}
}
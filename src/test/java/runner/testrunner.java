package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(tags = "@tag1", features = { "src/test/java/features" }, glue = { "seleniumgluecode" }, plugin = {
		"json:Results/cucumberjson/cucumberjson.json" }, publish = false, dryRun = false)

public class testrunner {

}
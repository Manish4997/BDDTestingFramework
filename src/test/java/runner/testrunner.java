package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
    
@CucumberOptions(tags = "@tag1", features = {"src/test/java/features/Cucumber.feature"}, glue = {"seleniumgluecode"},
                 plugin = {"pretty",
                         "json:target/cucumberjson/cucumberjson.json"},publish=false)
    
public class testrunner extends AbstractTestNGCucumberTests {
    
}
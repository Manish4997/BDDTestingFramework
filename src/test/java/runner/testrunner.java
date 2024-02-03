package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
    
@CucumberOptions(tags = ("@EcommerceE2E and @CreateOrder") , features = {"src/test/java/features/EcommerceAPI.feature"}, glue = {"seleniumgluecode"},
                 plugin = {"pretty",
                         "json:Results/cucumberjson/cucumber.json"},publish=false)
    
public class testrunner extends AbstractTestNGCucumberTests {
    
}
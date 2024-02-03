package seleniumgluecode;

import java.util.Map;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Cucumber.ScenarioContext;
import io.cucumber.java.Scenario;

public class BaseClass {
      private static Scenario scenario = null;
      private static ScenarioContext scenariocontext;
     
      public static void initscenario(Scenario scenario) {
    	  BaseClass.scenario=scenario;
    	  scenariocontext=new ScenarioContext();
    	  
      }
	
      public static void StepLog(String msg) {
    	 
    	  scenario.log(msg +"\n");
    	  
      }
	
      public static void CaptureScreenshot(WebDriver driver) {
    	  scenario.attach(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "images/png","output");
      }
	
	
	
	
	
}

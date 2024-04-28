package Utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.Scenario;

public class ReportUtils {
  
	private static Scenario scenario;

	public static Scenario getScenario() {
		return scenario;
	}
    
	public static void setScenario(Scenario scenario) {
		ReportUtils.scenario = scenario;
	}
	
	 public static void StepLog(String msg) {
    	 
   	  ReportUtils.getScenario().log(msg+"\n");
   	  
     }
	
     public static void CaptureScreenshot(WebDriver driver,String msg) {
    	 ReportUtils.getScenario().attach(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png" ,msg);
     }
	
}

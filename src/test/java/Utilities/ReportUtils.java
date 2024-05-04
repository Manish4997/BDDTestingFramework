package Utilities;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.Scenario;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.json.support.Status;
import net.masterthought.cucumber.reducers.ReducingMethod;
import seleniumgluecode.stepdefiniton;

public class ReportUtils {
	private static final Logger LOGGER = LogManager.getLogger(ReportUtils.class);
	private static Scenario scenario;
	private static String JsonPath=System.getProperty("user.dir")+"//"+"Results/cucumberjson/cucumberjson.json";
	private static String ProjectName="cucumber-html-report_"+DateTimeUtils.getCurrentDateTimeIST();
	private static String OutputDirectory=System.getProperty("user.dir")+"//"+"Results/"+ProjectName;
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
     public static void generateHTMLReport() {
    	 
    	 LOGGER.info("Generation the Cucumber HTML Report for the Test Execution");
    	 File reportOutputDirectory = new File(OutputDirectory);
         List<String> jsonFiles = new ArrayList<>();
         jsonFiles.add(JsonPath);
         String buildNumber = "1";
         String projectName = "AutomationTestReport";
         Configuration configuration = new Configuration(reportOutputDirectory, projectName);
         configuration.setBuildNumber(buildNumber);
         configuration.setNotFailingStatuses(Collections.singleton(Status.SKIPPED));
         configuration.addReducingMethod(ReducingMethod.SKIP_EMPTY_JSON_FILES);
         ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
         reportBuilder.generateReports();
     }
     }
	


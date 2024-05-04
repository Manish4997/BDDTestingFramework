package base;

import java.util.Collections;
import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import webUtils.JavascrpitUtils;

public class TestBase extends DriverManager {
	
	private static final Logger LOGGER=LogManager.getLogger(TestBase.class);
	public void StartWebDriver() {
		LOGGER.info("Starting the Execution on browser"+DriverManager.getBrowser());
		setupBrowser(DriverManager.getBrowser());
	}

	protected WebDriver createchromedriver(BrowserName browser) {
		WebDriver driver = null;
		HashMap<String, Object> chromepref = new HashMap<String, Object>();
		chromepref.put("download.default.directory", System.getProperty("user.dir") + "\\TestDownloads");
		chromepref.put("credentials_enable_service", false);
		chromepref.put("profile.password_manager_enabled", false);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromepref);
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--start-maximized");
		options.addArguments("--ignore-certificate-errors");
		options.setExperimentalOption("useAutomationExtension", false);  
		options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		options.setAcceptInsecureCerts(true);

		try {
			LOGGER.info("Initializing the Chrome Browser session");
			driver = new ChromeDriver(options);
		} catch (Exception e) {
			LOGGER.error("Unable to initialise browser");
			System.err.println("Unable to initialise browser");
			e.printStackTrace();
		}

		return driver;

	}

}

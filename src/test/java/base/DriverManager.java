package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
	
  private static final Logger LOGGER=LogManager.getLogger(DriverManager.class);
  private static final  ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
  private static ThreadLocal<BrowserName> browser=new ThreadLocal<BrowserName>();
  
  public void setupBrowser(BrowserName browser) 
  {
	WebDriver dr=null;
	switch(browser) {
	
	case CHROME:
		dr=createchromedriver(browser);
		break;
	default:
		LOGGER.error("Invalid Browser name selected");
		Assert.fail("Invalid Browser name selected");
		break;
	}
	setDriver(dr);
  }
  
  protected abstract WebDriver createchromedriver(BrowserName browser);


public static WebDriver getDriver() {
	return driver.get();
}

public static void setDriver(WebDriver driver) {
     DriverManager.driver.set(driver);
}

public static BrowserName getBrowser() {
	return browser.get();
}

public static void setBrowser(BrowserName browser) {
	DriverManager.browser.set(browser);;
}
  
}

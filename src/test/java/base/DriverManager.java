package base;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
  private static final  ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
  
  public void setupBrowser(BrowserName browser) 
  {
	WebDriver dr=null;
	switch(browser) {
	
	case CHROME:
		dr=createchromedriver(browser);
		break;
	default:
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
  
}

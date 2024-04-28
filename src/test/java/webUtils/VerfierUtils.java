package webUtils;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class VerfierUtils extends TestBase {

	
	public boolean VerifyElementisPresent(WebElement element , int waitTimeinSeconds) {
		try {
			WebDriverWait wait=new WebDriverWait(TestBase.getDriver(), Duration.ofSeconds(waitTimeinSeconds));
			wait.until(ExpectedConditions.visibilityOf(element));
			if(element.isDisplayed()) {
				return true;
			}
		}
		catch (Exception e) {
			return false;
		}
		return false;
	}
}

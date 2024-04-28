package webUtils;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class ActionUtils extends TestBase {

	public static void ActionWait(int waitTimeinSeconds) {
		try {
			Thread.sleep(waitTimeinSeconds * 1000);
		} catch (InterruptedException e) {
			Assert.fail("Failed to wait " + e.toString());
		}
	}

	public static void click(WebElement element, int waitTimeinSeconds) {
		boolean elementNotFound = true;
		try {
			WebDriverWait wait = new WebDriverWait(TestBase.getDriver(), Duration.ofSeconds(waitTimeinSeconds));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			if (element.isDisplayed() && element.isEnabled()) {
				element.click();
				elementNotFound = false;
			}
			if (elementNotFound) {
				Actions action = new Actions(TestBase.getDriver());
				action.moveToElement(element).click(element).build().perform();
				elementNotFound = false;
			}
		} catch (Exception e) {
			Assert.fail("Fail to click on element" + e.toString());
		}

	}

	public static void pressEnter() {
		try {
			Actions action = new Actions(TestBase.getDriver());
			action.sendKeys(Keys.ENTER).build().perform();
		} catch (Exception e) {
			Assert.fail("Fail to press Enter" + e.toString());
		}

	}

	public static void setText(WebElement element, String text, int waitTimeinSeconds) {
		boolean elementNotFound = true;
		try {
			WebDriverWait wait = new WebDriverWait(TestBase.getDriver(), Duration.ofSeconds(waitTimeinSeconds));
			wait.until(ExpectedConditions.visibilityOf(element));
			if (element.isDisplayed()) {
				element.clear();
				element.sendKeys(text);
				elementNotFound = false;
			}
			if (elementNotFound) {
				Actions action = new Actions(TestBase.getDriver());
				action.moveToElement(element).sendKeys(element,text).build().perform();
				elementNotFound = false;
			}
		} catch (Exception e) {
			Assert.fail("Fail to click on element" + e.toString());
		}
	}

	public static void clearandsetText(WebElement element, String text, int waitTimeinSeconds) {
		try {
			WebDriverWait wait = new WebDriverWait(TestBase.getDriver(), Duration.ofSeconds(waitTimeinSeconds));
			wait.until(ExpectedConditions.visibilityOf(element));
			Actions action = new Actions(TestBase.getDriver());
			action.moveToElement(element).click(element).sendKeys(Keys.END).keyDown(Keys.SHIFT).sendKeys(Keys.HOME).keyUp(Keys.SHIFT).sendKeys(Keys.BACK_SPACE).sendKeys(text).build().perform();

		} catch (Exception e) {
			Assert.fail("Fail to click on element" + e.toString());
		}
	}
	public static void openNewTab() {
		TestBase.getDriver().switchTo().newWindow(WindowType.TAB);
	}
	public static void openNewWindow() {
		TestBase.getDriver().switchTo().newWindow(WindowType.WINDOW);
	}
	
}

package webUtils;

import java.io.StringWriter;
import java.io.PrintWriter;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class ActionUtils extends TestBase {
	
	private static final Logger LOGGER=LogManager.getLogger(ActionUtils.class);

	public static void ActionWait(int waitTimeinSeconds) {
		try {
			LOGGER.info("Waiting for "+waitTimeinSeconds+" seconds");
			Thread.sleep(waitTimeinSeconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	public static void click(WebElement element, int waitTimeinSeconds) {
		boolean elementNotFound = true;
		try {
			LOGGER.info("Clicking on the WebElement");
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
			e.printStackTrace();
			Assert.fail();
		}

	}

	public static void pressEnter() {
		try {
			LOGGER.info("Pressing the Enter Button");
			Actions action = new Actions(TestBase.getDriver());
			action.sendKeys(Keys.ENTER).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}

	}

	public static void setText(WebElement element, String text, int waitTimeinSeconds) {
		boolean elementNotFound = true;
		try {
			LOGGER.info("Entering values in the text box");
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
			e.printStackTrace();
			Assert.fail();
		}
	}

	public static void clearandsetText(WebElement element, String text, int waitTimeinSeconds) {
		try {
			LOGGER.info("Entering values in the text box after clearing the text");
			WebDriverWait wait = new WebDriverWait(TestBase.getDriver(), Duration.ofSeconds(waitTimeinSeconds));
			wait.until(ExpectedConditions.visibilityOf(element));
			Actions action = new Actions(TestBase.getDriver());
			action.moveToElement(element).click(element).sendKeys(Keys.END).keyDown(Keys.SHIFT).sendKeys(Keys.HOME).keyUp(Keys.SHIFT).sendKeys(Keys.BACK_SPACE).sendKeys(text).build().perform();

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	public static void hoveringAction(WebElement element,int waitTimeinSeconds) {
		try {
			LOGGER.info("Hovering mouse over the element");
			WebDriverWait wait = new WebDriverWait(TestBase.getDriver(), Duration.ofSeconds(waitTimeinSeconds));
			wait.until(ExpectedConditions.visibilityOf(element));
			Actions action = new Actions(TestBase.getDriver());
			action.moveToElement(element).build().perform();

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
			
		}
	}
	public static void openNewTab() {
		LOGGER.info("Opening new tab");
		TestBase.getDriver().switchTo().newWindow(WindowType.TAB);
	}
	public static void openNewWindow() {
		LOGGER.info("Opening new window");
		TestBase.getDriver().switchTo().newWindow(WindowType.WINDOW);
	}
	
}

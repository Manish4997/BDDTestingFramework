package webUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import base.TestBase;

public class JavascrpitUtils extends TestBase{
	private static final Logger LOGGER=LogManager.getLogger(JavascrpitUtils.class);

	public void scrollIntoView(WebElement element) {
		LOGGER.info("Scrolling to the element");
		((JavascriptExecutor) TestBase.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	public void scrollPageBottom(WebElement element) {
		LOGGER.info("Scrolling to the PageBottom");
		((JavascriptExecutor) TestBase.getDriver()).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	public void scrollPageUp(WebElement element) {
		LOGGER.info("Scrolling to the PageTop");
		((JavascriptExecutor) TestBase.getDriver()).executeScript("window.scrollTo(0, -document.body.scrollHeight)");
	}
	public void clickelementByJS(WebElement element) {
		LOGGER.info("Clicking element with JS");
		((JavascriptExecutor) TestBase.getDriver()).executeScript("arguments[0].click();", element);
	}
	public void drawBoarder(WebElement element) {
		((JavascriptExecutor) TestBase.getDriver()).executeScript("arguments[0].style.border='3px solid red'", element);
	}
	public void openNewTab() {
		LOGGER.info("New Tab");
		((JavascriptExecutor) TestBase.getDriver()).executeScript("window.open()");
	}
}

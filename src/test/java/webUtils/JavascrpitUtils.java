package webUtils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import base.TestBase;

public class JavascrpitUtils extends TestBase{

	public void scrollIntoView(WebElement element) {
		((JavascriptExecutor) TestBase.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	public void scrollPageBottom(WebElement element) {
		((JavascriptExecutor) TestBase.getDriver()).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	public void scrollPageUp(WebElement element) {
		((JavascriptExecutor) TestBase.getDriver()).executeScript("window.scrollTo(0, -document.body.scrollHeight)");
	}
	public void clickelementByJS(WebElement element) {
		((JavascriptExecutor) TestBase.getDriver()).executeScript("arguments[0].click();", element);
	}
	public void drawBoarder(WebElement element) {
		((JavascriptExecutor) TestBase.getDriver()).executeScript("arguments[0].style.border='3px solid red'", element);
	}
	public void openNewTab() {
		((JavascriptExecutor) TestBase.getDriver()).executeScript("window.open()");
	}
}

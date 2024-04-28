package PageContainers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import base.TestBase;

public class OrangeHRMcontainers extends TestBase {

	@FindBy(how = How.XPATH, using = "//input[@name='username']")
	public WebElement OrangeHRM_Login_UserName_field;
	
	@FindBy(how = How.XPATH, using = "//input[@name='password']")
	public WebElement OrangeHRM_Login_Password_field;
	
	@FindBy(how = How.XPATH, using = "//button[contains(@class,'login')]")
	public WebElement OrangeHRM_Login_Login_btn;
	
	
}

package PageUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import PageContainers.OrangeHRMcontainers;
import Utilities.ReportUtils;
import webUtils.ActionUtils;
import webUtils.JavascrpitUtils;

public class OrangeHRMfunctions extends ReportUtils {
	
	private static WebDriver driver;
	private static OrangeHRMcontainers orangeHrmcontainers;
	private static JavascrpitUtils jsUtils;
	
	public OrangeHRMfunctions(WebDriver driver) {
		OrangeHRMfunctions.driver=driver;
	    orangeHrmcontainers= PageFactory.initElements(driver, OrangeHRMcontainers.class);
	    jsUtils=new JavascrpitUtils();
	}
	
	public void user_logins_to_OrangeHRM(String UserName, String Password) {
		ActionUtils.ActionWait(2);
		jsUtils.drawBoarder(orangeHrmcontainers.OrangeHRM_Login_UserName_field);
		ActionUtils.ActionWait(1);
		ActionUtils.setText(orangeHrmcontainers.OrangeHRM_Login_UserName_field, UserName, 2);
		jsUtils.drawBoarder(orangeHrmcontainers.OrangeHRM_Login_Password_field);
		ActionUtils.ActionWait(1);
		ActionUtils.setText(orangeHrmcontainers.OrangeHRM_Login_Password_field, Password, 2);
		jsUtils.drawBoarder(orangeHrmcontainers.OrangeHRM_Login_Login_btn);
		ReportUtils.CaptureScreenshot(driver, "User enters the credentials and hits the login button");
		ActionUtils.ActionWait(1);
		ActionUtils.click(orangeHrmcontainers.OrangeHRM_Login_Login_btn, 3);
		ActionUtils.ActionWait(5);
	}
	

}

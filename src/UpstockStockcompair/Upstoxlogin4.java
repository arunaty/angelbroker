package UpstockStockcompair;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Upstoxlogin4 {

	@FindBy(xpath = "//div[@data-id='accountDropDown']//span[1]")
	private WebElement actUser;

	public Upstoxlogin4(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void getUpstoxlogin4Userid(String auserid) {
		String expUserid = auserid;
		String getuserid = actUser.getText();
		boolean result = getuserid.equalsIgnoreCase(expUserid);
		System.out.println("============================");
		if (result) {
			System.out.println("Test Result is "+result);
			System.out.println("Test case: PASSED");
		} else {
			System.out.println("Test Result is "+result);
			System.out.println("Test case: FAILED");
		}
		System.out.println("============================");
	}

}

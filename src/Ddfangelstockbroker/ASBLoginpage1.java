package Ddfangelstockbroker;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ASBLoginpage1 {

	@FindBy(xpath = "//input[@id='txtUserID']")
	private WebElement userid;
	@FindBy(xpath = "//input[@id='txtTradingPassword']")
	private WebElement password;
	@FindBy(xpath = "//a[@id='loginBtn']")
	private WebElement loginBtn;

	public ASBLoginpage1(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void setASBLoginpage1username(String uid) {
		userid.sendKeys(uid);
	}

	public void setASBLoginpage1password(String pass) {
		password.sendKeys(pass);
	}

	public void clickASBLoginpage1loginBtn() {
		loginBtn.click();
	}
}

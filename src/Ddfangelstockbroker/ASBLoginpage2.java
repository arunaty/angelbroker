package Ddfangelstockbroker;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ASBLoginpage2 {

	@FindBy(xpath = "//div[@class='btn-wrapp']//button[2]")
	private WebElement clickOldBtn;

	public ASBLoginpage2(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickASBLoginpage2oldBtn() {
		clickOldBtn.click();
	}

}

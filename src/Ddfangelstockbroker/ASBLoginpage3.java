package Ddfangelstockbroker;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ASBLoginpage3 {

	@FindBy(xpath = "((//div[@class='collapse navbar-collapse']//ul)[10]//li[4]/a)[1]")
	private WebElement getLoggedUser;
	static String loggedUser;
	public ASBLoginpage3(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void getASBLoginpage3userid(String vuid) {
		loggedUser = getLoggedUser.getText();
//		if (loggedUser.equalsIgnoreCase(vuid)) {
//			System.out.print("Passed");
//		} else {
//			System.out.println("Failed");
//		}
	}
}

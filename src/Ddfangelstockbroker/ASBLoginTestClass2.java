package Ddfangelstockbroker;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ASBLoginTestClass2 {
	WebDriver driver;
	WebDriverWait wait;
	private String un, ps, vuid;

	@BeforeClass
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\SoftwareTesting\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://trade.angelbroking.com/login/");
	}

	@BeforeMethod
	public void readExcel() throws InterruptedException, EncryptedDocumentException, IOException {

		FileInputStream file = new FileInputStream("C:\\SoftwareTesting\\excelSelenium.xlsx");
		Sheet loginsheet = WorkbookFactory.create(file).getSheet("angelonelogin");

		// save useid and pass
		un = loginsheet.getRow(0).getCell(0).getStringCellValue();
		ps = loginsheet.getRow(0).getCell(1).getStringCellValue();
		vuid = loginsheet.getRow(0).getCell(2).getStringCellValue();

	}

	@Test(priority = 1)
	public void loginangel() {
		ASBLoginpage1 login = new ASBLoginpage1(driver);
		login.setASBLoginpage1username(un);
		login.setASBLoginpage1password(ps);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='loginBtn']")));
		login.clickASBLoginpage1loginBtn();
		
	}

	@Test(priority = 2,dependsOnMethods = {"loginangel"})
	public void clickonoldvers() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='btn-wrapp']//button[2]")));
		ASBLoginpage2 click = new ASBLoginpage2(driver);
		click.clickASBLoginpage2oldBtn();
		//Assert.fail();
	}

	@Test(priority = 3,dependsOnMethods = {"clickonoldvers"})
	public void getuseridverify() {
		ASBLoginpage3 getu = new ASBLoginpage3(driver);
		getu.getASBLoginpage3userid(vuid);
		Assert.assertEquals(ASBLoginpage3.loggedUser, vuid);
		
	}

	@AfterClass
	public void closeBrowser() {
		driver.close();
	}

}

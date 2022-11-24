package Ddfangelstockbroker;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ASBLoginTestClass {

	private static String un;
	private static String ps;
	private static String vuid;
	

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {

		FileInputStream file = new FileInputStream("C:\\SoftwareTesting\\excelSelenium.xlsx");
		Sheet loginsheet = WorkbookFactory.create(file).getSheet("angelonelogin");

		// save useid and pass
		un = loginsheet.getRow(0).getCell(0).getStringCellValue();
		ps = loginsheet.getRow(0).getCell(1).getStringCellValue();
		vuid = loginsheet.getRow(0).getCell(2).getStringCellValue();

		// open browser and go to url
		System.setProperty("webdriver.chrome.driver", "C:\\SoftwareTesting\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("https://trade.angelbroking.com/login/");

		ASBLoginpage1 login = new ASBLoginpage1(driver);
		login.setASBLoginpage1username(un);
		login.setASBLoginpage1password(ps);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='loginBtn']")));
		login.clickASBLoginpage1loginBtn();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='btn-wrapp']//button[2]")));
		ASBLoginpage2 click = new ASBLoginpage2(driver);
		click.clickASBLoginpage2oldBtn();

		
		ASBLoginpage3 getu = new ASBLoginpage3(driver);
		
		getu.getASBLoginpage3userid(vuid);

	}
}

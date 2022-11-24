package UpstockStockcompair;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Upstoxtestscript {

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {

		// get data for login from external sheet which is excel

		FileInputStream file = new FileInputStream("C:\\Users\\lakha\\Desktop\\Software Testing\\Automation Testing Notes\\Selenium Practice Demo\\upstoxlogin.xlsx");
		Sheet datasheet = WorkbookFactory.create(file).getSheet("Sheet1");
		

		System.setProperty("webdriver.chrome.driver", "C:\\SoftwareTesting\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("https://login-v2.upstox.com/");

		Upstoxlogin1 login1 = new Upstoxlogin1(driver);
		String username=datasheet.getRow(0).getCell(0).getStringCellValue();
		login1.setUpstoxlogin1username(username);
		String password=datasheet.getRow(0).getCell(1).getStringCellValue();
		login1.setUpstoxlogin1password(password);
		login1.clickUpstoxlogin1signBtn();
		Thread.sleep(3000);
		
		Upstoxlogin2 login2 = new Upstoxlogin2(driver);
		String gpin=datasheet.getRow(0).getCell(2).getStringCellValue();
		login2.setUpstoxlogin2pin(gpin);

		Upstoxlogin3 login3 = new Upstoxlogin3(driver);
		login3.clickUpstoxlogin3noBtn();
		Upstoxlogin4 login4 = new Upstoxlogin4(driver);
		String userid=datasheet.getRow(0).getCell(3).getStringCellValue();
		login4.getUpstoxlogin4Userid(userid);
		//driver.quit();
		
		UpstoxgetStockName gstock=new UpstoxgetStockName(driver);
		gstock.getUpstoxgetStockNameStockname();
		

	}

}

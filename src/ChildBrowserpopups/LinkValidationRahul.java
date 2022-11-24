package ChildBrowserpopups;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LinkValidationRahul {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\SoftwareTesting\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		Thread.sleep(1500);
		List<WebElement> links = driver.findElements(By.xpath("//div[@id='gf-BIG']//table//td[1]//a"));
		Thread.sleep(1500);

		Actions act = new Actions(driver);

		for (int i = 0; i < links.size(); i++) {

			act.keyDown(Keys.CONTROL).click(links.get(i)).build().perform();

		}

		Set<String> bid = driver.getWindowHandles();

		ArrayList<String> goid = new ArrayList<String>(bid);

		for (int j = 0; j < goid.size(); j++) {
			Thread.sleep(1000);
			String title = driver.switchTo().window(goid.get(j)).getTitle();
			System.out.println(title);

		}

	}

}

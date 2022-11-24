package ChildBrowserpopups;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QavboxChildbrowser {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\SoftwareTesting\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("https://qavbox.github.io/demo/links/");
		
		
		driver.findElement(By.name("NewTab")).click();
		
		Set<String> id = driver.getWindowHandles();
		ArrayList<String> childid=new ArrayList<String>(id);
		
	
		driver.switchTo().window(childid.get(1));
		System.out.println(driver.findElement(By.xpath("//div[@class='wf-wrap']//h1")).getText());
	}

}

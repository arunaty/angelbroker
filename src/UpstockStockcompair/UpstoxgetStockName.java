package UpstockStockcompair;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpstoxgetStockName {

	@FindBy(xpath = "((//div[@data-rbd-droppable-id='scrips']//div[@data-type='container'])[3]//div[@class='GVZPg514UQ_SC6KR0I5Cx']/div/div)[1]")
	private WebElement Stockname;

	public UpstoxgetStockName(WebDriver driver) {

		PageFactory.initElements(driver,this);
		
		
	}
	
	public void getUpstoxgetStockNameStockname()
	{
		String sn=Stockname.getText();
		System.out.println(sn);
	}
	
	
	

}

package week4.Day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDeal {

	public static void main(String[] args) {
		//Load https://www.snapdeal.com/

		WebDriverManager.chromedriver().setup();
		
	    //to avoid notification
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);
		
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
		
		//Mouse hover on Men's Fashion and Click Shirts
		WebElement men = driver.findElementByLinkText("Men's Fashion");
		Actions builder=new Actions(driver);
		builder.moveToElement(men).perform();
	    driver.findElementByXPath("(//span[text()='Shirts'])[2]").click();

	   //Mouse hover on the first product and Click on Quick View
	    WebElement firstproduct = driver.findElementByXPath("(//picture[@class='picture-elem'])[1]/img");
	    builder.moveToElement(firstproduct).perform();
	    driver.findElementByXPath("(//div[@class='center quick-view-bar  btn btn-theme-secondary  '])[1]").click();
	    driver.close();
	
	
	
	
	
	
	
	}

}

package Week7Day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PepperfryAssignment {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new  ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.pepperfry.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.findElementByXPath("//div[@id='regPopUp']/a").click();
		//2) Mouseover on Furniture and click Office Chairs under Chairs
		 WebElement furniture = driver.findElementByXPath("//a[text()='Furniture']");
		Actions builder=new Actions(driver);
		builder.moveToElement(furniture).perform();
		driver.findElementByXPath("//a[text()='Office Chairs']").click();
		
		//3) click Executive Chairs
		driver.findElementByXPath("//h5[text()='Executive Chairs']").click();
		
		//4) Change the minimum Height to 50 in under Dimensions
		driver.findElementByXPath("//input[@class='clipFilterDimensionHeightValue']").clear();
		driver.findElementByXPath("//input[@class='clipFilterDimensionHeightValue']").sendKeys("50");
		
		//Thread.sleep(9000);
		//5) Add "Galician High Back Executive Chair In Black Colour" chair to Wishlist
		driver.findElementByXPath("//a[@data-productname='Galician High Back Executive Chair in Brown Colour']").click();
	
	
		//6) Mouseover on Bedroom and Click Study tables
		//7) Select Spacewood as Brand
		//8) Select Price as 7000 to 8000
		//9) Add "SOS Carter Study Table In Lorraine Walnut & Silver Grey Finish" to Wishlist
		
		//10) Verify the number of items in the Wishlist

	
	}

}

package week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NykkaAss {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		   ChromeDriver driver=new ChromeDriver();
		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		   driver.get("https://www.nykaa.com/");

//		2) Mouseover on Brands and Mouseover on Popular
		   Thread.sleep(1000);
		Actions builder=new Actions(driver);
		WebElement brands = driver.findElementByXPath("//a[text()='brands']");
		WebElement popular = driver.findElementByXPath("//a[text()='Popular']");
		builder.moveToElement(brands).perform();
		builder.moveToElement(popular).perform();
		   
//		3) Click L'Oreal Paris
		driver.findElementByXPath("(//li[@class='brand-logo menu-links'])[5]//img").click();
		Thread.sleep(1000);

//		4) Go to the newly opened window and check the title contains L'Oreal Paris
		Set<String> newwin = driver.getWindowHandles();
		List<String> lorealWindow=new ArrayList<String>(newwin);
		//String firstWindow = lorealWindow.get(1);
		driver.switchTo().window(lorealWindow.get(1));
        
		String title = driver.getTitle();
		System.out.println("The first window Title is" + " " + title);
        if(title.contains("L'Oreal Paris"))
        		{
        	System.out.println("The title contains loreal");
        		}
        else
        {
        	System.out.println("The title not contains loreal");	
        }
        
        
//		5) Click sort By and select customer top rated
		driver.findElementByXPath("//span[text()='Sort By : ']").click();
		Thread.sleep(2000);
		//driver.findElementByXPath("//input[@id='3']").click();
		//driver.findElementByXPath("//span[text()='customer top rated']//following-sibling::input").click();
		driver.findElementByXPath("//span[text()='customer top rated']/parent::div").click();
		Thread.sleep(2000);
//		6) Click Category and click Shampoo
		driver.findElementByXPath("//div[text()='Category']").click();
		//personal care
		driver.findElementByXPath("//span[text()='Personal Care']").click();
		//bath nd shower
		driver.findElementByXPath("//span[text()='Bath & Shower']").click();
		//shampoo
		driver.findElementByXPath("//span[text()='Shampoo']").click();
		

//	    7) check whether the Filter is applied with Shampoo
       //WebElement checkshampoo = driver.findElementByXPath("//span[@class='filter-count']");		
		
//		8) Click on L'Oreal Paris Colour Protect Shampoo
		
		driver.findElementByXPath("//span[contains(text(),'Oreal Paris Colour ')]").click();
		//driver.findElementByXPath("//span[text()='L'Oreal Paris Colour Protect Shampoo']");
		Thread.sleep(2000);
//		9) GO to the new window and select size as 175ml
		
		Set<String> newwin1 = driver.getWindowHandles();
		List<String> lorealWindow1=new ArrayList<String>(newwin1);
		driver.switchTo().window(lorealWindow1.get(2));
		
		Thread.sleep(2000);
		driver.findElementByXPath("(//span[@class='size-pallets'])[2]").click();
		
//		10) Print the MRP of the product
		String MRP = driver.findElementByXPath("//span[@class='post-card__content-price-offer']").getText();
		System.out.println("The MRP is" + " " + MRP);
		
//		11) Click on ADD to BAG
		driver.findElementByXPath("//div[@class='pull-left']").click();
		
//		12) Go to Shopping Bag 
		driver.findElementByXPath("//div[@class='AddBagIcon']").click();
		
//		13) Print the Grand Total amount
		String Grand = driver.findElementByXPath("//div[@class='value medium-strong']").getText();
		System.out.println("The Grand Total is "+"$"+ Grand);
		Thread.sleep(2000);
//		14) Click Proceed
		
//		driver.findElementByXPath("//button[@class='btn full fill no-radius proceed ']").click();
//		driver.findElementByXPath("//button[text()='Close']").click();
//		driver.findElementByXPath("//button[@class='btn full fill no-radius proceed ']").click();
		
		
		//driver.findElementByXPath("//i[@class='proceed-arrow']").click();
		driver.findElementByXPath("//button[@class='btn full fill no-radius proceed ']").click();
	    driver.findElementByXPath("//button[@class='btn full fill']").click();
//		15) Click on Continue as Guest
		Thread.sleep(2000);
		driver.findElementByXPath("//button[@class='btn full big']").click();
		
//		16) Check if this grand total is the same in step 13
		
		String Grand1 = driver.findElementByXPath("(//div[@class='value'])[2]").getText();
		if(Grand.equalsIgnoreCase(Grand1))
		{
		System.out.println("verfied");	
		}
		System.out.println("not verify");
		
//		17) Close all windows
		driver.quit();

	
	
	
	
	
	
	}

}

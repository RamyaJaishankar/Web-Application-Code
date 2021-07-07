package Week7Day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AjioAssignment {

	public static void main(String[] args) throws InterruptedException {
		
        WebDriverManager.chromedriver().setup();
		
	    //to avoid notification
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);
		driver.get("https://www.ajio.com/shop/sale");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
	    
		 
	    //2) Enter Bags in the Search field and Select Women Handbags 
	    driver.findElementByXPath("//input[@name='searchVal']").sendKeys("Bags");
	    driver.findElementByXPath("//span[text()='handbags for women']").click();
	    
	    //3) Click on five grid and Select SORT BY as "What's New"
	    driver.findElementByXPath("//div[@class='five-grid']").click();
	    
	    // 4) Click Price on the side menu and Enter Price Range Min as 2000 and Max as 5000
	    driver.findElementByXPath("//span[text()='price']").click();
	    driver.findElementByXPath("//input[@name='minPrice']").sendKeys("2000");
	    driver.findElementByXPath("//input[@name='maxPrice']").sendKeys("5000");
	    driver.findElementByXPath("//button[@class='rilrtl-button ic-toparw']").click();
	    Thread.sleep(1000);
	    //5) Click on the first product 
	    driver.findElementByXPath("//div[@class='item rilrtl-products-list__item item']").click();
	    
	    //give ctrl to new window
	    Set<String> windowHandles = driver.getWindowHandles();
	    List<String> win1=new ArrayList<String>(windowHandles);
	    driver.switchTo().window(win1.get(1));
	   
	    
	    //6) Get the actual price, coupon code and discount price
	    
	    String actualPrice = driver.findElementByXPath("//div[@class='prod-sp']").getText();
	    System.out.println("Actual price"+" " +actualPrice);
	    
	    String couponCode = driver.findElementByXPath("//div[@class='promo-title-blck']").getText();
	    System.out.println("coupon code"+" " +couponCode);
	    
	    String disPrice = driver.findElementByXPath("//div[@class='prod-sp']").getText();
	    System.out.println("discount price"+" " +disPrice);
	    Thread.sleep(3000);
	    
	    // 7) Check the availability of the product for pincode 560043, print the expected delivery date if it is available
	    driver.findElementByXPath("//span[text()='Enter Pin-code To Know Estimated Delivery Date']").click();
	    driver.findElementByXPath("//input[@class='edd-pincode-modal-text']").sendKeys("560043");
	    driver.findElementByXPath("//button[text()='CONFIRM PINCODE']").click();
	   
	    String expDate = driver.findElementByXPath("//span[@class='edd-message-success-details-highlighted']").getText();
	    System.out.println("expected delivery date"+" " +expDate);
	    
	    // 8) Click on Other Informations under Product Details and Print the Customer Care details
	    driver.findElementByXPath("//div[@class='other-info-toggle']").click();
	    String customerDetails = driver.findElementByXPath("(//div[text()='Customer Care Address']/following-sibling::div)[2]").getText();
	    System.out.println("Customer Care details:"+" "+customerDetails);
	    
	   // 9) Click on ADD TO BAG and then GO TO BAG 
	    driver.findElementByXPath("//span[text()='ADD TO BAG']").click();
	    Thread.sleep(7000);
	    driver.findElementByXPath("//div[@class='btn-cart']").click();
	    
	   // 10) Check the Order Total before apply coupon 
         
	    String totalAmt = driver.findElementByXPath("//span[@class='price-value bold-font']").getText();
	    if(actualPrice.equals(totalAmt))
	    {
	    	System.out.println("Amount matched");
	    }
	    else
	    {
	    	System.out.println("Amount not matched");
	    }
	    
	   // 11) Enter Coupon Code and Click Apply 
	    driver.findElementByXPath("//p[@class='voucher-code']").click();
	    driver.findElementByXPath("//button[@class='rilrtl-button button apply-button ']").click();
	    
	   // 12) Print the warning message if the product is not eligible discount
	    //	12(a) Verify the bill amount is matching with the discount price or not 
	    String billamt = driver.findElementByXPath("//div[@class='net-price best-price-strip']").getText();
	    if(billamt.equals(disPrice))
	    {
	    	System.out.println("Bill Amount and discount matched");
	    }
	    else
	    {
	    	System.out.println("Bill Amount and discount not matched");	
	    }
	    
	    //13) Click on Delete and Delete the item from Bag 
	    Thread.sleep(3000);
	    driver.findElementByXPath("//div[@class='delete-btn']").click();
	    
	    
	   // 14) Close all the browsers

	    driver.quit();
    
	
	
	}

}

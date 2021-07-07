package week4.Day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lenskart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

	   WebDriverManager.chromedriver().setup();
	   ChromeDriver driver=new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
	   driver.get("https://www.lenskart.com/");
	   
	   //Mouse Hover "Computer Glasses"-->MEN-->Click Premium Range
	   
	   Actions builder=new Actions(driver);
	   WebElement computer = driver.findElementByXPath("//a[text()='Computer Glasses']");
	   Thread.sleep(2000);
	   builder.moveToElement(computer).perform();
	   
	   //MEN
	   WebElement men = driver.findElementByXPath("(//span[text()='men'])[2]");
	   builder.moveToElement(men).perform();
	   
	   //Click Premium Range
	   WebElement premium = driver.findElementByXPath("//span[text()='PREMIUM RANGE']");
	   builder.moveToElement(premium).click().perform();
      
	   //Click Round(Frame Shape)
	   driver.findElementByXPath("//span[@title='Round']").click();

      
	   WebElement higCount = driver.findElementByXPath("//li[@class='list-checkbox']//label/input/following-sibling::span");
	   String highestcount = higCount.getText();
	   System.out.println(highestcount);
	 
	  //Click on Frame color with highest count
	  driver.findElement(By.xpath("//div[text()='FRAME COLOR']/following::span")).click();
	  		
	   
	  
	  //Confirm the count shown in the frame color matches the displayed results count


	   
}}

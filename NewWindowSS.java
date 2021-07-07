package week4.day2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewWindowSS {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

        WebDriverManager.chromedriver().setup();
		
	    //to avoid notification
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	
		//Close the alert
       driver.findElementByXPath("//button[@class='btn btn-primary']").click();
	   Thread.sleep(3000);
       //Click on FLIGHTS tab
       
       driver.findElementByXPath("//a[text()=' FLIGHTS ']").click();
		
       //change set to list
	
       Set<String> windowHandles = driver.getWindowHandles();
	
       List<String> listHandles=new ArrayList<String>(windowHandles);
       
       driver.switchTo().window(listHandles.get(1));
       
     //Take the screenshot of the second window(FLIGHTS)
	
	  File Target = driver.getScreenshotAs(OutputType.FILE);
	
	  File Source = new File("./Snaps.flight.png");
	
	  FileUtils.copyFile(Source, Target);
	
	 //Close the Fisrt Window alone
	
	  driver.switchTo().window(listHandles.get(0));
	
	driver.close();
	
	}

}

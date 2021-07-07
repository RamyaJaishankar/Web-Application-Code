package week4.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNowAss {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		   ChromeDriver driver=new ChromeDriver();
		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		   driver.get("https://dev103117.service-now.com");
		   
//			Step2: Enter username as “admin”
		   
		    driver.switchTo().frame(0);
		    driver.findElementByXPath("//input[@id='user_name']").sendKeys("admin");
//			Step3: Enter password as “India@123”
			driver.findElementById("user_password").sendKeys("India@123");
	
//			Step4: Click Login
			driver.findElementById("sysverb_login").click();
			
			
//			Step5: Search “incident “ Filter Navigator
			driver.findElementByXPath("//input[@id='filter']").sendKeys("incident");

//			Step6: Click “All”
			driver.findElementByXPath("(//div[text()='All'])[2]").click();

//			Step7: Click New button
			driver.switchTo().frame(0);
			 driver.findElementByXPath("//button[@type='submit']").click();
			
//          Step8: Select a value for Caller and Enter value for short_description
			// driver.switchTo().frame("frame1");
			 Thread.sleep(2000);
			 driver.findElementByXPath("//input[@id='incident.short_description']").sendKeys("service now");
			driver.findElementByXPath("//input[@id='sys_display.incident.caller_id']").click();
			Thread.sleep(1000);
			driver.findElementByXPath("//td[text()='Jewel Agresta']").click();
			
//			Step9: Read the incident number and save it a variable
			
			 String incnum = driver.findElementByXPath("//input[@id='incident.number']").getText();
			System.out.println(incnum);
			 
//			Step10: Click on Submit button
			driver.findElementByXPath("//button[text()='Submit']").click();
			
//			Step 11: Search the same incident number in the next search screen as below
		    driver.findElementByXPath("//input[@id='9b6f7b592fa8701056edc886f699b6e1_text']").sendKeys(incnum);

//			Step12: Verify the incident is created successful

	
		    
	}

}

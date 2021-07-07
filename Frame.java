package week4.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/frame.html");
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	   //switch main window to frame
	    driver.switchTo().frame(0);
	    driver.findElementByXPath("//button[@id='Click']").click();
	    
	    //to get text
	     
	
	    //to come out from frame
	   driver.switchTo().defaultContent();
	
	   //switch to frame 2
	   driver.switchTo().frame(1);
	   driver.switchTo().frame("frame2");
	   driver.findElementByXPath("//button[@id='Click1']").click();
	   
	   //to get text
	   String text = driver.findElementByXPath("//button[text()='Hurray! You Clicked Me.']").getText();
	   System.out.println(text); 
	
	}

}

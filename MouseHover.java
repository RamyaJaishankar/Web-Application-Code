package week4.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHover {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/mouseOver.html#");
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	WebElement course = driver.findElementByLinkText("TestLeaf Courses");
	
	Actions mouseHover=new Actions(driver);
	
	mouseHover.moveToElement(course).perform();
	//driver.findElementByLinkText("Selenium").click();
	
	//mouse hover nd print all text
	String text1 = driver.findElementByLinkText("Selenium").getText();
	System.out.println(text1);	
	
	
	
	//Alert alert = driver.switchTo().alert();
	
	//alert.accept();
	
	
	}

}

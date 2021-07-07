package week4.Day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	   //select "Selenium" and "Loadrunner" from the multi select combo box using actions class
	    WebElement Item1= driver.findElementByXPath("(//option[text()='Selenium'])[6]");
	    WebElement Item2= driver.findElementByXPath("(//option[text()='Loadrunner'])[6]");
	
	   //actions class
	   
	    Actions builder=new Actions(driver);
	    builder.keyDown(Keys.CONTROL)//to press
	   .click(Item1)
	   .click(Item2)
	   .keyUp(Keys.CONTROL)//to release
	   .perform();
	}

}

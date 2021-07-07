package week4.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SimpleAlert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/Alert.html");
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	    //click the alert box
	    driver.findElementByXPath("//button[text()='Alert Box']").click();
	    
	   //switch ctrl from main window to alert
	    Alert alert = driver.switchTo().alert();
	    
	    //to get alert text
	    String simpleAlert = alert.getText();
	    System.out.println(simpleAlert);
	    
	    alert.accept();
	
	}

}

package week4.Day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragableAss {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/draggable/");
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    
	    Thread.sleep(2000);
	    WebElement source = driver.findElementByXPath("//div[@class='ui-widget-content ui-draggable ui-draggable-handle']");
	    Actions drop=new Actions(driver);
	    drop.dragAndDropBy(source, 100, 100).perform();
	
	}

}

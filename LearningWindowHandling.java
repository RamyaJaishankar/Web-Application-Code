package week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearningWindowHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/Window.html");
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	    //to get current window reference
	    String windowRefer = driver.getWindowHandle();
	    System.out.println("first window reference" +" "+ windowRefer );
	    
	    System.out.println("***************************");
	    
	    //by clicking home page, it will go to second window
	    driver.findElementById("home").click();
	    
	    
	    //to get both window ref
	    Set<String> windowHandles = driver.getWindowHandles();
	    for(String eachRef : windowHandles)
	    {
	    	System.out.println(eachRef);
	    }
	    
	    System.out.println("***************************");
	
	    //to get 2nd value from set
	    
	    //convert set to list
	    
	    List<String> listHandles=new ArrayList<String>(windowHandles);
	    String secondref = listHandles.get(1);
	    System.out.println(secondref);
	
	    //to give ctrl to 2nd window
	    driver.switchTo().window(secondref);
	    driver.findElementByXPath("(//img[@class='wp-categories-icon svg-image'])[4]").click();
	
	  //to get title of 2 nd window
	    String title = driver.getTitle();
	    System.out.println(title);
	    
	    //to close current window
	    driver.close();
	
	    driver.quit(); 
	
	
	}

}

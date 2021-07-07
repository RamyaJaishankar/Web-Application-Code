package week4.Day1;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NoOfRowsAss {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/table.html");
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    
	    Thread.sleep(2000);
	    
	    //to get count(rows)
	    List<WebElement> allRows = driver.findElementsByXPath("//table[@id='table_id']//tr");
	    int rowcounts=allRows.size();
	    System.out.println("The no of col" + " " +rowcounts);
	    
	  //to get count(column)
	    List<WebElement> allcol = driver.findElementsByXPath("//table[@id='table_id']//th");
	    int colcounts=allcol.size();
	    System.out.println("The no of col" + " " +colcounts);
	    
    //get progress value of lean to interacrt
	    
	   String text = driver.findElementByXPath("//table[@id='table_id']//tr[3]//td[2]").getText();
	   System.out.println("Progress Value" + " " +text);
	    
	   
	    //check the vital task for the least completed progress
	   driver.findElementByXPath("//table[@id='table_id']//tr[4]//input").click();
	    
	    
	    

	    

}}


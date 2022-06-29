package org.qed42.testscripts;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.Test;

public class AutomationTask {
	WebDriver driver;
	String expFlipText;
	WebDriverWait wait;
	String actAmazonText;
	

	
	@Test
	public void verifyGridTable() {
		System.setProperty("webdriver.chrome.driver", "../SeleniumTask/Drivers/chromedriver.exe");
	    driver=new ChromeDriver();
		driver.get(" https://generic-ui.com/demo");
		
		driver.findElement(By.xpath("//div[@class='gui-select-container']")).click();
		
		driver.findElement(By.xpath("//div[normalize-space(text())='100 Rows']")).click();
		
		List<WebElement> projectName=driver.findElements(By.xpath("//div[text()='Status']//following::div[text()='Active']//preceding::div[3]"));
		
		for (WebElement projectname : projectName) {
			System.out.println(projectname.getText());
		}
		

		
		List<WebElement> projectId=driver.findElements(By.xpath("//div[text()='Status']//following::div[text()='Active']//preceding::div[1]"));
		
		
		for (WebElement projectid : projectId) {
			System.out.println(projectid.getText());
		}
		
		/*
		 * List<WebElement> perentageList=driver.findElements(By.xpath(
		 * "//div[text()='Status']//following::div[text()='Active']//preceding::div[10]"
		 * )); System.out.println(perentageList);
		 * 
		 * for (WebElement projectPer : perentageList) {
		 * System.out.println(projectPer.getText()); }
		 */
		

		

 int noOfRecors=driver.findElements(By.xpath("//div[@class='gui-content']//div[contains(@id,'gui')]")).size();	
		System.out.println(noOfRecors);
	}
	
	
	
	@Test
	public void verifyFlipkartTest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "../SeleniumTask/Drivers/chromedriver.exe");
	    driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		
	 wait=new WebDriverWait(driver,30);
	 wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(@class,'QfC')]/button"))));
		driver.findElement(By.xpath("//div[contains(@class,'QfC')]/button")).click();
		
		driver.findElement(By.name("q")).sendKeys("APPLE iPhone 13 (Starlight, 256 GB)");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(3000);
		
		 wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[text()='APPLE iPhone 13 (Starlight, 256 GB)']//following::div[contains(@class,'WHN')]"))));
		
	    expFlipText=driver.findElement(By.xpath("//div[text()='APPLE iPhone 13 (Starlight, 256 GB)']//following::div[contains(@class,'WHN')]")).getText().replace(",", "");
	
	   String expFlipText2=expFlipText.substring(1, 6);
	    
	    int expFlipkartPrice=Integer.parseInt(expFlipText2);
	    
	    System.out.println("Expected Flipkart Price is :: " + expFlipkartPrice);
	 
	    //driver.close();
	    
	    driver.navigate().to("https://www.amazon.in/");
	    
	    driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Apple iPhone 13 (256GB) - Starlight");
	    
	    driver.findElement(By.id("nav-search-submit-text")).click();
	    
	    Thread.sleep(3000);
	    
	    actAmazonText=driver.findElement(By.xpath("//span[text()='Apple iPhone 13 (256GB) - Starlight']//following::span[@class='a-price-whole']")).getText().replace(",", "");
		
	    int actAmazonPrice=Integer.parseInt(actAmazonText);
	    System.out.println("Actual Text is :: " + actAmazonPrice);
	    
	    
	  
	    if(expFlipkartPrice<actAmazonPrice) {
	    	System.out.println("Price is Best in Flipkart");
	    }else if(actAmazonPrice<expFlipkartPrice) {
	    	System.out.println("Price is Best in Amazon");
	    }
	    
	    
	    
	    
	    
	}
	
	
	@AfterMethod
	public void afterMethod() {
		driver.close();
	}
	
	
	
	
	
	

}

package com.epam.ubswmapage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.fail;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WMATest {
  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();
  
  @Before 
     public void setUp()throws Exception{
	  driver = new FirefoxDriver();
	  baseUrl= "https://www.ubs.com/us/en/wealth/investing.html";
	  driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
  }
	  
	//  @SuppressWarnings("deprecation") 
  @Test
     public void testWmaPage() throws Exception{
	  driver.get(baseUrl);
	  driver.findElement(By.id("leftnav").linkText("Nontraditional investments")).click();
	  driver.findElement(By.id("leftnav").partialLinkText("Traditional investments")).click();
	  driver.findElement(By.id("leftnav").xpath("//*[@id='leftNav']/ul/li[3]/ul/li/a")).click();
	  driver.findElement(By.id("ui-id-1-button")).click();
	  driver.findElement(By.id("ui-id-9")).click();
	  
	  // Elmenti az eredeti window id-t.
	  String mainWinId = driver.getWindowHandle(); 
	  driver.findElement(By.id("rightfeature").partialLinkText("View FINRA")).click();
	  
	  // Mivel nyitott egy uj popup window-t,igy mar ketto is van. Ha az ujjal akarok dolgozni:
	  Set<String> setOfNewHandles = driver.getWindowHandles();
	  System.out.println("The two window handles are: "+setOfNewHandles);
	  setOfNewHandles.remove(mainWinId); //Kivesszuk a regit a Set-bol.
	  
	  // At tudunk kapcsolni az uj window-ra.
	  driver.switchTo().window(setOfNewHandles.toArray()[0].toString());
	  driver.findElement(By.partialLinkText("Continue to BrokerCheck")).click();
		
	  //Visszakapcsolunk
	  driver.switchTo().window(mainWinId);
	  driver.findElement(By.id("par_linklist_6aac").partialLinkText("Retirement planning")).click();
			  
  }
  
  @After	  
  public void tearDown() throws Exception {
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  } 
  
}

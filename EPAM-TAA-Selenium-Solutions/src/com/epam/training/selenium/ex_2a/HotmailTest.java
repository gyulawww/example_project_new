package com.epam.training.selenium.ex_2a;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HotmailTest {
	  private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @Before
	  public void setUp() throws Exception {
	    // driver = new FirefoxDriver();
	    System.setProperty("webdriver.chrome.driver", "web-drivers\\chromedriver.exe");
	    driver = new ChromeDriver(); 
	    baseUrl = "http://hotmail.com";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test
	  public void testHotmail() throws Exception {
	     driver.get(baseUrl);
   
	     driver.findElement(By.id("i0116")).clear();
	     driver.findElement(By.id("i0116")).sendKeys("gyulawww@hotmail.com");
	     driver.findElement(By.id("i0118")).clear();
	     driver.findElement(By.id("i0118")).sendKeys("Earth111");
	     driver.findElement(By.id("idSIButton9")).click();
	     
	     // Explicit wait example:
	     WebDriverWait wait = new WebDriverWait(driver, 10/*timeout in seconds*/);
	     wait.until(ExpectedConditions.elementToBeClickable(By.className("o365button")));
	     driver.findElement(By.id("_ariaId_43")).click();
	     	    
	     
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

	  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
}

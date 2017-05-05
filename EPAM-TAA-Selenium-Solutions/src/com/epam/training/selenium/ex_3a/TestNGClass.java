package com.epam.training.selenium.ex_3a;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.net.MalformedURLException;

public class TestNGClass
{
   public WebDriver driver;
   public String URL, Node;
   protected ThreadLocal<RemoteWebDriver> threadDriver = null;
   
   @Parameters("browser")
   @BeforeTest
   public void launchapp(String browser) throws MalformedURLException
   {
      String URL = "http://en.wikipedia.org";
      
      // Before running this you have to start the selenium-server-standalone.jar on your computer or on an
      // other one. Command prompt: java -jar selenium-server-standalone.jar 
      // This will printout on which port running the server. Usually port:4444.
      if (browser.equalsIgnoreCase("firefox"))
      {
         System.out.println(" Executing on FireFox");
         String Node = "http://localhost:4444/wd/hub";
         DesiredCapabilities cap = DesiredCapabilities.firefox();
         cap.setBrowserName("firefox");         
         driver = new RemoteWebDriver(new URL(Node), cap);
         
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         
         driver.navigate().to(URL);
         driver.manage().window().maximize();
      }
      else if (browser.equalsIgnoreCase("chrome"))
      {
    	 // Ezekkel problema volt.
         System.out.println(" Executing on CHROME");
         // System.setProperty("webdriver.chrome.driver", "web-drivers\\chromedriver.exe");
         DesiredCapabilities cap = DesiredCapabilities.chrome();
         cap.setBrowserName("chrome");
         String Node = "http://localhost:4444/wd/hub";
         driver = new RemoteWebDriver(new URL(Node), cap);
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         
         driver.navigate().to(URL);
         driver.manage().window().maximize();
      }
      else  if (browser.equalsIgnoreCase("ie"))
      {
         System.out.println(" Executing on IE");
         DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
         cap.setBrowserName("internet explorer");
         String Node = "http://localhost:4444/wd/hub";
         driver = new RemoteWebDriver(new URL(Node), cap);
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         
         driver.navigate().to(URL);
         driver.manage().window().maximize();
      }
      else
      {
         throw new IllegalArgumentException("The Browser Type is Undefined");
      }
   }
   
   @Test
   public void calculatepercent()
   {	    
	    driver.findElement(By.id("searchInput")).click();
	    driver.findElement(By.id("searchInput")).clear();
	    driver.findElement(By.id("searchInput")).sendKeys("Unit testing");
	    driver.findElement(By.id("searchButton")).click();
	    // Ha a megjeleno ablakban akarok meg klikkelni akkor annak ez a megoldasa
	    WebDriverWait wait = new WebDriverWait(driver, 5); 
	    wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Acceptance testing")));
	    driver.findElement(By.linkText("Acceptance testing")).click();	
	    
   }
   
   @AfterTest
   public void closeBrowser()
   {
      // driver.quit();
   }
}
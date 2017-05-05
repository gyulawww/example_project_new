package com.epam.training.selenium.ex_2a;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.Wait;

public class proba_wiki_search2 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
   // Chrome:
   // System.setProperty("webdriver.chrome.driver", "web-drivers\\chromedriver.exe");
   // driver = new ChromeDriver(); 
	  
	// Firefox:
	// Be kell másolni a geckodriver.exe-t ide C:\Users\Gyula_Szecsi\workspace\EPAM-TAA-Selenium-Solutions\web-drivers\geckodriver.exe
	// Plus a windows /Control panel/system variables-be is be kell tenni az elérési utat.	
  
	System.setProperty("webdriver.gecko.driver", "web-drivers\\geckodriver.exe");  
	DesiredCapabilities capabilities = DesiredCapabilities.firefox();
	capabilities.setCapability("marionette", true);
	WebDriver driver = new FirefoxDriver(capabilities);	
    baseUrl = "http://en.wikipedia.org";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testProbaSelenium() throws Exception {
    // ERROR: Caught exception [unknown command [open ]]
    String SearchFor = "Unit testing";
    // Nem találja a web elementet a geckodriver nélkül.
    driver.get(baseUrl+"/wiki/Main_Page");
    driver.findElement(By.id("searchInput")).click();
    driver.findElement(By.id("searchInput")).clear();
    driver.findElement(By.id("searchInput")).sendKeys(SearchFor);
    driver.findElement(By.id("searchButton")).click();
    
    WebDriverWait wait = new WebDriverWait(driver, 10/*timeout in seconds*/);
    wait.until(ExpectedConditions.elementToBeClickable(By.className("mw-search-results")));
  }

  @After
  public void tearDown() throws Exception {
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

package com.epam.training.selenium.ex_2d;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

public class WikiTestIE {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {	
	System.setProperty("webdriver.ie.driver", "web-drivers\\IEDriverServer.exe");
	driver = new InternetExplorerDriver();
    baseUrl = "http://en.wikipedia.org";
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  }

  @Test
  public void testWiki() throws Exception {
    // driver.get(baseUrl + "/wiki/Main_Page");
    driver.navigate().to(baseUrl + "/wiki/Main_Page");
    // Nem találja a web elementet.
    // I was able to solve the problem by lowering the the security level in
    // "Internet Options" in the Internet zone from "High" to "Medium-high" or "Medium" in all zones.
    // Plus enable(or disable) protected mode everywhere.
    driver.findElement(By.id("searchInput")).click();
    driver.findElement(By.id("searchInput")).clear();
    driver.findElement(By.id("searchInput")).sendKeys("Unit testing");
    driver.findElement(By.id("searchButton")).click();
    driver.findElement(By.linkText("Acceptance testing")).click();
    driver.findElement(By.linkText("Acceptance sampling")).click();
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
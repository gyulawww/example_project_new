package com.epam.training.selenium.ex_5a;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;


public class KanbanScam {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	//driver = new FirefoxDriver();
	System.setProperty("webdriver.chrome.driver", "web-drivers\\chromedriver.exe");
	driver = new ChromeDriver(); 
	    
    baseUrl = "https://kanbanflow.com";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testKanban() throws Exception {	  

	  	driver.get(baseUrl + "/");
	  	
	  	//Login
	    driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
	    driver.findElement(By.id("email")).clear();
	    driver.findElement(By.id("email")).sendKeys("andras.saradi@z-consulting.eu");
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys("MEG5kONZULTALOM");
	    driver.findElement(By.cssSelector("button.loginPage-loginButton")).click();
	    
	    //Create board
	    driver.findElement(By.id("boardList-current")).click();
	    driver.findElement(By.linkText("Create board")).click();
	    driver.findElement(By.id("createBoard-boardName")).clear();
	    driver.findElement(By.id("createBoard-boardName")).sendKeys("TestAcademy");
	    driver.findElement(By.xpath("//div[@id='createBoard']/div/div[2]/div[3]/button[2]")).click();
	    driver.findElement(By.id("btnCreate")).click();	    
	    
	    //Select TestAcademy board
	    driver.findElement(By.id("boardList-current")).click();
	    driver.findElement(By.xpath("//a[contains(text(),'TestAcademy')]")).click();	    
	    
	    //Add task
	    driver.findElement(By.cssSelector("div.columnHeader-addTask")).click();
	    driver.findElement(By.id("taskName")).clear();
	    driver.findElement(By.id("taskName")).sendKeys("Task");
	    driver.findElement(By.linkText("Dates")).click();
	    driver.findElement(By.xpath("//div[@id='taskDialog']/div[4]/div[2]/ul/li/input")).click();	    	    
	    Calendar calendar = Calendar.getInstance();	    
	    driver.findElement(By.linkText( Integer.toBinaryString(calendar.get(Calendar.DAY_OF_MONTH)) )).click();	    
	    driver.findElement(By.cssSelector("input.taskDialog-dueDateTime")).clear();
	    String due = new StringBuilder().append( calendar.get(Calendar.HOUR_OF_DAY) ).append(":").append( calendar.get(Calendar.MINUTE)+1 ).toString();
	    driver.findElement(By.cssSelector("input.taskDialog-dueDateTime")).sendKeys(due);
	    driver.findElement(By.cssSelector("button.taskDialog-dueDateAddButton.btn")).click();
	    driver.findElement(By.cssSelector("button.taskDialog-saveCloseButton.button")).click();	    
	    
	    //Move task to In progress column
	    WebElement task = driver.findElement(By.cssSelector("div.task"));
	    WebElement column = driver.findElement(By.xpath("//table[@id='board-table']/tbody/tr[1]/td[2*(count(//table[@id='board-table']/thead/tr/th/div/h2[@title='In progress']/../../preceding-sibling::th)+1)]/div"));	    
	    new Actions(driver).dragAndDrop(task, column).perform();
	    	    
	    //Move expired task automatically to the Done column
	    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
	            .withTimeout(300, TimeUnit.SECONDS)
	            .pollingEvery(15, TimeUnit.SECONDS)
	            .ignoring(NoSuchElementException.class);
	    
	    WebElement passedTask = wait.until(new Function<WebDriver, 	WebElement>() {
	           public WebElement apply(WebDriver driver) {
	        	   driver.navigate().refresh();
	               return driver.findElement(By.xpath("//li[@class='task-dueDatePassed']/../.."));
	           }
	       });	    
	    	    
	    
	    WebElement doneColumn = driver.findElement(By.xpath("//table[@id='board-table']/tbody/tr[1]/td[2*(count(//table[@id='board-table']/thead/tr/th/div/h2[@title='Done']/../../preceding-sibling::th)+1)]/div/div"));
	    
	    new Actions(driver).dragAndDrop(passedTask, doneColumn).perform();
	    
	    wait.until(new Function<WebDriver, 	WebElement>() {
	           public WebElement apply(WebDriver driver) {	        	   
	               return driver.findElement(By.xpath("//table[@id='board-table']/tbody/tr[1]/td[2*(count(//table[@id='board-table']/thead/tr/th/div/h2[@title='Done']/../../preceding-sibling::th)+1)]/div/div/div/div"));
	           }
	    });
	    	    
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
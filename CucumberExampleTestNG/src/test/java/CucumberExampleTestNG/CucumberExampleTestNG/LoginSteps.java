package CucumberExampleTestNG.CucumberExampleTestNG;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class LoginSteps {
	private static WebDriver driver = null;
	
	@Given("^user is on Home Page '(.+)'$")
	public void user_is_on_homepage(final String homePage )throws Throwable {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(homePage);
	}
	
	@When("^User Navigate to LogIn Page$")
	public void user_navigate_to_login_page()throws Throwable {
		driver.findElement(By.xpath(".//*[@id='account']/a")).click();
	}
	
	@And("^User enters UserName '(.+)' and Password$")
	public void user_login_to_the_page(final String login)throws Throwable {
		driver.findElement(By.id("log")).sendKeys(login);
		driver.findElement(By.id("pwd")).sendKeys("Earth(111)");
		driver.findElement(By.id("login")).click();
		// Waiting the page after login:
		WebDriverWait wait = new WebDriverWait(driver, 30 /*timeout in seconds*/);
	   //  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='account_logout']/a")));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("menu-item-54")));
	}
	
	@Then("^Message displayed Login Successfully$")
	public void user_login_was_successful()throws Throwable {
		 System.out.println("Login Successfully");
	}
	
	@When("^User navigate to Sample Page$")
	public void user_navigate_to_sample_page()throws Throwable {
		driver.findElement(By.id("menu-item-54")).click();
		Cookie cookie = new Cookie("key1", "value1");
		driver.manage().addCookie(cookie); 
	}
	
	@Then("^Navigate to back$") 
	public void user_navigate_back()throws Throwable {
		driver.navigate().back();
		Cookie cookie2 = driver.manage().getCookieNamed("key1");
		System.out.println("The cookie: "+cookie2);
	}
	
	@When ("^User LogOut from the Application$")
	public void user_logout()throws Throwable {
		driver.findElement (By.xpath(".//*[@id='account_logout']/a")).click();
	}
	
	@Then ("^Message displayed LogOut Successfully$")
	public void user_logout_was_successful()throws Throwable {
		System.out.println("LogOut Successfully");
		driver.quit();
	}
	
}

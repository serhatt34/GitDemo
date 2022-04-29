package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		
	}
	
	
	By email = By.id("user_email");
	
	public WebElement emailInput() {
		
		return driver.findElement(email);
		
	}
	
	By password = By.xpath("//input[@type='password']");
	
	public WebElement passwordInput() {
		
		return driver.findElement(password);
	}
	
	By login = By.cssSelector("input[value='Log In']");
	
	public WebElement loginClick() {
		
		return driver.findElement(login);
	}
	
	
	
	
}

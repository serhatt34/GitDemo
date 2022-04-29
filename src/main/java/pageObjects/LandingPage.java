package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage 
{
	public WebDriver driver;
	

	public LandingPage(WebDriver driver) {//constructor for HomePage--->basePageNavigation-->landingpage
		this.driver=driver;
		}
	
	By signin = By.cssSelector("a[href='https://rahulshettyacademy.com/sign_in/']");//page object for login button
	
	public  WebElement loginButton()                      // page object completed
	{
                                              		
		return driver.findElement(signin);                        
		                                  
	} 
	
	By checktext = By.xpath("//div[@class='text-center']/h2");  
	
	public WebElement getTxt () {         //it's for comparing the text in the browser with expected text
		
		return driver.findElement(checktext);
	}
	
	By navBar = By.xpath("//ul[@class='nav navbar-nav navbar-right']/li"); 
	
	public WebElement navibar() {        //it's for checking whether the navigation bar  is thoroughly exist or not.
		
		return driver.findElement(navBar);
	}
	
	
	
	
}
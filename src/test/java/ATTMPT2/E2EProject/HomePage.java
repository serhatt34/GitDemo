package ATTMPT2.E2EProject;

import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base {
	public static Logger log =LogManager.getLogger(Base.class.getName());

   public WebDriver driver;	
	
    @BeforeMethod
    public void startWith() throws IOException {
    	
    	driver = baslatdriver();
		driver.get(prop.getProperty("url"));
    	
    }
    
    @Test(dataProvider ="getData")
	
	public void basePageNavigation(String email, String password) throws IOException {
    	driver.findElement(By.xpath("//div[@class='sumome-react-wysiwyg-move-handle']/div/button[text()='NO THANKS']")).click();
		LandingPage land = new LandingPage(driver);//it's constructed in LandingPage
		land.loginButton().click();
		LoginPage lp = new LoginPage(driver);
		lp.emailInput().sendKeys(email);            //email from dataProvider
		lp.passwordInput().sendKeys(password);      //  password from dataProvider
		lp.loginClick().click();
	}
	
	@DataProvider                          //creating DataProvider for email and password with 2 instances[1][1]. 
	public Object[][] getData() {
		
		Object[][] data = new Object[2][2];
		data[0][0]="serhat_coskuner@hotmail.com";
		data[0][1]="1234567";
		data[1][0]="selenium_dataprovider@hotmail.com";
		data[1][1]="1234567890";
		return data;
	}
	
	@AfterMethod
	public void closeBrowserVal() {
		
		driver.close();
	}
	
}
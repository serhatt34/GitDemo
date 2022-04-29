package ATTMPT2.E2EProject;

import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pageObjects.LandingPage;
import resources.Base;

public class ValidateNavigationBar extends resources.Base {
	public static Logger log =LogManager.getLogger(Base.class.getName());

   public WebDriver driver;	
	
    @BeforeTest
    public void startWith() throws IOException {
    	
    	driver = baslatdriver();
		driver.get(prop.getProperty("url"));
    }
  
    
    @Test
	
	public void validateNavBar() throws IOException {
    	driver.findElement(By.xpath("//div[@class='sumome-react-wysiwyg-move-handle']/div/button[text()='NO THANKS']")).click();//close the offer.
		LandingPage land = new LandingPage(driver);//it's constructed in LandingPage
		Assert.assertTrue(land.navibar().isDisplayed());    //validate the navigation bar is precisely exist.
	    log.info("navigation bar is displayed");
    
	}
    
	@AfterTest
	public void closeBrowserVal() {
		
		driver.close();
	}
    
	}
	
	

  

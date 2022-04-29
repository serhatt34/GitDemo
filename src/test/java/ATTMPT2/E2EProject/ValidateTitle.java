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

public class ValidateTitle extends resources.Base {
	public WebDriver driver;

	public static Logger log = LogManager.getLogger(Base.class.getName());
	
    @BeforeTest
    public void startWith() throws IOException {
    	
    	driver = baslatdriver();
    	log.info("driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("navigated to homepage");
    }
  
    
    @Test
	
	public void validateTİtle() throws IOException {
    	driver.findElement(By.xpath("//div[@class='sumome-react-wysiwyg-move-handle']/div/button[text()='NO THANKS']")).click();//close the offer.
		LandingPage land = new LandingPage(driver);//it's constructed in LandingPage
		//compare the text from LandingPage with expected text
	    Assert.assertEquals(land.getTxt().getText(), "FEATURED COURSES123");//checking the actual text is same as expected and it's failed deliberately to take screenshot using listeners. it's also used in extent reports.    
	    log.info("successfully validated text message");
	}
	@AfterTest
	public void closeBrowserVal() {
		
		driver.close();
	}
    
	}
	
	

  

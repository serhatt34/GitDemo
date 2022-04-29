package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	 public  WebDriver driver;
	 public Properties prop;
	public WebDriver baslatdriver() throws IOException {
		
		prop = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\serhat\\eclipse-workspace\\E2EProject\\src\\main\\java\\resources\\data.prop");
		prop.load(file);
		String selectedBrowser= prop.getProperty("browser");
		
		
		if (selectedBrowser.equals("chrome") ) {
//invoke chrome
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\serhat\\Desktop\\chromedriver_win32//chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else if (selectedBrowser.equals("firefox")) {
//invoke firefox
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\serhat\\Desktop\\geckodriver-v0.30.0-win64//geckodriver.exe");
			driver = new FirefoxDriver();
           }
		
		else if (selectedBrowser.equals("edge")) {
//invoke edge
			System.setProperty("webdriver.edge.driver", "C:\\Users\\serhat\\Desktop\\edgedriver_win64//msedgedriver.exe");
			driver=new EdgeDriver();
			}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}
		
	
	public void getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {    //specifying the path for taken fail screenshots by listeners. 
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationFile= System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
		FileUtils.copyFile(src, new File(destinationFile));
	




}
	
	
}


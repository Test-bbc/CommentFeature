/*class to implement generic functions available to test steps*/
package genericActions;
import java.io.File;
import java.util.concurrent.TimeUnit;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import fileReaders.ConfigFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GenaricActionMethods {
	WebDriver driver;
	ConfigFileReader configfilereader;
	String decryptedPassword;

	public GenaricActionMethods(WebDriver driver) {
		this.driver= driver;
	}

	/*WebDriver wait until the element ready to click*/
	public void waitToclick(WebElement element) {
		try {
			WebDriverWait wait= new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		catch (Exception e) {e.printStackTrace();}
	}

	/*WebDriver wait until the element is displayed*/
	public void waitToDisplayElement(WebElement element) {
		try {
			WebDriverWait wait= new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		catch (Exception e) {e.printStackTrace();}
	}

	/*Method to initialise and launch browser*/
	/*can be done generic for other browsers*/
	public WebDriver browserStart() {
		configfilereader = new ConfigFileReader();
		try {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(configfilereader.getImplicitWait(), TimeUnit.SECONDS);
		}
		catch (Exception e) {e.printStackTrace();}
		return driver;
	}

	/*Method to capture screenshot*/
	public void getscreenshot() throws Exception 
	{		
		try {
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(configfilereader.getScreenshotPath()+""+System.currentTimeMillis()+".png"));
		}
		catch(Exception e) {e.printStackTrace();}
	}

	/*Password decryption using Base64, passwords are encrypted*/
	public String decryptPassword() {
		try {
			configfilereader = new ConfigFileReader();
			byte[] decodedBytes = Base64.decodeBase64(configfilereader.getPassword());
			decryptedPassword= new String(decodedBytes);
		}
		catch(Exception e) {e.printStackTrace();}
		return decryptedPassword;
	}

	/*comparing user account name with username for successful sign in*/
	public boolean verifySignInSuccessful(WebElement element,String username) {
		try {
			String displayedAccountName = element.getText();
			if(!displayedAccountName.equals(username)) {
				return false; 
			}
		}
		catch(Exception e) {e.printStackTrace();}
		return true; 
	}

	/*closing browser*/
	public void closeBrowser() {
		try {
			driver.quit();
		}
		catch(Exception e) {e.printStackTrace();}
	}
}

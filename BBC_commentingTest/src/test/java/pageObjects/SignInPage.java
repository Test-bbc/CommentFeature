/*pageObject class for Sign In page using pageFactory*/
package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
	WebDriver driver;
	
  	public SignInPage(WebDriver driver) {
		this.driver = driver;
	    PageFactory.initElements(driver, this);
  		}
  	
	@FindBy(xpath = ".//input[@type='email']")
	public WebElement El_Email;	
	@FindBy(xpath = ".//input[@type='password']")
	public WebElement El_Password;	
	@FindBy(xpath = ".//button[@type='submit']")
	public WebElement El_SignIn;	

}

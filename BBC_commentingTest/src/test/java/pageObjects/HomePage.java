/*pageObject class for Home page using pageFactory*/
package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = ".//button[text()='Yes, I agree']")
	public WebElement El_Accept_Cookies;
	@FindBy(xpath = ".//span[text()='Sport']")
	public WebElement El_Sports_Menu;	

}


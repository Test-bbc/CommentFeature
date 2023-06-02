/*pageObject class for sports page using pageFactory*/
package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class SportsPage {
WebDriver driver;
	
  	public SportsPage(WebDriver driver) {
		this.driver = driver;
	    PageFactory.initElements(driver, this);
  		}
  	
	@FindBy(xpath = ".//span[text()='Sign in']/parent::a")
	public WebElement El_SignInBtn;	
	@FindBy(xpath = ".//span[contains(@data-testid,'comments')]/..")
	public WebElement El_Comment_Icon;	
	@FindBy(xpath = ".//button[@class='view-comments-button']")
	public WebElement El_viewComments_btn;
	@FindBy(xpath = ".//span[@class='comments-icon']")
	public WebElement El_commentIcon_article;
	@FindBy(xpath = ".//span[contains(@data-testid,'comments')]//ancestor::div[@type='article']//a[contains(@class,'PromoLink')]")
	public WebElement El_articleWithComments;	
	@FindBy(xpath = ".//div[@class='comments__user-interactions-container']//textarea[@class='comments-input-box']")
	public WebElement El_addYourComment;
	@FindBy(xpath = ".//p[@class='comments__signin--prompt']/..//a[text()='Sign in'][@data-bbc-title='id-cta-sign-in']")
	public WebElement El_signInBtn_Comment;
	@FindBy(xpath = ".//p[@class='comments__signin--prompt']/..//a[text()='Register'][@data-bbc-title='id-cta-registration']")
	public WebElement El_registerBtn_Comment;
	@FindBy(xpath = ".//span[contains(@class,'ssrcss-qgttmg-AccountText')]")
	public WebElement El_UserAccountName;
}

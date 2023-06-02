package stepDefinitions;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fileReaders.ConfigFileReader;
import genericActions.GenaricActionMethods;
import pageObjects.HomePage;
import pageObjects.SignInPage;
import pageObjects.SportsPage;

public class CommentingFeatureTestSteps {
	/*A class for Step definition for each feature and scenarios,*
	 *WebElements are interacted through pageObject classes */
	public WebDriver driver;
	ConfigFileReader configfilereader;
	GenaricActionMethods genericactionmethod;
	HomePage homepage;
	SportsPage sportspage;
	SignInPage signinpage;
	List<WebElement> commentIcon;

	/*Browser initialising and launching home page*/
	@Given("^user is on Home Page$")
	public void user_is_on_Home_Page() throws Exception {
		configfilereader = new ConfigFileReader();
		genericactionmethod=new GenaricActionMethods(driver);
		try {
			driver=genericactionmethod.browserStart();
			driver.get(configfilereader.getUrl());
		}
		catch(Exception e) {e.printStackTrace();Assert.assertTrue(false);
		genericactionmethod.getscreenshot();}
	}

	/*Navigate to sports page*/
	@When("he navigate to sports page")
	public void he_navigateTo_sports() throws Exception  {
		try {
			homepage = new HomePage(driver);
			if(homepage.El_Accept_Cookies.isDisplayed()) {
				homepage.El_Accept_Cookies.click();
			}
			genericactionmethod.waitToclick(homepage.El_Sports_Menu);
			homepage.El_Sports_Menu.click();
		}
		catch(Exception e) {e.printStackTrace(); genericactionmethod.getscreenshot();
		Assert.assertTrue(false);}
	}

	/*verifying commenting is enabled for articles*/
	@Then("^verify few article has comment section enabled by validating comment icon$")
	public void verify_commentIcon_in_articles() throws Exception {
		try {
			sportspage = new SportsPage(driver);
			genericactionmethod.waitToDisplayElement(sportspage.El_Comment_Icon);
			commentIcon = sportspage.El_Comment_Icon.findElements(By.xpath("./span"));
			if(commentIcon.size()<=0) {
				Assert.assertTrue("comment icons are not displayed for any articles", false);
			}
			Assert.assertTrue("comment icons are displayed for "+ " articles", true);
		}
		catch(Exception e) {e.printStackTrace(); 
		genericactionmethod.getscreenshot();Assert.assertTrue(false);}
	}	

	/*open articles with commenting enabled*/
	@And("^click on an article with comment enabled$")
	public void click_on_articleCommentEnabled() throws Exception {
		try {
			sportspage = new SportsPage(driver);
			genericactionmethod.waitToclick(sportspage.El_articleWithComments);
			sportspage.El_articleWithComments.click();
		}
		catch(Exception e) {e.printStackTrace();genericactionmethod.getscreenshot();
		Assert.assertTrue(false);}
	}

	/*click on view comments menu*/
	@And("^click on view comments menu in article$")
	public void click_on_viewComments() throws Exception {
		try {
			sportspage = new SportsPage(driver);
			genericactionmethod.waitToclick(sportspage.El_commentIcon_article);
			sportspage.El_commentIcon_article.click();
			genericactionmethod.waitToclick(sportspage.El_viewComments_btn);
			sportspage.El_viewComments_btn.click();
		}
		catch(Exception e) {e.printStackTrace();genericactionmethod.getscreenshot();
		Assert.assertTrue(false);}
	}

	/*Verifying user without signed in has comment disabled*/
	@Then("^verify that user is not abled to comment in article without sign$")
	public void verify_commentSection_notDisplayed() throws Exception {
		try {
			sportspage = new SportsPage(driver);
			if(!sportspage.El_addYourComment.isEnabled()) {
				Assert.assertTrue("comment section is disabled",true);		
			}
			else {Assert.assertFalse(true);genericactionmethod.getscreenshot(); }
		}
		catch(Exception e) {}
	}

	/*verifying sign in and register option is available*/
	@Then("^verify comment section has options for Sign in and Register$")
	public void verify_signIn_register_optionsDisplayed() throws Exception {
		try {
			sportspage = new SportsPage(driver);
			genericactionmethod.waitToDisplayElement(sportspage.El_signInBtn_Comment);
			Assert.assertTrue("Sign in button is displayed in comment section",
					sportspage.El_signInBtn_Comment.isDisplayed());
			Assert.assertTrue("Register button is displayed in comment section",
					sportspage.El_registerBtn_Comment.isDisplayed());
		}
		catch(Exception e) {e.printStackTrace();genericactionmethod.getscreenshot();
		Assert.assertTrue(false);}
	}

	/*user click on sign in menu in sports page*/
	@And("^user click on sign in menu on header bar$")
	public void click_on_signIn() throws Exception {
		try {
			sportspage = new SportsPage(driver);
			genericactionmethod.waitToclick(sportspage.El_SignInBtn);
			sportspage.El_SignInBtn.click();
		}
		catch(Exception e) {e.printStackTrace();genericactionmethod.getscreenshot();
		Assert.assertTrue(false);}
	}

	/*Input data are reading from config file and encrypted values are decrypted using methods available in generic class*/
	@When("^user enter credentials and submit$")
	public void user_signInToApp() throws Exception {
		try {
			signinpage = new SignInPage(driver);
			genericactionmethod.waitToclick(signinpage.El_SignIn);
			signinpage.El_Email.sendKeys(configfilereader.getEmail());
			signinpage.El_Password.sendKeys(genericactionmethod.decryptPassword());
			signinpage.El_SignIn.click();
		}
		catch(Exception e) {e.printStackTrace();genericactionmethod.getscreenshot();
		Assert.assertTrue(false);}
	}

	/*verifying user sign in is successful*/
	@Then("^verify user is signed in successfully$")
	public void verify_user_signedIn() throws Exception {
		try {
			sportspage = new SportsPage(driver);
			genericactionmethod.waitToDisplayElement(sportspage.El_UserAccountName);
			Assert.assertTrue("User signed in successfully",genericactionmethod.verifySignInSuccessful(sportspage.El_UserAccountName,configfilereader.getUserName()));
		}
		catch(Exception e) {e.printStackTrace();genericactionmethod.getscreenshot();
		Assert.assertTrue(false);}
	}

	/*verifying sign in or register buttons are not available*/
	@Then("^verify sign in or register button is not displayed in comment section$")
	public void verify_signIn_register_optionsNotDisplayed() throws Exception {
		try {
			sportspage = new SportsPage(driver);
			if(!(sportspage.El_signInBtn_Comment.isDisplayed())) {
				Assert.assertTrue("sign in option is not displayed",true);
			}
			else {
				Assert.assertFalse("Sign in option is visible in add comment section", true);
				genericactionmethod.getscreenshot();
			}
			if(!(sportspage.El_registerBtn_Comment.isDisplayed())) {
				Assert.assertTrue("Register option is not displayed",true);
			}
			else {
				Assert.assertFalse("Register option is visible in add comment section", true);
				genericactionmethod.getscreenshot();
			}
		}
		catch(Exception e) {}
	}

	/*verifying the functionality, signed in user can comment in articles*/
	@Then("^verify signed in user can add comments$")
	public void verify_commentSectionIsDisplayed() throws Exception {
		try {
			sportspage = new SportsPage(driver);
			genericactionmethod.waitToDisplayElement(sportspage.El_addYourComment);
			Assert.assertTrue("User is able to add comments",sportspage.El_addYourComment.isEnabled());
			sportspage.El_addYourComment.sendKeys(configfilereader.getInputText());
		}
		catch(Exception e) {genericactionmethod.getscreenshot();Assert.assertTrue(false);}
	}

	/*method to close browser and terminating test*/
	@After
	public void terminatingTest() throws Exception {
		try {
			genericactionmethod.closeBrowser();
		}
		catch(Exception e) {e.printStackTrace();genericactionmethod.getscreenshot();
		Assert.assertTrue(false);}
	}

}

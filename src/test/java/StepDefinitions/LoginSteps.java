package StepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.Assert;

import Managers.FileReaderManager;
import PageObjects.LoginPage;
import Utilities.TestContext;

import java.util.List;
import java.util.Map;

public class LoginSteps {

    TestContext testContext;
    LoginPage loginPage;
    WebDriver webDriver;
    public LoginSteps(TestContext context) {
        testContext = context;
        loginPage = testContext.getPageObjectManager().getLoginPage();
    }
    
    @Before
    public void setUp() {
        webDriver = testContext.getDriverManager().getDriver();
        webDriver.get(FileReaderManager.getInstance().getConfigFileReader().getUrl());
    }

    @After
    public void tearDown(Scenario scenario) {

        if(scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot)testContext.getDriverManager().getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "screenshot");
            } catch (WebDriverException noSupportScreenshot) {
                System.err.println(noSupportScreenshot.getMessage());
            }
        }
        testContext.getDriverManager().closeDriver();
    }

    @When("user enters {string} and {string}")
    public void user_enters_username_and_Password(String user_name, String pass_word) {
       loginPage.enterUsername(user_name);
       loginPage.enterPassword(pass_word);
    }
    

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
       loginPage.waitForHumanVerify();
       loginPage.clickLogin();
    }
    
    @When("user is on home page")
	 public void user_is_on_hopme_page(){
	
		 Assert.assertTrue(loginPage.verifyHomePage());
	 }
    @When("user gets error message")
	 public void user_gets_error_message(){
	
		 Assert.assertTrue(loginPage.verifyerror());
	 }
    
    @When("user click on change password")
	 public void user_click_on_change_password(){
	loginPage.clickChangePassword();
		 
	 }
    
    @When("user enters new {string} and {string}")
	 public void user_enters_new_newpassword_and_oldpassword(String new_password, String old_Password){
	
		 loginPage.enterNewPassword(old_Password, new_password);
		 
	 }
    
    @When("user logouts and login")
	 public void user_logouts_and_login(){
	
		 loginPage.logout();
		 loginPage.login();
		 
	 }

}

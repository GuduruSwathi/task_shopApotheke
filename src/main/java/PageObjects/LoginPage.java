package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.Wait;

public class LoginPage {
	private final WebDriver webDriver;
	
    public LoginPage(WebDriver webDriver) {
    	 this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//input[@type='email']")
	WebElement username;

	@FindBy(xpath="//input[@type='password']")
	WebElement password;
	
	@FindBy(xpath="//button[@name='loginForm-submit-button']")
	WebElement Login;
	
	@FindBy(xpath="//h3[contains(text(),'Hallo')]")
	WebElement logo;
	
	@FindBy(xpath="//li/a[contains(@href,'change-password')]")
	WebElement changepassword;
	
	@FindBy(xpath="//label[contains(text(),'Aktuelles')]/../input")
	WebElement txt_oldpassword;
	
	@FindBy(xpath="//label[contains(text(),'Neues Passwort *')]/../input")
	WebElement txt_newpassword1;
	
	@FindBy(xpath="//label[contains(text(),'wiederholen *')]/../input")
	WebElement txt_newpassword2;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement btn_submit;
	
	@FindBy(xpath="//a[contains(@href,'login')]")
	WebElement icon;
	
	@FindBy(xpath="//a[contains(@id,'logout')]")
	WebElement logout;
	
	@FindBy(xpath="//a[contains(@name,'Login')]")
	WebElement login;
	
	
	String error1="//div[contains(text(),'falsch')]";
//	WebElement error1;
	
	String error2="(//p[contains(text(),'Please')])[1]";
	
	
	//div[contains(text(),'falsch')]
//	String humanIcon="//span[text()='Ich bin ein Mensch']";
     @FindBy(xpath = "//span[text()='Ich bin ein Mensch']")
     WebElement humanIcon;
	
	public void enterUsername(String user_name){
		username.sendKeys(user_name);
	}
	
	public void enterPassword(String pass_word){
		password.sendKeys(pass_word);
	}
	
		
	public void clickLogin() {
//		JavascriptExecutor js = (JavascriptExecutor)driver;	
//		 js.executeScript("arguments[0].click();", Login);
		Login.click();
	}
	
	public void waitForHumanVerify() {
//		WebDriverWait wait=new WebDriverWait(driver, 200);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(humanIcon)));
		Wait.untilElementIsVisible(webDriver, humanIcon, 300);

	}
	public boolean verifyHomePage() {
		boolean flag=false;
		if(logo.isDisplayed()) {
			flag=true;
		}
		return flag;
	}
	
	public boolean verifyerror() {
		boolean flag=false;
		int i=webDriver.findElements(By.xpath(error1)).size();
		int j=webDriver.findElements(By.xpath(error2)).size();
		
		if(i>0 || j>0) {
			flag=true;
		}
		return flag;
	}
	
	public void clickChangePassword() {
		changepassword.click();
	}
	
	public void enterNewPassword(String old_password, String new_Password) {
		txt_oldpassword.sendKeys(old_password);
		txt_newpassword1.sendKeys(new_Password);
		txt_newpassword2.sendKeys(new_Password);
		btn_submit.click();
	}
	
	public void logout() {
		Actions act = new Actions(webDriver);

	     act.moveToElement(icon).build().perform();
//		icon.click();
		logout.click();
	}
	
	public void login() {
//		icon.click();

		Actions act = new Actions(webDriver);

	     act.moveToElement(icon).build().perform();
		login.click();
	}
}

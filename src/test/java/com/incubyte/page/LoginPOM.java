package com.incubyte.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.incubyte.utility.CommonLibraries;

public class LoginPOM {
private WebDriver driver; 
	
  	CommonLibraries common = new CommonLibraries();
	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath="//span[contains(text(),'Sign in')]")
	public WebElement signInLink; 
	
	@FindBy(id="login-username")
	public WebElement userName; 
	
	
	@FindBy(id="login-passwd")
	WebElement password; 
	
	@FindBy(id="login-signin")
	WebElement nextBtn;
	
	
	@FindBy(id="header-profile-button")
	WebElement loginSuccess;
	
	@FindBy(xpath="//div[@class='login-box right']")
	WebElement loginBox;
	
	
	
	@FindBy(xpath="//img[@class='logo ']")
	WebElement homePageLogo;
	
	@FindBy(xpath="//img[@class='logo yahoo-en-US']")
	WebElement yahooSignInBoxLogo;
	
	
	@FindBy(xpath="//strong[@class='challenge-heading']")
	WebElement signInHeading;
	
	@FindBy(xpath="//button[contains(@class,'show-hide-toggle')]")
	WebElement showHideButton;
	
	
	
	public void sendUserName(String userName) {
		common.enterText(this.userName, userName, "login user name");
	}
	
	public void sendPassword(String password) {
		common.enterText(this.password, password, "login user password");
	}
	
	public void clickLoginBtn() {
		common.clickElement(this.nextBtn, "next button");
	}
	
	public void clickSignIn()
	{
		System.out.println(driver);
		common.clickElement(signInLink, "Sing in link");
	}
	public void userLogin(String userName, String password) {
		this.sendUserName(userName);
		this.clickLoginBtn();
		this.sendPassword(password);
		this.clickLoginBtn();
	}
}

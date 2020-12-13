package com.incubyte.gmailAutomation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.incubyte.page.ComposePOM;
import com.incubyte.page.LoginPOM;


import io.github.bonigarcia.wdm.WebDriverManager;


public class YahooAutomationRunner {
	public static WebDriver driver; 
	private static String baseUrl; 
	private static String userName;
	private static String password;	
	private static Properties properties;
	
	
	@BeforeSuite
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		System.out.println("test case execution started");
		WebDriverManager.chromedriver().setup();
		//driver = new ChromeDriver();
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setBinary("Binary path of the Chrome");
		baseUrl = properties.getProperty("baseURL");
		userName = properties.getProperty("userName");
		password = properties.getProperty("password");
		
	}

	
	@BeforeMethod
	public void UrlSetUp(){
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get(baseUrl);
		driver.manage().window().maximize();
		System.out.println("URL : "+baseUrl+" successfully launched");
		LoginPOM yahoo = new LoginPOM(driver);
		yahoo.clickSignIn();
		yahoo.userLogin(userName, password);
		System.out.println("Logged in successfully");
	}
	
	@Test(description="Compose mail and validate all icon on copmpose mail window",priority=1,enabled = true)
	public void composeMainAndSend() throws InterruptedException{
		ComposePOM compose = new ComposePOM(driver);
		String path = System.getProperty("user.dir")+properties.getProperty("attachmentPath");
		compose.clickComposeBtn();
		compose.verifyAllIcon();
		compose.verifyCC_BCCOptions();
		compose.verifyNoReciepientAlert();
		compose.verifyInvalidReciepientAlert();
		compose.enterReciepient();
		compose.verifyNoSubjectPopUp();
		compose.enterSubject();
		compose.verifyBoldItalicText();
		compose.verifyAttachmentsOptions();
		compose.enterMessage();
		compose.sendEmail();
		compose.verifyInSentItems();
		
	}
	
	@Test(description="Valiate Discard and delete mail functionility",priority=2,enabled = true)
	public void discardMail() throws InterruptedException{
		ComposePOM compose = new ComposePOM(driver);
		String path = System.getProperty("user.dir")+properties.getProperty("attachmentPath");
		compose.clickComposeBtn();
		compose.enterReciepient();
		compose.enterSubject();
		compose.enterMessage();
		compose.attachFromComputer(path);
		compose.discardMail();
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}

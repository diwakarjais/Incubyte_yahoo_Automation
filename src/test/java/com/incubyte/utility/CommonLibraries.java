package com.incubyte.utility;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.incubyte.gmailAutomation.YahooAutomationRunner;

import junit.framework.Assert;

public class CommonLibraries{
	public WebDriver driver = YahooAutomationRunner.driver;
	
	public WebElement waitUntilElementVisible(WebElement ele, int time)
	{
		WebDriverWait wait = new WebDriverWait(driver, time);
		WebElement element =null;
		try{
			element=wait.until(ExpectedConditions.visibilityOf(ele));
		}
		catch(Exception e)
		{
			System.out.println("Failed in waitUntilElementVisible() method due to : "+e.getMessage());
		}
		return element;
	}
	
	public WebElement waitUntilElementClickable(WebElement ele, int time)
	{
		WebDriverWait wait = new WebDriverWait(driver, time);
		WebElement element =null;
		try{
			element=wait.until(ExpectedConditions.elementToBeClickable(ele));
		}
		catch(Exception e)
		{
			System.out.println("Failed in waitUntilElementClickable() method due to : "+e.getMessage());
		}
		return element;
	}
	
	public void clickElement(WebElement ele, String Desc)
	{
		try{
			waitUntilElementClickable(ele,30).click();
			System.out.println("Clicked on "+Desc+" successfully");
		}
		catch(Exception e)
		{
			System.out.println("Failed in clickElement() method due to : "+e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	public void enterText(WebElement ele,String value, String Desc)
	{
		try{
			clearElement(ele, Desc);
			waitUntilElementClickable(ele,10).sendKeys(value);
			System.out.println("Entered "+value+" in field : "+Desc+" successfully");
		}
		catch(Exception e)
		{
			System.out.println("Failed in enterText() method due to : "+e.getMessage());
			Assert.fail();
		}
	}
	
	public void enterTextWithoutClear(WebElement ele,String value, String Desc)
	{
		try{
			waitUntilElementClickable(ele,10).sendKeys(value);
			System.out.println("Entered "+value+" in field : "+Desc+" successfully");
		}
		catch(Exception e)
		{
			System.out.println("Failed in enterTextWithoutClear() method due to : "+e.getMessage());
			Assert.fail();
		}
	}
	
	public void clearField(WebElement ele, String Desc)
	{
		try{
			waitUntilElementClickable(ele,10).clear();
			System.out.println("Cleared the "+Desc+" field successfully");
		}
		catch(Exception e)
		{
			System.out.println("Failed in clearElement() method due to : "+e.getMessage());
			Assert.fail();
		}
	}
	
	public String getText(WebElement ele, String Desc)
	{
		String str=null;
		try{
			str = waitUntilElementVisible(ele,10).getText();
			System.out.println("Value present in field "+Desc+" is : "+str);
		}
		catch(Exception e)
		{
			System.out.println("Failed in getText() method due to : "+e.getMessage());
			Assert.fail();
		}
		return str;
	}
	
	public void verifyText(WebElement ele, String expValue)
	{
		try{
			String actValue = getText(ele,"").trim().toLowerCase();
			
			if(actValue.equalsIgnoreCase(expValue))
			{
				System.out.println("Expecte value :"+expValue+" is matching with Actual Value : "+actValue);
			}
			else
			{
				System.out.println("Expecte value :"+expValue+" is not matching with Actual Value : "+actValue);
				Assert.fail();
			}
		}
		catch(Exception e)
		{
			System.out.println("Failed in verifyText() method due to : "+e.getMessage());
			Assert.fail();
		}
	}
	
	public void containsText(WebElement ele, String expStr)
	{
		try{
			String actValue = getText(ele,"").trim().toLowerCase();
			String expValue =expStr.toLowerCase();
			if(actValue.contains(expValue))
			{
				System.out.println("Actual value :"+expValue+" contains Expected Value : "+actValue);
			}
			else if(expValue.contains(actValue))
			{
				System.out.println("Expected value :"+expValue+" contains actual Value : "+actValue);
			}
			else
			{
				System.out.println("Expecte value :"+expValue+" does not contain Actual Value : "+actValue+" or vise versa");
				Assert.fail();
			}
		}
		catch(Exception e)
		{
			System.out.println("Failed in containsText() method due to : "+e.getMessage());
			Assert.fail();
		}
	}
	
	
	public boolean verifyIfElementFound(WebElement element, String TestDescription){
		boolean value = false;
		try{	
			boolean val1 = element.isDisplayed();
			boolean val2 = element.isEnabled();
			if(val1 == true && val2 == true){
				value = true;
				System.out.println(TestDescription+" is present");
			}
			else
			{
				System.out.println(TestDescription+" is not present");
				Assert.fail();
			}
				
			
		}catch(Exception e) {
			System.out.println("Failed in verifyIfElementFound() method due to : "+e.getMessage());
			Assert.fail();
		}
		return value;		
	}
	
	
	public void uploadFile(WebElement ele,String path)
	{
		System.out.println( "Uploading file.....");
		try {
			ele.sendKeys(path);
			System.out.println("File Uploaded Successfully");
			checkForPageDomReady();
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			System.out.println("Failed in uploadFile() method due to : "+e.getMessage());
			Assert.fail();
		}
		
	}
	
	public boolean ifElementIsNotFound(WebElement element){
		boolean value = false;
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		try{			
			boolean val1 = element.isDisplayed();
			boolean val2 = element.isEnabled();
			if(val1 == false && val2 == false){
				value = true;
			}
			
		}catch(Exception e) {
			value=true;
		}
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return value;		
	}
	
	public void clearElement(WebElement element, String TestDescription) {
		try{
			element.sendKeys(Keys.HOME);
			element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
			element.sendKeys(Keys.chord(Keys.CONTROL, "x"));
			element.clear();
			System.out.println("Cleared field "+TestDescription);
		}
		catch(Exception e)
		{
			System.out.println("Failed to cllear the field due to : "+e.getMessage());
		}
	}
	
	private static final String NUMERIC_STRING = "123456789";
	public String randomNumeric(int count) {
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * NUMERIC_STRING.length());
			builder.append(NUMERIC_STRING.charAt(character));			
		}
		return builder.toString();
	}
	

	public WebElement verifyMenuContainsItem(List<WebElement> menu,String Item, String TestDescription)
	{
		WebElement element=null;
		boolean itemFound=false;
		try {
			for(int i=0;i<menu.size();i++)
			{
				String menuItems=menu.get(i).getText().trim().toLowerCase();
				String item=Item.toLowerCase().trim();
				if(menuItems.equalsIgnoreCase(item))
				{
					element=menu.get(i);
					itemFound=true;
					break;
				}
			}
			if(itemFound)
				System.out.println(Item+ " is present in "+TestDescription);
			else
			{
				System.out.println(Item+ " is not present in "+TestDescription);
				Assert.fail();
			}
		}
		catch(Exception e)
		{
			System.out.println("Failed in method verifyMenuContainsItem() due to : "+e.getMessage());
		}
		return element;
	}
	
	public void browserRefresh(String TestDescription) {
		try {
			System.out.println("Press refresh key on Browser");
			driver.navigate().refresh();
		} catch (Exception e) {
			
		}
	}
	
	public void checkForPageDomReady() {
		driver.manage().timeouts().setScriptTimeout(180,TimeUnit.SECONDS);
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 for (int i=0; i<=160; i++)
	    { 
	        try 
	        {
	        	if (js.executeScript("return document.readyState").toString().equals("complete"))
		        { 
	        		System.out.println("loop ran for "+i+" times");
	        		break;
		        }
	        	else
	        	{
	        		Thread.sleep(2000);
	        	}
	        	
	        }catch (Exception e) {
	        	Assert.fail("Failed in checkForPageDomReady method "+e.getMessage());
	        }   
	    } 
	}
}

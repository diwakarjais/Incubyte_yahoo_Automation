package com.incubyte.page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.incubyte.utility.CommonLibraries;

public class ComposePOM {

	private WebDriver driver;
	CommonLibraries common = new CommonLibraries();
	public ComposePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	public static String subject;
	
	@FindBy(xpath="//a[@data-test-id='compose-button']")
	public WebElement composeMessageBtn; 
	
	@FindBy(xpath="//div[@aria-label='New feature notification']")
	public WebElement randomPopUp;
	
	@FindBy(xpath="//div[@aria-label='New feature notification']//button[@aria-label='Close']")
	public WebElement randomPopUpClose;
	
	@FindBy(xpath="//label[@data-test-id='label-input-To']")
	public WebElement ToLabel;
	
	@FindBy(id="message-to-field")
	public WebElement ToField;
	
	
	@FindBy(xpath="//input[@data-test-id='compose-subject']")
	public WebElement subjectField;
	
	@FindBy(xpath="//div[@aria-label='Message body']")
	public WebElement msgBody;
	
	@FindBy(xpath="//div[@aria-label='Message body']//b")
	public WebElement boldText;
	
	@FindBy(xpath="//div[@aria-label='Message body']//i")
	public WebElement italicText;
	
	@FindBy(xpath="//button//span[text()='Send']")
	public WebElement sendBtn;

	@FindBy(xpath="//button[@data-test-id='icon-btn-attach']")
	public WebElement attachIcon;
	
	@FindBy(xpath="//button[@title='Insert animated GIFs']")
	public WebElement insertGIFIcon;
	
	@FindBy(xpath="//button[@title='Add stationery']")
	public WebElement addStationaryIcon;
	
	@FindBy(xpath="//button[@title='Insert emojis']")
	public WebElement insertEmojiIcon;
	
	@FindBy(xpath="//button[@title='Link']")
	public WebElement linkSelectionIcon;
	
	@FindBy(xpath="//button[@title='Bold']")
	public WebElement boldIcon;
	
	@FindBy(xpath="//button[@title='Italic']")
	public WebElement italicIcon;
	
	@FindBy(xpath="//button[@title='Text colour']")
	public WebElement textColourIcon;
	
	@FindBy(xpath="//button[@title='Font']")
	public WebElement fontIcon;
	
	@FindBy(xpath="//button[@title='More options']")
	public WebElement moreOptionMenu;
	
	@FindBy(xpath="//span[@data-test-id='status']")
	public WebElement statusMsg;
	
	@FindBy(xpath="//button[@data-test-id='icon-btn-delete']")
	public WebElement deleteIcon;
	
	@FindBy(xpath="//button[@data-test-id='btn-cc']")
	public WebElement cc_bccBtn;
	
	@FindBy(xpath="//label[@data-test-id='label-input-CC']")
	public WebElement ccLabel;
	
	@FindBy(xpath="//label[@data-test-id='label-input-BCC']")
	public WebElement bccLabel;
	
	@FindBy(xpath="//li[@data-test-id='attach-from-gdrive']")
	public WebElement gDriveAttachment;
	
	@FindBy(xpath="//li[@data-test-id='attach-from-dropbox']")
	public WebElement dropBoxAttachment;
	
	@FindBy(xpath="//li[@data-test-id='attach-from-recent-emails']")
	public WebElement recentEmailAttachments;
	
	@FindBy(xpath="//li[@data-test-id='attach-from-computer-list-btn']")
	public WebElement attachFromComp;
	
	@FindBy(xpath="//button[@data-test-id='icon-btn-close']")
	public WebElement closeAndSaveBtn;
	
	@FindBy(xpath=".//input[@type='file']")
	public WebElement fileUpload;
	
	@FindBy(xpath="//div[@data-test-id='notifications']//span")
	public WebElement alertNotification;
	
	@FindBy(xpath="//div[@data-test-id='title']")
	public WebElement noSubjectPopUp;
	
	@FindBy(xpath="//button[@data-test-id='secondary-btn']")
	public WebElement cancelNoSubjectPopUpBtn;
	
	@FindBy(xpath="//span[text()='Sent']")
	public WebElement sentMail;
	
	@FindBy(xpath="//span[text()='Drafts']")
	public WebElement drafts;
	
	@FindBy(xpath="//span[@data-test-id='message-subject']")
	public List<WebElement> sentMsgSubject;
	
	
	public void clickComposeBtn()
	{
		if(!common.ifElementIsNotFound(randomPopUp))
		{
			common.clickElement(randomPopUpClose, "random pop up close");
		}
		common.checkForPageDomReady();
		common.clickElement(composeMessageBtn, "compose button");
		common.checkForPageDomReady();
	}
	
	public void verifyAllIcon()
	{
		
		common.verifyIfElementFound(ToLabel, "To label");
		common.verifyIfElementFound(ToField, "To field");
		common.verifyIfElementFound(subjectField, "Subject field");
		common.verifyIfElementFound(msgBody, "Message body field");
		common.verifyIfElementFound(sendBtn, "Send button");
		common.verifyIfElementFound(attachIcon, "Attach icon");
		common.verifyIfElementFound(insertGIFIcon, "Insert GIF icon");
		common.verifyIfElementFound(addStationaryIcon, "Add stationary icon");
		common.verifyIfElementFound(insertEmojiIcon, "Insert emoji icon");
		common.verifyIfElementFound(linkSelectionIcon, "Link selection icon");
		common.verifyIfElementFound(boldIcon, "Bold font icon");
		common.verifyIfElementFound(italicIcon, "Italic font icon");
		common.verifyIfElementFound(textColourIcon, "Change font color icon");
		common.verifyIfElementFound(fontIcon, "Font size icon");
		common.verifyIfElementFound(moreOptionMenu, "more option Menu");
		common.verifyIfElementFound(deleteIcon, "Delete button icon");
		common.verifyIfElementFound(closeAndSaveBtn, "Close and save button");
		
	}
	
	public void verifyAttachmentsOptions()
	{
		common.clickElement(attachIcon, "attachment icon");
		common.verifyIfElementFound(gDriveAttachment, "Attach from google drive option");
		common.verifyIfElementFound(dropBoxAttachment, "Attach from drop box option");
		common.verifyIfElementFound(recentEmailAttachments, "Attach from recent emails option");
		common.verifyIfElementFound(recentEmailAttachments, "Attach from computer option");
		common.clickElement(attachIcon, "attachment icon");
	}
	
	public void enterMessage()
	{
		String msg = "message body for test";
		common.enterText(msgBody, msg, "message content");
	}
	
	public void verifyBoldItalicText()
	{
		common.clickElement(boldIcon, "bold icon");
		common.clickElement(italicIcon, "italic icon");
		String msg = "This message is bild and italic";
		common.enterTextWithoutClear(msgBody, msg, "message content");
		common.verifyIfElementFound(boldText, "Text in Bold");
		common.verifyIfElementFound(italicText, "Text in Italic");
		
	}
	
	public void verifyCC_BCCOptions()
	{
		common.clickElement(cc_bccBtn, "cc and bcc option button");
		common.verifyIfElementFound(ccLabel, "CC label");
		common.verifyIfElementFound(bccLabel, "BCC label");
	}
	
	public void enterReciepient()
	{
		common.enterText(ToField, "abc@yahoo.com", "Reciepient email");
	}
	
	
	public void enterSubject()
	{
		subject = "DummyTestDataMail"+common.randomNumeric(4);
		common.enterText(subjectField, subject, "Email subject");
	}
	
	public void attachFromComputer(String path)
	{
		common.uploadFile(fileUpload, path);
	}
	
	public void sendEmail()
	{
		common.clickElement(sendBtn, "send button");
	}
	
	public void cancelAndSave()
	{
		common.clickElement(closeAndSaveBtn, "Close and save button");
	}
	
	public void discardMail()
	{
		common.clickElement(deleteIcon, "delete button");
	}
	
	public void verifyNoReciepientAlert()
	{
		common.clickElement(sendBtn, "send button");
		common.verifyText(alertNotification, "Please add at least one email address before sending.");
	}
	
	public void verifyInvalidReciepientAlert()
	{
		common.enterText(ToField, "abc", "Wrong email");
		common.clickElement(sendBtn, "send button");
		common.containsText(alertNotification, "Please correct these email addresses before sending: ");
	}
	
	public void verifyNoSubjectPopUp()
	{
		common.clickElement(sendBtn, "send button");
		common.verifyText(noSubjectPopUp, "Do you want to send the message without a subject?");
		common.clickElement(cancelNoSubjectPopUpBtn, "pop up cancel button");
	}
	
	public void verifyInSentItems()
	{
		common.clickElement(sentMail, "Sent mail tab");
		common.checkForPageDomReady();
		common.browserRefresh("Sent item");
		common.checkForPageDomReady();
		common.verifyMenuContainsItem(sentMsgSubject, subject, "Sent message subjects");
	}
	
	public void verifyInDraft()
	{
		common.clickElement(drafts, "Drafts tab");
		WebElement ele=common.verifyMenuContainsItem(sentMsgSubject, subject, "Sent message subjects");
		common.clickElement(ele, "Saved draft message ");
	}
	
	
}

package com.crm.sharphawk.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage
{
	WebDriver driver;
	public ContactInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy (xpath="//td[@class='dvtTabCache']/../td[5]/input[3]")
	private WebElement contactDelete;
	
	@FindBy (xpath="//span[class='dvHeaderText']")
	private WebElement msg;
	
	@FindBy (xpath="//span[@id='dtlview_Last Name']")
	private WebElement contactLastname;
	
	public WebElement getMsg() 
	{
		return msg;
	}

	public WebDriver getDriver() 
	{
		return driver;
	}

	public WebElement getContactDelete()
	{
		return contactDelete;
	}

	public WebElement getContactLastname()
	{
		return contactLastname;
	}

	
}

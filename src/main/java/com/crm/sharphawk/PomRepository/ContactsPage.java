package com.crm.sharphawk.PomRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.sharphawk.genericutility.WebDriverUtility;
public class ContactsPage extends WebDriverUtility
{
	WebDriver driver;
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy (xpath="//img[@title='Create Contact...']")
	private WebElement createContact;
	
	@FindBy (xpath="//input[@name='search_text']")
	private WebElement contactSearch;
	
	@FindBy (xpath="(//select[@name='search_field'])[1]")
	private WebElement selectBox;
	
	@FindBy (xpath="(//input[@class='crmbutton small create'])[1]")
	private WebElement contactSearchButton;
	
	@FindBy(xpath="//span[@class='genHeaderSmall']")
	private WebElement deleteMsg;
	
	
	
	public WebElement getDeleteMsg()
	{
		return deleteMsg;
	}
	public WebElement getContactSearch() 
	{
		return contactSearch;
	}
	public WebElement getSelectBox() 
	{
		return selectBox;
	}
	public WebElement getContactSearchButton()
	{
		return contactSearchButton;
	}
	public WebDriver getDriver()
	{
		return driver;
	}
	public WebElement getCreateContact() 
	{
		return createContact;
	}
	
	
}

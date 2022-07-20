package com.crm.sharphawk.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.sharphawk.genericutility.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility
{
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	} 
	@FindBy(xpath="(//input[@name='lastname'])[1]")
	private WebElement lastName;
	@FindBy (xpath="//span[@class='dvHeaderText']")
	private WebElement createContactMsg;
	@FindBy(xpath="//input[@class='crmButton small save']")
	private WebElement saveBtn;
	
	public WebElement getLastName() 
	{
		return lastName;
	}
	public WebElement getCreateContactMsg()
	{
		return createContactMsg;
	}
	public WebElement getSave() 
	{
		return saveBtn;
	}
	public void createContact(String LastName)
	{
		lastName.sendKeys(LastName);
		saveBtn.click();
	}
}

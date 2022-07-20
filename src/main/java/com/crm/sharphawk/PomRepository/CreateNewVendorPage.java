package com.crm.sharphawk.PomRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewVendorPage
{
	WebDriver driver;
	public CreateNewVendorPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//input[@name='vendorname']")
	private WebElement vendorNameTextBox;
	@FindBy(xpath="(//input[@class='crmbutton small save'])[1]")
	private WebElement saveVendorBT;
	public WebDriver getDriver() 
	{
		return driver;
	}
	public WebElement getVendorNameTextBox() 
	{
		return vendorNameTextBox;
	}
	public WebElement getSaveVendorBT()
	{
		return saveVendorBT;
	}
	
}

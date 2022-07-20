package com.crm.sharphawk.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage 
{
	WebDriver driver;
	public OrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createOrganization;
	
	
	public WebDriver getDriver() 
	{
		return driver;
	}
	public WebElement getCreateOrganization() {
		return createOrganization;
	}
	
}

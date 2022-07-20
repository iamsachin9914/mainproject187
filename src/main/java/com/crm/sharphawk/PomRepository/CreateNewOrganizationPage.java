package com.crm.sharphawk.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrganizationPage 
{
	WebDriver driver;
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="(//input[@class='detailedViewTextBox'])[1]")
	private WebElement orgName;
	@FindBy(xpath="(//input[@class='crmbutton small save'])[1]")
	private WebElement orgSave;
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getOrgName() {
		return orgName;
	}
	public WebElement getOrgSave() {
		return orgSave;
	}
	
}

package com.crm.sharphawk.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage 
{
	WebDriver driver;
	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement orgMsg;
	
	@FindBy(xpath="//span[@id='dtlview_Organization Name']")
	private WebElement createdorgName;
	
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getOrgMsg() {
		return orgMsg;
	}
	public WebElement getCreatedorgName() 
	{
		return createdorgName;
	}
	
}

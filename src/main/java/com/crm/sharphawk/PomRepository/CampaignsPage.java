package com.crm.sharphawk.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignsPage 
{
	WebDriver driver;
	public CampaignsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//img[@title='Create Campaign...']")
	private WebElement createCampaignButton;
	
	public WebDriver getDriver() 
	{
		return driver;
	}
	public WebElement getCreateCampaignButton() 
	{
		return createCampaignButton;
	}
	
	
}

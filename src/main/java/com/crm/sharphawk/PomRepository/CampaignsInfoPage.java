package com.crm.sharphawk.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignsInfoPage 
{
	
		WebDriver driver;
		public CampaignsInfoPage(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
		}
		@FindBy(xpath="//span[@class='dvHeaderText']")
		private WebElement campaignMsg;
		
		@FindBy (xpath="//span[@id='dtlview_Campaign Name']")
		private WebElement CreatedcmpName;
		
		public WebDriver getDriver()
		{
			return driver;
		}
		public WebElement getCampaignMsg()
		{
			return campaignMsg;
		}
		public WebElement getCreatedcmpName() 
		{
			return CreatedcmpName;
		}
		

}

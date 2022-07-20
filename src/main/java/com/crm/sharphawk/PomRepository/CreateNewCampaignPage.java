package com.crm.sharphawk.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewCampaignPage 

{
	WebDriver driver;
	public CreateNewCampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//input[@name='campaignname']")
	private WebElement campaignNameTextBox;
	
	@FindBy(xpath="//img[@title='Select']")
	private WebElement selectProductImg;
	
	public WebElement getSelectProductImg() {
		return selectProductImg;
	}
	@FindBy(xpath="//input[@class='crmButton small save']")
	private WebElement campaignSaveButton;
	
	@FindBy (xpath="//input[@id='search_txt']")
	private WebElement productSearch;
	
	@FindBy(name="search")
	private WebElement productSearchBtn;
	
	@FindBy(xpath="//a[@class='listFormHeaderLinks']/../../..//a[@id='1']")
	private WebElement selcectProduct;
	
	public WebDriver getDriver() 
	{
		return driver;
	}
	public WebElement getCampaignNameTextBox()
	{
		return campaignNameTextBox;
	}
	public WebElement getCampaignSaveButton()
	{
		return campaignSaveButton;
	}
	public WebElement getProductSearch() 
	{
		return productSearch;
	}
	public WebElement getProductSearchBtn()
	{
		return productSearchBtn;
	}
	public WebElement getSelcectProduct()
	{
		return selcectProduct;
	}
	
	
}

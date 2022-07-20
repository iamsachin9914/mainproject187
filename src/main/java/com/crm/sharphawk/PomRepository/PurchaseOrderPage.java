package com.crm.sharphawk.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchaseOrderPage 
{
	WebDriver driver;
	public PurchaseOrderPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//img[@title='Create Purchase Order...']")
	private WebElement createPurchaseorderButton;
	public WebDriver getDriver() 
	{
		return driver;
	}
	public WebElement getCreatePurchaseorderButton() 
	{
		return createPurchaseorderButton;
	}

}

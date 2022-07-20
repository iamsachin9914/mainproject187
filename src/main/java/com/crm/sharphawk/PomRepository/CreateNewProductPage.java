package com.crm.sharphawk.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewProductPage 
{
	WebDriver driver;
	public CreateNewProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(xpath="(//input[@class='detailedViewTextBox'])[1]")
	private WebElement productNameText;
	@FindBy(xpath="(//img[@title='Select'])[1]")
	private WebElement vendorNameLookup1;
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement vendorNameSearch1;
	@FindBy(xpath="//select[@name='search_field']")
	private WebElement vendornameSelect1;
	@FindBy(xpath="//input[@class='crmbutton small create']")
	private WebElement vendorSearchButton1;
	@FindBy(xpath="(//a[@class='listFormHeaderLinks'])[1]/../../..//a[@id='1']")
	private WebElement pickVendorname1;
	@FindBy(xpath="(//input[@class='crmbutton small save'])[1]")
	private WebElement productSaveButton;
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getProductNameText() {
		return productNameText;
	}
	public WebElement getVendorNameLookup1() {
		return vendorNameLookup1;
	}
	public WebElement getVendorNameSearch1() {
		return vendorNameSearch1;
	}
	public WebElement getVendornameSelect1() {
		return vendornameSelect1;
	}
	public WebElement getVendorSearchButton1() {
		return vendorSearchButton1;
	}
	public WebElement getPickVendorname1() {
		return pickVendorname1;
	}
	public WebElement getProductSaveButton() {
		return productSaveButton;
	}
	
}

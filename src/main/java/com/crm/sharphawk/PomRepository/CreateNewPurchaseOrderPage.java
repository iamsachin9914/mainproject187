package com.crm.sharphawk.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewPurchaseOrderPage
{
	WebDriver driver;
	public CreateNewPurchaseOrderPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="(//input[@class='detailedViewTextBox'])[1]")	
	private WebElement subjectTextBox;
	@FindBy(xpath="(//img[@title='Select'])[1]")
	private WebElement vendorNameLookup2;
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement vendorNameSearch2;
	@FindBy(xpath="//select[@name='search_field']")
	private WebElement vendornameSelect2;
	@FindBy(xpath="//input[@class='crmbutton small create']")
	private WebElement vendorSearchButton2;
	@FindBy(xpath="(//a[@class='listFormHeaderLinks'])[1]/../../..//a[@id='1']")
	private WebElement pickVendorname;
	@FindBy(xpath="//textarea[@name='bill_street']")
	private WebElement billingAddress;
	@FindBy(xpath="//textarea[@name='ship_street']")
	private WebElement shippingAddress;
	@FindBy(xpath="//img[@id='searchIcon1']")
	private WebElement productLookup;
	@FindBy(xpath="//input[@id='search_txt']")
	private WebElement productSearchTB;
	@FindBy(xpath="//select[@name='search_field']")
	private WebElement productSelectBox;
	@FindBy(xpath="//input[@class='crmbutton small create']")
	private WebElement productSearchBT;
	@FindBy(xpath="(//a[@class='listFormHeaderLinks'])[1]/../../..//a[@id='popup_product_32']")
	private WebElement productPick;
	@FindBy(xpath="//input[@id='qty1'])")
	private WebElement savePurchaseOrderBT;
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getSubjectTextBox() {
		return subjectTextBox;
	}
	public WebElement getVendorNameLookup2() {
		return vendorNameLookup2;
	}
	public WebElement getVendorNameSearch2() {
		return vendorNameSearch2;
	}
	public WebElement getVendornameSelect2() {
		return vendornameSelect2;
	}
	public WebElement getVendorSearchButton2() {
		return vendorSearchButton2;
	}
	public WebElement getPickVendorname() {
		return pickVendorname;
	}
	public WebElement getBillingAddress() {
		return billingAddress;
	}
	public WebElement getShippingAddress() {
		return shippingAddress;
	}
	public WebElement getProductLookup() {
		return productLookup;
	}
	public WebElement getProductSearchTB() {
		return productSearchTB;
	}
	public WebElement getProductSelectBox() {
		return productSelectBox;
	}
	public WebElement getProductSearchBT() {
		return productSearchBT;
	}
	public WebElement getProductPick() {
		return productPick;
	}
	public WebElement getSavePurchaseOrderBT() {
		return savePurchaseOrderBT;
	}
	
	
}

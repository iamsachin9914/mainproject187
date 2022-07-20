package com.crm.sharphawk.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.sharphawk.genericutility.WebDriverUtility;

public class HomePage extends WebDriverUtility
{
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "(//a[text()='Organizations'])[1]")
	private WebElement organization;
	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement contacts;
	@FindBy(xpath = "//a[text()='Products']")
	private WebElement product;
	@FindBy(xpath = "//a[text()='More']")
	private WebElement more;
	@FindBy(xpath = "//a[text()='Purchase Order']")
	private WebElement purchaseOrder;
	@FindBy(xpath = "//a[text()='Vendors']")
	private WebElement vendors;
	@FindBy(xpath = "//a[text()='Campaigns']")
	private WebElement Campaigns;
	@FindBy(xpath ="//img[@src='themes/softed/images/user.PNG']")
	private WebElement admin;
	@FindBy(xpath ="//a[text()='Sign Out']")
	private WebElement signout;
	@FindBy(xpath ="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImage;
	public WebElement getOrganization() {
		return organization;
	}
	public WebElement getContacts() {
		return contacts;
	}
	public WebElement getProduct() {
		return product;
	}
	public WebElement getMore() {
		return more;
	}
	public WebElement getPurchaseOrder() {
		return purchaseOrder;
	}
	public WebElement getVendors() {
		return vendors;
	}
	public WebElement getAdminImage() {
		return adminImage;
	}
	public WebElement getCampaigns() {
		return Campaigns;
	}
	public WebElement getAdmin() {
		return admin;
	}
	public WebElement getSignout() {
		return signout;
	}
	public void signOutVtiger()
	{
		mouseOverOnElement(driver,adminImage);
		signout.click();
		//driver.close();
	}
}

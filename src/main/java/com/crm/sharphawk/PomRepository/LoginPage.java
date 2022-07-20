package com.crm.sharphawk.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(name="user_name")
	private WebElement uName;
	@FindBy(name="user_password")
	private WebElement pWord;
	@FindBy(id="submitButton")
	private WebElement lButton;
	public WebElement getuName() 
	{
		return uName;
	}
	public WebElement getpWord()
	{
		return pWord;
	}
	public WebElement getlButton()
	{
		return lButton;
	}
	public void LoginToVtiger(String Url,String userName,String PassWord)
	{
		driver.get(Url);
		getuName().sendKeys(userName);
		getpWord().sendKeys(PassWord);
		getlButton().click();
		
	}

}

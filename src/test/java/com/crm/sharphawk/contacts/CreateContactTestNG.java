package com.crm.sharphawk.contacts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.sharphawk.PomRepository.ContactInfoPage;
import com.crm.sharphawk.PomRepository.ContactsPage;
import com.crm.sharphawk.PomRepository.CreateNewContactPage;
import com.crm.sharphawk.PomRepository.HomePage;
import com.crm.sharphawk.PomRepository.LoginPage;
import com.crm.sharphawk.genericutility.BaseClass;
import com.crm.sharphawk.genericutility.ExcelUtility;
import com.crm.sharphawk.genericutility.FileUtility;
import com.crm.sharphawk.genericutility.JavaUtility;
import com.crm.sharphawk.genericutility.WebDriverUtility;
public class CreateContactTestNG extends BaseClass
{
	FileUtility fLib=new FileUtility();
	ExcelUtility eLib=new ExcelUtility();
	JavaUtility jLib=new JavaUtility();
	WebDriverUtility wLib=new WebDriverUtility();

	@Test(groups = "Smoke")
	public void createContact() throws Throwable
	{
		HomePage h=new HomePage(driver);
		h.getContacts().click();
		ContactsPage cp=new ContactsPage(driver);
		cp.getCreateContact().click();
		int r1=jLib.getRandomNUm();
		CreateNewContactPage ccp=new CreateNewContactPage(driver);
		ccp.createContact(eLib.getDataFromExcel("vtiger",1,0)+r1);
		ContactInfoPage cip=new ContactInfoPage(driver);
		String ActualText =cip.getContactLastname().getText();
		String expectedText = eLib.getDataFromExcel("vtiger",1,0)+r1;
		Assert.assertTrue(ActualText.equals(expectedText));
		
	}
	@Test(groups = "Regression")
	public void createAndContact()throws Throwable
	{
		HomePage hp=new HomePage(driver);
		hp.getContacts().click();
		ContactsPage cp=new ContactsPage(driver); 
		cp.getCreateContact().click();
		System.out.println("After Create Contact");
		int r1=jLib.getRandomNUm();
		CreateNewContactPage ccp=new CreateNewContactPage(driver);
		ccp.createContact(eLib.getDataFromExcel("vtiger",1,0)+r1);
		ContactInfoPage cip=new ContactInfoPage(driver);
		cip.getContactDelete().click();
		wLib.swithToAlertWindowAndAccpectWithoutCondition(driver);
		cp.getContactSearch().sendKeys(eLib.getDataFromExcel("vtiger",1,0)+r1);
		cp.getSelectBox().click();
		cp.getContactSearchButton().click();
		boolean display =cp.getDeleteMsg().isDisplayed();
		Assert.assertTrue(display);
	}

}




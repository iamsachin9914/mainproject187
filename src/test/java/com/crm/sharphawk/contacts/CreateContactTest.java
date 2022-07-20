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

public class CreateContactTest extends BaseClass
{
	public static void main(String[] args) throws Throwable
	{
		
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		String Url=fLib.getPropertyData("url");
		String uName=fLib.getPropertyData("username");
		String pWord=fLib.getPropertyData("password");
		WebDriver driver=new ChromeDriver();
		wLib.waitForElementInDOM(driver);
		driver.manage().window().maximize();
		LoginPage lp=new LoginPage(driver);
		lp.LoginToVtiger(Url,uName,pWord);
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
//		WebElement messege = ccp.getCreateContactMsg();
//		String ActualText = messege.getText();
		Assert.assertTrue(ActualText.contains(expectedText));
//		if(ActualText.contains(eLib.getDataFromExcel("vtiger",1,0)+r1))
//			System.out.println("contact has created successfully");
//		else
//			System.out.println("contact not created");
		h.signOutVtiger();
		driver.close();
	}
}


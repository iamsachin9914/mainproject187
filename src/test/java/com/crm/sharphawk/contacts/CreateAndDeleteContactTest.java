package com.crm.sharphawk.contacts;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

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
public class CreateAndDeleteContactTest extends BaseClass
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
		driver.get(Url);
		driver.manage().window().maximize();
		LoginPage lp=new LoginPage(driver);
		lp.LoginToVtiger(Url,uName,pWord);
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
		if(display==true)
		{
			System.out.println("contact deleted successfully");
		}
		else
		{
			System.out.println("contact not deleted");
		}
		hp.signOutVtiger();
	}

}

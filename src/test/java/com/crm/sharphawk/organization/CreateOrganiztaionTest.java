package com.crm.sharphawk.organization;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.sharphawk.PomRepository.CreateNewOrganizationPage;
import com.crm.sharphawk.PomRepository.HomePage;
import com.crm.sharphawk.PomRepository.LoginPage;
import com.crm.sharphawk.PomRepository.OrganizationInfoPage;
import com.crm.sharphawk.PomRepository.OrganizationPage;
import com.crm.sharphawk.genericutility.ExcelUtility;
import com.crm.sharphawk.genericutility.FileUtility;
import com.crm.sharphawk.genericutility.JavaUtility;
import com.crm.sharphawk.genericutility.WebDriverUtility;
public class CreateOrganiztaionTest 
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
		hp.getOrganization().click();
		OrganizationPage op=new OrganizationPage(driver);
		op.getCreateOrganization().click();
		int r1=jLib.getRandomNUm();
		String orgname = eLib.getDataFromExcel("vtiger",1,1);
		CreateNewOrganizationPage cno=new CreateNewOrganizationPage(driver);
		cno.getOrgName().sendKeys(orgname+r1);
		cno.getOrgSave().click();
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String actualText = oip.getOrgMsg().getText();
		if(actualText.contains(orgname))
		{
			System.out.println("organization name has been added successfully");
		}
		else
		{
			System.out.println("Organization name not added");
		}
		hp.signOutVtiger();
	}
}

package com.crm.sharphawk.campaign;
import java.io.FileNotFoundException;
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

import com.crm.sharphawk.PomRepository.CampaignsInfoPage;
import com.crm.sharphawk.PomRepository.CampaignsPage;
import com.crm.sharphawk.PomRepository.CreateNewCampaignPage;
import com.crm.sharphawk.PomRepository.HomePage;
import com.crm.sharphawk.PomRepository.LoginPage;
import com.crm.sharphawk.genericutility.ExcelUtility;
import com.crm.sharphawk.genericutility.FileUtility;
import com.crm.sharphawk.genericutility.IConstants;
import com.crm.sharphawk.genericutility.JavaUtility;
import com.crm.sharphawk.genericutility.WebDriverUtility;

public class CreateCampaignTest implements IConstants
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
		HomePage h=new HomePage(driver);
		WebElement r = h.getMore();
		wLib.mouseOverOnElement(driver, r);
		h.getCampaigns().click();
		CampaignsPage cp=new CampaignsPage(driver);
		cp.getCreateCampaignButton().click();
		int r1=jLib.getRandomNUm();
		String cname = eLib.getDataFromExcel("vtiger",1,2);
		CreateNewCampaignPage cnc=new CreateNewCampaignPage(driver);
		cnc.getCampaignNameTextBox().sendKeys(cname+r1);
		cnc.getCampaignSaveButton().click();
		CampaignsInfoPage cip=new CampaignsInfoPage(driver);
		String aText =cip.getCampaignMsg().getText();
		if(aText.contains(cname+r1))
		{
			System.out.println("campaign has created");
		}
		else
		{
			System.out.println("campaign not created");
		}
		h.signOutVtiger();
	}

}

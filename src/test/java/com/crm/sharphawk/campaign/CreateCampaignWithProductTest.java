package com.crm.sharphawk.campaign;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.sharphawk.PomRepository.CampaignsInfoPage;
import com.crm.sharphawk.PomRepository.CampaignsPage;
import com.crm.sharphawk.PomRepository.CreateNewCampaignPage;
import com.crm.sharphawk.PomRepository.CreateNewProductPage;
import com.crm.sharphawk.PomRepository.HomePage;
import com.crm.sharphawk.PomRepository.LoginPage;
import com.crm.sharphawk.PomRepository.ProductsPage;
import com.crm.sharphawk.genericutility.ExcelUtility;
import com.crm.sharphawk.genericutility.FileUtility;
import com.crm.sharphawk.genericutility.JavaUtility;
import com.crm.sharphawk.genericutility.WebDriverUtility;

public class CreateCampaignWithProductTest 
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
		hp.getProduct().click();
		ProductsPage pp=new ProductsPage(driver);
		pp.getCreateProduct().click();
		String product=eLib.getDataFromExcel("vtiger",1,3);
		int r1=jLib.getRandomNUm();
		CreateNewProductPage cnp=new CreateNewProductPage(driver);
		cnp.getProductNameText().sendKeys(product+r1);
		cnp.getProductSaveButton().click();
		WebElement mr = hp.getMore();
		wLib.mouseOverOnElement(driver, mr);
		hp.getCampaigns().click();
		CampaignsPage cp=new CampaignsPage(driver);
		cp.getCreateCampaignButton().click();
		String campaign=eLib.getDataFromExcel("vtiger",1,2);
		CreateNewCampaignPage ccp=new CreateNewCampaignPage(driver);
		ccp.getCampaignNameTextBox().sendKeys(campaign+r1);
		String pId = driver.getTitle();
		eLib.setDataToExcel("vtiger",1,4,pId);
		wLib.swithToWindow(driver,pId);
		ccp.getProductSearch().sendKeys(product+r1);
		ccp.getProductSearchBtn().click();
		Thread.sleep(3000);
		ccp.getSelcectProduct().click();
		wLib.swithToWindow(driver,pId);
		ccp.getCampaignSaveButton().click();
		CampaignsInfoPage cip=new CampaignsInfoPage(driver);
		String verifyC=cip.getCampaignMsg().getText();
		if(verifyC.contains(campaign+r1))
		{
			System.out.println("Campaign created successfully");
		}
		else
		{
			System.out.println("Campaign not created");
		}
		hp.signOutVtiger();
	
	}
}

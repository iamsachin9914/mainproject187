package com.crm.sharphawk.campaign;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.sharphawk.PomRepository.CampaignsInfoPage;
import com.crm.sharphawk.PomRepository.CampaignsPage;
import com.crm.sharphawk.PomRepository.CreateNewCampaignPage;
import com.crm.sharphawk.PomRepository.CreateNewProductPage;
import com.crm.sharphawk.PomRepository.HomePage;
import com.crm.sharphawk.PomRepository.ProductsPage;
import com.crm.sharphawk.genericutility.BaseClass;
import com.crm.sharphawk.genericutility.ExcelUtility;
import com.crm.sharphawk.genericutility.FileUtility;
import com.crm.sharphawk.genericutility.JavaUtility;
import com.crm.sharphawk.genericutility.WebDriverUtility;

public class CreateCampaignTestNg extends BaseClass
{
	FileUtility fLib=new FileUtility();
	ExcelUtility eLib=new ExcelUtility();
	JavaUtility jLib=new JavaUtility();
	WebDriverUtility wLib=new WebDriverUtility();
	@Test(groups = "Smoke")
	public void createCampaign() throws Throwable
	{
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
		//driver.close();
		
	}
	@Test(groups = "Regression")
	public void createCampaignWithProduct() throws Throwable 
	{
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
		ccp.getSelectProductImg().click();
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
		//driver.close();
	}
}

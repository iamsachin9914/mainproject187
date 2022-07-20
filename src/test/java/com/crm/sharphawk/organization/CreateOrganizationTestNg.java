package com.crm.sharphawk.organization;
import org.testng.annotations.Test;
import com.crm.sharphawk.PomRepository.CreateNewOrganizationPage;
import com.crm.sharphawk.PomRepository.HomePage;
import com.crm.sharphawk.PomRepository.OrganizationInfoPage;
import com.crm.sharphawk.PomRepository.OrganizationPage;
import com.crm.sharphawk.genericutility.BaseClass;
import com.crm.sharphawk.genericutility.ExcelUtility;
import com.crm.sharphawk.genericutility.FileUtility;
import com.crm.sharphawk.genericutility.JavaUtility;
import com.crm.sharphawk.genericutility.WebDriverUtility;

public class CreateOrganizationTestNg extends BaseClass
{
	FileUtility fLib=new FileUtility();
	ExcelUtility eLib=new ExcelUtility();
	JavaUtility jLib=new JavaUtility();
	WebDriverUtility wLib=new WebDriverUtility();


	@Test(groups = "Regression")
	public void CreateOrganization() throws Throwable
	{
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

	}
}

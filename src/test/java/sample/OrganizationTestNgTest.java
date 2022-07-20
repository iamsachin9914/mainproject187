package sample;

import org.testng.Assert;
import org.testng.annotations.Listeners;
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
@Listeners(com.crm.sharphawk.genericutility.ListnerImpUtility.class)
public class OrganizationTestNgTest extends BaseClass
{
	FileUtility fLib=new FileUtility();
	ExcelUtility eLib=new ExcelUtility();
	JavaUtility jLib=new JavaUtility();
	WebDriverUtility wLib=new WebDriverUtility();

	@Test(groups = "Smoke")
	public void createOrganization() throws Throwable
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
		String actualText = oip.getCreatedorgName().getText();
		String expectedText = orgname+r1;
		Assert.assertTrue(actualText.equals(expectedText));
		Assert.fail();

	}
	
}

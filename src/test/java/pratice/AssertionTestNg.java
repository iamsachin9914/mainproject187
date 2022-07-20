package pratice;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.sharphawk.genericutility.BaseClass;
import com.crm.sharphawk.genericutility.ExcelUtility;
import com.crm.sharphawk.genericutility.FileUtility;
import com.crm.sharphawk.genericutility.JavaUtility;
import com.crm.sharphawk.genericutility.WebDriverUtility;

public class AssertionTestNg extends BaseClass

{
	FileUtility fLib=new FileUtility();
	ExcelUtility eLib=new ExcelUtility();
	JavaUtility jLib=new JavaUtility();
	WebDriverUtility wLib=new WebDriverUtility();

	@Test
	public void VerifyTitle() 
	{
		System.out.println("");
		String eTitle="vtiger CRM - 5";
		String aTitle=driver.getTitle();
		Assert.assertEquals(eTitle, aTitle);
	}
}

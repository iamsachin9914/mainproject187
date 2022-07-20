package pratice;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.sharphawk.genericutility.BaseClass;

public class RetrySampleTest extends BaseClass
{
	@Test(retryAnalyzer = com.crm.sharphawk.genericutility.RetryImpleUtility.class)
		public void test()
		{
			Assert.assertEquals("A","B");
		}
	
}

package pratice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.sharphawk.genericutility.BaseClass;
@Listeners(com.crm.sharphawk.genericutility.ListnerImpUtility.class)
public class ScreenShotTest
{
@Test
public void demoTest()
{
	System.out.println("start");
	Assert.assertEquals(false, true);
	System.out.println("stop");
}
}

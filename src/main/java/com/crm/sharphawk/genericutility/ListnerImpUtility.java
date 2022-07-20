package com.crm.sharphawk.genericutility;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnerImpUtility extends BaseClass implements ITestListener
{

	public void onTestStart(ITestResult result) {

	}

	public void onTestSuccess(ITestResult result) {

	}

	public void onTestFailure(ITestResult result) 
	{
				String testname=result.getMethod().getMethodName();
				EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.driver2);
				File src = edriver.getScreenshotAs(OutputType.FILE);
				String d =new Date().toString().replaceAll(":", "_jb ");
				File dest=new File("./ScreenShots/"+testname+d+".png");
				try 
				{
					FileUtils.copyFile(src, dest);
				} catch (IOException e)
				{
					e.printStackTrace();
				}
	}

	public void onTestSkipped(ITestResult result) 
	{

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{

	}

	public void onTestFailedWithTimeout(ITestResult result)
	{

	}

	public void onStart(ITestContext context)
	
	{

	}
	public void onFinish(ITestContext context)
	{

	}


}

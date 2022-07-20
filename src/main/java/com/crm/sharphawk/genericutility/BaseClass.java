package com.crm.sharphawk.genericutility;
import java.sql.SQLException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import com.beust.jcommander.Parameter;
import com.crm.sharphawk.PomRepository.HomePage;
import com.crm.sharphawk.PomRepository.LoginPage;
public class BaseClass
{
	public WebDriver driver;
	public static WebDriver driver2;
	@BeforeSuite(groups = {"Smoke","Regression"})
	public void openDb() throws SQLException
	{
		DataBaseUtility dLib=new DataBaseUtility();
		System.out.println("database connection established");
		dLib.connectDB();
	}
//	@Parameters("Browser")
	@BeforeClass(groups = {"Smoke","Regression"})
	public void openBrowser() throws Throwable
	{
		FileUtility fLib=new FileUtility();
		String browser = fLib.getPropertyData("browser");
//		if(browser.equals("chrome"))
//		{
//			driver=new ChromeDriver();
//		}
//		else if(browser.equals("firefox"))
//		{
//			driver=new FirefoxDriver();
//		}
//		else
//		{
//			driver=new ChromeDriver();
//		}
		driver=new ChromeDriver();
//		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		WebDriverUtility wLib=new WebDriverUtility();
		wLib.waitForElementInDOM(driver);
		driver2=driver;
	}
	@BeforeMethod(groups = {"Smoke","Regression"})
	public void loginApp() throws Throwable
	{
		FileUtility fLib=new FileUtility();
		String appUrl = fLib.getPropertyData("url");
		String appUname=fLib.getPropertyData("username");
		String appPwd=fLib.getPropertyData("password");
		LoginPage lp=new LoginPage(driver);
		lp.LoginToVtiger(appUrl,appUname,appPwd);
	}
	@AfterMethod(groups = {"Smoke","Regression"})
	public void logoutApp()
	{
		HomePage hp=new HomePage(driver);
		hp.signOutVtiger();
		
	}
	@AfterClass(groups = {"Smoke","Regression"})
	public void closeBrowser()
	{
		driver.quit();
	}
	@AfterSuite(groups = {"Smoke","Regression"})
	public void closeDb() throws SQLException
	{
		DataBaseUtility dLib=new DataBaseUtility();
		dLib.closeDatabase();
	}
}

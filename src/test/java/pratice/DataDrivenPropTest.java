package pratice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataDrivenPropTest 
{
	
	public static void main(String[] args) throws IOException
	{
		
		FileInputStream fis =new FileInputStream("./TestData/commondata.properties");
		Properties p=new Properties();
		p.load(fis);
		String url = p.getProperty("url");
		String username=p.getProperty("username");
		String password=p.getProperty("password");
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
		WebDriver driver=new ChromeDriver();
		driver.get(url);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		
	}

}

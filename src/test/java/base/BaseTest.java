package base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import exceptions.FrameworkException;
import utils.CommonUtilities;



public class BaseTest {
	
	public static WebDriver driver;
	
	public static CommonUtilities  common=new CommonUtilities();
	
	public static void launchApplictaion()
	{
		driver=BaseTest.getDriver();
		
		driver.get(common.getProperty("url"));
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
	}
	
	public static WebDriver getDriver()
	{
		
		if(driver==null)
		{
			String browserName=common.getProperty("browser");
			
			switch (browserName.toLowerCase()) {
			case "chrome" :
				driver=new ChromeDriver();
				
				break;

			case "firefox" :
				driver=new FirefoxDriver();
				
				break;
				
			case "edge" :
				driver=new EdgeDriver();
				
				break;
				
			default:
				
				FrameworkException fe=new FrameworkException("please pass the right browser ..choose chrome/firefox/edge");
				throw new FrameworkException("Invalid Browser Exception");
			}
		}
		
		
		return driver;
		
	}
	
	

}
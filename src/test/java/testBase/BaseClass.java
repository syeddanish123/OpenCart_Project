package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
public class BaseClass {

	public static WebDriver driver;
	public Logger logger;
	public Properties pro;
	public FileInputStream fis;
	
	
	@BeforeClass(groups={"sanity","master","regression","datadriven"})
	@Parameters({"os","browser","execution"})
	public void setup(String os,String brws,String execution) throws  Exception {
		
    //Remote exeution setup...
		String url="http://localhost:4444/wd/hub";
		DesiredCapabilities cap=new DesiredCapabilities();
		
	//Windows..	
		if(execution.equalsIgnoreCase("remote"))
		{
		if(os.equalsIgnoreCase("windows") && brws.equalsIgnoreCase("chrome"))
		{
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.WIN11);
			driver=new RemoteWebDriver(new URL(url),cap);
		}
		else if(os.equalsIgnoreCase("windows") && brws.equalsIgnoreCase("firefox"))
		{
			cap.setBrowserName("firefox");
			cap.setPlatform(Platform.WIN11);
			driver=new RemoteWebDriver(new URL(url),cap);
		}
		else if(os.equalsIgnoreCase("windows") && brws.equalsIgnoreCase("Edge"))
		{
			cap.setBrowserName("Edge");
			cap.setPlatform(Platform.WIN11);
			driver=new RemoteWebDriver(new URL(url),cap);
		}
		}
		
	//Linux
		
		if(execution.equalsIgnoreCase("remote"))
		{
		if(os.equalsIgnoreCase("linux") && brws.equalsIgnoreCase("chrome"))
		{
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.LINUX);
			driver=new RemoteWebDriver(new URL(url),cap);
		}
		else if(os.equalsIgnoreCase("linux") && brws.equalsIgnoreCase("firefox"))
		{
			cap.setBrowserName("firefox");
			cap.setPlatform(Platform.LINUX);
			driver=new RemoteWebDriver(new URL(url),cap);
		}
		else if(os.equalsIgnoreCase("linux") && brws.equalsIgnoreCase("Edge"))
		{
			cap.setBrowserName("Edge");
			cap.setPlatform(Platform.LINUX);
			driver=new RemoteWebDriver(new URL(url),cap);
		}
		}
		
//Local Execution Setup.......
		
		if(execution.equalsIgnoreCase("local"))
		{
		if(os.equalsIgnoreCase("windows") && brws.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(os.equalsIgnoreCase("windows") && brws.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(os.equalsIgnoreCase("windows") && brws.equalsIgnoreCase("Edge"))
		{
			driver=new EdgeDriver();
		}
		}
	
//logger setup.....
		logger=LogManager.getLogger(this.getClass());
		pro=new Properties();
		fis=new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//PropertyFile.properties");
		pro.load(fis);		
		
//Deleting cookies...		
		driver.manage().deleteAllCookies();
		driver.get(pro.getProperty("URL"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
			
	}
	
	@AfterClass(groups={"sanity","master","regression","datadriven"})
	public void teardown() {
		
		if(!driver.equals(null))
		   driver.quit();
	}
	
	
    
    
    
	
}

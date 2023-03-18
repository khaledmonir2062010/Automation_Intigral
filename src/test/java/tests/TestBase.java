package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


import io.github.bonigarcia.wdm.WebDriverManager;


public class TestBase 
{

	String os=System.getProperty("os.name").toLowerCase();


	public static WebDriver driver;
	@BeforeSuite(groups = "regression")
	@Parameters({"browser"})
	public void StartDriver(@Optional("chrome") String browserName )
	{

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions ops = new ChromeOptions();
			ops.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(ops);
		}

		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		else if (browserName.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
         
		//String URL = "https://subscribe.stctv.com/sa-en?";
		//driver.navigate().to(URL);
		//driver.manage().window().maximize();
	}

	@AfterSuite(groups = "regression")
	public void CloseDriver()
	{
		driver.quit();
	}

}
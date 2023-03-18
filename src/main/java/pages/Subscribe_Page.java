package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Subscribe_Page extends PageBase {

	public Subscribe_Page(WebDriver driver) {
		super(driver);
	}
	
	
	public void URLNavigation(String CountryInitial)
	{	
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(ops);
		
		String dashboardURL = "https://subscribe.stctv.com/"+CountryInitial+"-en?";
		driver.navigate().to(dashboardURL);
		driver.manage().window().maximize();
	}
	
	
	//Countries Menu Elements
	@FindBy(id="country-btn")
	WebElement countrybtn;
	
	@FindBy(id="kw")
	WebElement KuwaitBtn;
	
	@FindBy(id="bh")
	WebElement BahrahinBtn;
	
	public void ChooseCountry()
	{
		click_button(countrybtn);
	}
	
	
	//Packages Menu Elements
	//Classic Menu: Title-Price-Currency
	@FindBy(id = "name-classic")
	public WebElement ClassicTitle;
	
	@FindBy(id="currency-classic")
	public WebElement ClassicPrice;
	
	
		
	//Lite Menu: Title-Price-Currency
	@FindBy(id = "name-lite")
	public WebElement LiteTitle;
	
	@FindBy(id="currency-lite")
	public WebElement LitePrice;
	
	
	
	//Premium Menu: Title-Price-Currency
	@FindBy(id = "name-premium")
	public WebElement PremuimTitle;
	
	@FindBy(id="currency-premium")
	public WebElement PremiumPrice;
	
	
	

}

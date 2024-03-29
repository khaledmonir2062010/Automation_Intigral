package tests;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Subscribe_Page;


public class TC1 extends TestBase {

	Subscribe_Page subscription;

	String KSA_URL="https://subscribe.stctv.com/sa-en?";
	String Bahrain_URL="https://subscribe.stctv.com/bh-en?";
	String Kuwait_URL="https://subscribe.stctv.com/kw-en?";


	public void URL(String Countryinit)
	{
		String URL = "https://subscribe.stctv.com/"+Countryinit+"-en?";
		driver.navigate().to(URL);
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void SubscriptionValidation_KSA() 
	{
		subscription = new Subscribe_Page(driver);
		URL("sa");

		//Assertion to check that the opened URL is correct as per entered Country initial
		Assert.assertEquals(KSA_URL,driver.getCurrentUrl());

		//Assertion to check The package Title displayed Correctly
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(4));
		Assert.assertTrue(subscription.LiteTitle.isDisplayed());
		Assert.assertTrue(subscription.ClassicTitle.isDisplayed());
		Assert.assertTrue(subscription.PremuimTitle.isDisplayed());

		//Assertion to check that the Price per each package displayed correctly per currency
		wait.until(ExpectedConditions.visibilityOf(subscription.LitePrice));
		Assert.assertEquals("15 SAR/month", subscription.LitePrice.getText());		

		wait.until(ExpectedConditions.visibilityOf(subscription.ClassicPrice));
		Assert.assertEquals("25 SAR/month", subscription.ClassicPrice.getText());

		wait.until(ExpectedConditions.visibilityOf(subscription.PremiumPrice));
		Assert.assertEquals("60 SAR/month", subscription.PremiumPrice.getText());

	}


	@Test(priority = 2)
	public void SubscriptionValidation_bahrain() 
	{
		subscription = new Subscribe_Page(driver);
		URL("bh");
		//Assertion to check that the opened URL is correct as per entered Country initial
		Assert.assertEquals(Bahrain_URL,driver.getCurrentUrl());

		//Assertion to check The package Title displayed Correctly
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(4));
		Assert.assertTrue(subscription.LiteTitle.isDisplayed());
		Assert.assertTrue(subscription.ClassicTitle.isDisplayed());
		Assert.assertTrue(subscription.PremuimTitle.isDisplayed());

		//Assertion to check that the Price per each package displayed correctly per currency
		wait.until(ExpectedConditions.visibilityOf(subscription.LitePrice));
		Assert.assertEquals("2 BHD/month", subscription.LitePrice.getText());		

		wait.until(ExpectedConditions.visibilityOf(subscription.ClassicPrice));
		Assert.assertEquals("3 BHD/month", subscription.ClassicPrice.getText());

		wait.until(ExpectedConditions.visibilityOf(subscription.PremiumPrice));
		Assert.assertEquals("6 BHD/month", subscription.PremiumPrice.getText());


	}


	@Test(priority = 3)
	public void SubscriptionValidation_Kuwait() 
	{
		subscription = new Subscribe_Page(driver);
		URL("kw");

		//Assertion to check that the opened URL is correct as per entered Country initial
		Assert.assertEquals(Kuwait_URL,driver.getCurrentUrl());

		//Assertion to check The package Title displayed Correctly
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(4));
		Assert.assertTrue(subscription.LiteTitle.isDisplayed());
		Assert.assertTrue(subscription.ClassicTitle.isDisplayed());
		Assert.assertTrue(subscription.PremuimTitle.isDisplayed());

		
		//Assertion to check that the Price per each package displayed correctly per currency
		wait.until(ExpectedConditions.visibilityOf(subscription.LitePrice));
		Assert.assertEquals("1.2 KWD/month", subscription.LitePrice.getText());		

		wait.until(ExpectedConditions.visibilityOf(subscription.ClassicPrice));
		Assert.assertEquals("2.5 KWD/month", subscription.ClassicPrice.getText());

		wait.until(ExpectedConditions.visibilityOf(subscription.PremiumPrice));
		Assert.assertEquals("4.8 KWD/month", subscription.PremiumPrice.getText());
	}

}

package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.xeHomePage;


public class XeConvertTest {
	WebDriver driver;
	

	@Test (dataProvider = "data-provider")
	public void titleTest(String amt, String from, String to, String result, String browserType) throws InterruptedException {

		initializeBrowser(browserType);
		
		// Navigate currency site
		driver.manage().window().maximize();
		driver.get("https://www.xe.com/currencyconverter/");
		Assert.assertTrue(driver.getTitle().contains("Xe Currency Converter - Live Exchange Rates Today"));
		//initiate Page Object
		xeHomePage xe = new xeHomePage(driver);
		//accept cookies
		xe.clickAccept();
		//enter amount
		xe.enterAmount(amt);
		//choose from currency
		xe.chooseFrom(from);
		//choose to currency
		xe.chooseTo(to);
		//click convert
		xe.clickConvert();
		//check results
		Assert.assertTrue(xe.getResult().startsWith(result), xe.getResult());

		driver.quit();
	}
	  
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	@DataProvider (name = "data-provider")
	public Object[][] dpMethod(){
		return new Object[][] {{"34.67", "USD" , "GBP", "30", "None"}, {"89", "EUR", "CAD", "116", "Chrome"}, {"67.50", "THB", "JPY", "259", "FireFox"},{"17", "MYR", "SEK", "4", "FireFox"}, {"89.95", "RUB", "USD", "1.4", "Chrome"}};
	}
	
	public WebDriver initializeBrowser(String B) {
		String BrowserType=B;
		ChromeOptions chromeOptions = new ChromeOptions();
        switch (BrowserType) {
            case "Chrome": 
        		WebDriverManager.chromedriver().setup();
        		driver = new ChromeDriver(chromeOptions);
        		break;
            case "FireFox":  
            	WebDriverManager.firefoxdriver().setup();
        		driver = new FirefoxDriver();
        		break;
            case "IE":
            	WebDriverManager.iedriver().setup();
            	driver = new InternetExplorerDriver();
            	break;
            default : 
        		WebDriverManager.chromedriver().setup();
        		driver = new ChromeDriver(chromeOptions);
        }
		return driver;
     }
	
}

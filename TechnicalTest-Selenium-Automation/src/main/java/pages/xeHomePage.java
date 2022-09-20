package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class xeHomePage {
	WebDriver driver;
	
	//Constructor 
	public xeHomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	//Locator for login button
	By amountInput = By.id("amount");
	
	//Method to input amount
	public void enterAmount(String amt) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOfElementLocated(amountInput));
		driver.findElement(amountInput).sendKeys(amt);
		Thread.sleep(500);
	}
	
	//acceptCookies button locator
	By acceptCookies = By.xpath("//button[contains(.,'Accept')]");
	
	//method to accept cookies
	public void clickAccept() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOfElementLocated(acceptCookies));
		driver.findElement(acceptCookies).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(acceptCookies));
		Thread.sleep(500);
	}
	
	//from currency
	By from = By.id("midmarketFromCurrency");
	public void chooseFrom(String fromCur) throws InterruptedException {
		driver.findElement(from).sendKeys(fromCur+Keys.ENTER);
		Thread.sleep(500);
	}
	
	//to currency
	By to = By.id("midmarketToCurrency");
	public void chooseTo(String toCur) throws InterruptedException{
		driver.findElement(to).sendKeys(toCur+Keys.ENTER);
		Thread.sleep(500);
	}
	
//	//currency choice by three letter country code in capitals
//	public void chooseCurrency(String USD){
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul//li[contains(.,'"+USD+"')]")));
//		driver.findElement(By.xpath("//ul//li[contains(.,'"+USD+"')]")).click();
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//ul//li[contains(.,'"+USD+"')]")));
//	}
	
	//converButton
	By convert = By.xpath("//form//button[contains(.,'Convert')]");
	public void clickConvert() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOfElementLocated(convert));
		driver.findElement(convert).click();
		Thread.sleep(500);
	}
	
	By result = By.xpath("//p[contains(@class,'result__Big')]");
	public String getResult() {
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOfElementLocated(result));
		return driver.findElement(result).getText();
		
	}
}

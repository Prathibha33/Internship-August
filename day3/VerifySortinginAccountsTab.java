package week1.day3;
//Login to Login | Salesforce 
//
//Click on toggle menu button from the left corner
//
//Click view All and click Sales from App Launcher
//
//Click on Accounts tab.
//
//Click sort arrow in the Account Name to sort in ascending order.

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class VerifySortinginAccountsTab {

	public static void main(String[] args) {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/ ");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("prathi@testleaf.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Supradi3149");
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[@class='slds-truncate']")).click();
		WebElement accountTab  = driver.findElement(By.xpath("//span[text()='Accounts']/.."));
		driver.executeScript("arguments[0].click();", accountTab);
		WebElement sortarrow = driver.findElement(By.xpath("//a[@class=\"toggle slds-th__action slds-text-link--reset \"]"));
		driver.executeScript("arguments[0].click();", sortarrow);


	}

}

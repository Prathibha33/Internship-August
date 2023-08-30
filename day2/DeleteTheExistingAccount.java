package week1.day2;
//Login to Login | Salesforce 
//
//Click on toggle menu button from the left corner
//
//Click view All and click Sales from App Launcher
//
//Click on Accounts tab. 
//
//Search the account 'Your Name'
//
//Click on the Dropdown icon and Select Delete
//
//Verify Whether account is Deleted using account Name.

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DeleteTheExistingAccount {

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
		driver.findElement(By.xpath("//input[@name=\"Account-search-input\"]")).sendKeys("Prathibha",Keys.ENTER);
		WebElement dropdown = driver.findElement(By.xpath("//a[contains(@class,'rowActionsPlaceHolder')]"));
		driver.executeScript("arguments[0].click();", dropdown);
		driver.findElement(By.xpath("//a[@title='Delete']")).click();
		driver.findElement(By.xpath("//button[@title=\"Delete\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"Account-search-input\"]")).sendKeys("Prathibha",Keys.ENTER);
		String text = driver.findElement(By.xpath("//span[text()='No items to display.']")).getText();
		if(text.contains("Prathibha")) {
			System.out.println("Account Prathibha was not deleted");
		}
		else {
			System.out.println("Account Prathibha was deleted");
		}
	}

}

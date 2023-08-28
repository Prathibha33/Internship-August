package week1.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CreateNewAccount {
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
		driver.findElement(By.xpath("//div[@title='New']")).click();
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Prathibha");
		WebElement ownership = driver.findElement(By.xpath("//button[contains(@aria-label,'Ownership')]"));
		driver.executeScript("arguments[0].click();", ownership);
		driver.findElement(By.xpath("//*[@data-value='Public']")).click();
		driver.findElement(By.xpath("//button[text()='Save']")).click();
	    String text= driver.findElement(By.xpath("//lightning-formatted-text[@class='custom-truncate']")).getText();
		if(text.contains("Prathibha")) {
			System.out.println("Account Prathibha was created");
		}
		else {
			System.out.println("Account Prathibha not was created");
		}
	}

}

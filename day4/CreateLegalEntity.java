package week1.day4;
//Login to  salesforce
//
//Click on the toggle menu button from the left corner
//
//Click View All and click Legal Entities from App Launcher
//
//Click on the Dropdown icon in the legal Entities tab
//
//Click on New Legal Entity
//Enter Name as 'Salesforce Automation by Your Name'7.Click save and verify Legal Entity Name

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//Enter Name as 'Salesforce Automation by Your Name'7.Click save and verify Legal Entity Name

public class CreateLegalEntity {

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
		WebElement viewall = driver.findElement(By.xpath("//button[text()='View All']"));
		driver.executeScript("arguments[0].click();", viewall);
		WebElement le = driver.findElement(By.xpath("//p[text()='Legal Entities']"));
		driver.executeScript("arguments[0].click();", le);
		driver.findElement(By.xpath("(//*[name()='svg' and @data-key=\"chevrondown\"])[6]")).click();
		WebElement Newlegal = driver.findElement(By.xpath("//span[text()='New Legal Entity']"));
		driver.executeScript("arguments[0].click();", Newlegal);
		driver.findElement(By.xpath("//input[@name=\"Name\"]")).sendKeys("Salesforce Automation by Prathibha");
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		String text = driver.findElement(By.xpath("//div[@data-aura-class=\"forceToastMessage\"]")).getText();
		if(text.contains("Salesforce Automation by Prathibha")) {
			System.out.println("New Legal Entity is created ");
		}
		else {
			System.out.println("New Legal Entity is not created");
		}

		

	}

}

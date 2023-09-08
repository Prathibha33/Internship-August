package week2.day3;
//Login to Login | Salesforce 
//
//Click on the toggle menu button from the left corner
//
//Click View All and click Dashboards from App Launcher
//
//Click on the New Dashboard option
//
//Enter Name as 'Salesforce Automation by Your Name ' and Click on Create.
//6.Click on Save and Verify Dashboard name.

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CreateANewDashboard {

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
		WebElement dashboards = driver.findElement(By.xpath("//p[text()='Dashboards']"));
		driver.executeScript("arguments[0].click();", dashboards);
		WebElement newdashboard = driver.findElement(By.xpath("//div[text()='New Dashboard']"));
		driver.executeScript("arguments[0].click();", newdashboard);
		WebElement frame = driver.findElement(By.xpath("//iframe[@title='dashboard']"));
		driver.switchTo().frame(frame);
		String name="Salesforce Automation by Prathibha";
		WebElement name1 = driver.findElement(By.xpath("//input[@aria-describedby='help-name-error']"));
		name1.sendKeys(name,Keys.ENTER);
		WebElement create = driver.findElement(By.xpath("//button[text()='Create']"));
		driver.executeScript("arguments[0].click();", create);
		String dashboardname = driver.findElement(By.xpath("//span[@class='slds-form-element__static slds-grid slds-grid_align-spread']")).getText();
		System.out.println(dashboardname);
		if(dashboardname.contains(name)){
			System.out.println("New Dashboard is created");
		}else {
			System.out.println("New Dashboard is not created");
		
		}
		driver.close();
		

		

		



	}

}

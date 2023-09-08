package week2.day3;
//Login to Login | Salesforce 
//
//Click on the toggle menu button from the left corner
//
//Click View All and click Dashboards from App Launcher
//
//Click on the Dashboards tab 
//
//Search the Dashboard 'Salesforce Automation by Your Name'
//
//Click on the Dropdown icon and Select Edit
//7.Click on the Edit Dashboard Properties icon
//
//Enter Description as 'SalesForce' and click on save.
//
//Click on Done and  Click on save in the popup window displayed.
//
//Verify the Description.

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class EditTheExistingDashboard {

	public static void main(String[] args) throws InterruptedException {
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
		String search1 ="Prathibha";
		WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search recent dashboards...']"));
		search.sendKeys(search1,Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='slds-button slds-button_icon-border slds-button_icon-x-small']")).click();
		WebElement edit = driver.findElement(By.xpath("//span[text()='Edit']"));
		driver.executeScript("arguments[0].click();", edit);
		WebElement frame = driver.findElement(By.xpath("//iframe[@title='dashboard']"));
		driver.switchTo().frame(frame);
		WebElement properties = driver.findElement(By.xpath("//span[text()='Edit Dashboard Properties']"));
		driver.executeScript("arguments[0].click();", properties);
		String name="Salesforce Automation by Prathibha";
		WebElement name1 = driver.findElement(By.xpath("//input[@id='dashboardNameInput']"));
		//name1.clear();
		name1.sendKeys(name,Keys.ENTER);
		String des = "SalesForce";
		WebElement description = driver.findElement(By.xpath("//input[@id='dashboardDescriptionInput']"));
		description.sendKeys(des);
		WebElement me = driver.findElement(By.xpath("//label[@class='slds-radio__label']"));
		driver.executeScript("arguments[0].click();", me);
		WebElement anotherperson = driver.findElement(By.xpath("//span[text()='Another person']"));
		driver.executeScript("arguments[0].click();", anotherperson);
		WebElement save = driver.findElement(By.xpath("(//button[text()='Save'])[2]"));
		driver.executeScript("arguments[0].click();", save);
		WebElement done = driver.findElement(By.xpath("//button[text()='Done']"));
		driver.executeScript("arguments[0].click();", done);
		WebElement save1 = driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand modalBtn2']"));
		driver.executeScript("arguments[0].click();", save1);
		String des1 = driver.findElement(By.xpath("//div[@class='slds-col slds-align-bottom']")).getText();
		System.out.println(des1);
		if(des1.equals(des)) {
			System.out.println("Description is edited");
		}else {
			System.out.println("Description is not edited");
		}

        driver.close();

	

		

		



	}
	

}

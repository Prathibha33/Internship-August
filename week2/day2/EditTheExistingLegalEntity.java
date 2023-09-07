package week2.day2;
//Login to  
//
//Click on the toggle menu button from the left corner
//
//Click View All and click Legal Entities from App Launcher
//
//Click on the legal Entities tab 
//
//Search the Legal Entity 'Salesforce Automation by Your Name'
//
//Click on the Dropdown icon and Select Edit7.Enter the Company name as 'Tetsleaf'.
//
//Enter Description as 'SalesForce'.9.Select Status as 'Active'
//
//Click on Save and Verify Status as Active

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class EditTheExistingLegalEntity {

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
		WebElement le = driver.findElement(By.xpath("//p[text()='Legal Entities']"));
		driver.executeScript("arguments[0].click();", le);
		WebElement le1 = driver.findElement(By.xpath("//span[text()='Legal Entities']"));
		driver.executeScript("arguments[0].click();", le1);
		WebElement searchname = driver.findElement(By.xpath("//input[@name='LegalEntity-search-input']"));
		searchname.sendKeys("Salesforce Automation by Prathibha",Keys.ENTER);
		Thread.sleep(2000);
		WebElement dd = driver.findElement(By.xpath("//div[@class='forceVirtualActionMarker forceVirtualAction']/a[@role='button']"));
        driver.executeScript("arguments[0].click();", dd);
		WebElement edit = driver.findElement(By.xpath("//a[@data-target-selection-name='sfdc:StandardButton.LegalEntity.Edit']"));
		driver.executeScript("arguments[0].click();", edit);
		WebElement cn = driver.findElement(By.xpath("//input[@name='CompanyName']"));
		cn.clear();
		cn.sendKeys("Testleaf");
		WebElement dp = driver.findElement(By.xpath("(//textarea[@class='slds-textarea'])[2]"));
		dp.clear();
		dp.sendKeys("SalesForce");
		WebElement statusdd = driver.findElement(By.xpath("//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value']"));
		driver.executeScript("arguments[0].click();", statusdd);
		WebElement status= driver.findElement(By.xpath("//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value']"));
		driver.executeScript("arguments[0].click();", status);
		WebElement save = driver.findElement(By.xpath("//button[@name='SaveEdit']"));
		driver.executeScript("arguments[0].click();", save);
//		String text = driver.findElement(By.xpath("//span[@data-aura-class='forceActionsText']")).getText();
//		System.out.println(text);
//		if(text.contains("Prathibha")) {
//			System.out.println("Salesforce automation by Prathibha was saved");
//		}else {
//			System.out.println("Salesforce automation by Prathibha was not saved");
//		}
		searchname.sendKeys("Salesforce Automation by Prathibha",Keys.ENTER);
		WebElement firstaccount = driver.findElement(By.xpath("//a[@title='Salesforce Automation by Prathibha']"));
		driver.executeScript("arguments[0].click();", firstaccount);
		String status1= driver.findElement(By.xpath("(//div[@class='slds-form-element__control'])[5]")).getText();
		System.out.println(status1);
		if(status1.contains("Active")) {
			System.out.println("status is active");
		}else {
			System.out.println("status is not active");
		}
		driver.close();



		

		



	
}}

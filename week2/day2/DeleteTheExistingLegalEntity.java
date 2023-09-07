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
//Click on the Dropdown icon and Select Delete7.Click on the Delete option in the displayed popup window.
//
//Verify Whether Legal Entity is Deleted using Legal Entity Name

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DeleteTheExistingLegalEntity {

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
        WebElement delete = driver.findElement(By.xpath("//a[@data-target-selection-name='sfdc:StandardButton.LegalEntity.Delete']"));
        driver.executeScript("arguments[0].click();", delete);
        WebElement delete1 = driver.findElement(By.xpath("//span[text()='Delete']"));
        driver.executeScript("arguments[0].click();", delete1);
//        String toastermessage = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
//        System.out.println(toastermessage);
//        if(toastermessage.equals(searchname)) {
//        	System.out.println("legal entity is deleted");
//        }else {
//        	System.out.println("legal entity is not deleted");
//        }
        searchname.sendKeys("Salesforce Automation by Prathibha",Keys.ENTER);
        String deletemessage = driver.findElement(By.xpath("//lightning-formatted-rich-text[@class='slds-rich-text-editor__output']")).getText();
        System.out.println(deletemessage);
        if(deletemessage.equals(searchname)) {
        	System.out.println("legal entity is not deleted");
        }else {
        	System.out.println("legal entity is deleted");
        }
        driver.close();
        



	}

}

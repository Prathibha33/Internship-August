package week5.day1;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteTheAttachmentFromTheExistingCompaign {
public static void main(String[] args) throws InterruptedException, IOException {
		
	    //Launch the Chromebrowser
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		
		//Maximise the window
		driver.manage().window().maximize();
		
		//Launch the "https://login.salesforce.com/ "
		driver.get("https://login.salesforce.com/ ");
		
		//enter the username as "prathi@testleaf.com"
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("prathi@testleaf.com");
		
		//enter the password as "Supradi3149"
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Supradi3149");
		
		//click login
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='Login']"))).click();
		
		//Click on the toggle menu button from the left corner
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='slds-icon-waffle']"))).click();
		
		//Click View All
		WebElement viewall = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='View All']")));
		driver.executeScript("arguments[0].click();", viewall);
		
		//Click on sales
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Sales']"))).click();
		
		//Click on Campaigns
		WebElement campaigns = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Campaigns']")));
		driver.executeScript("arguments[0].click();", campaigns);
		
		//Click on August Automation link
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='August Automation']"))).click();
		
		//Click on view all
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='view-all-label']"))).click();
		
		//Click on drop down for recently attached document
		WebElement dd = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Show Actions'])[2]")));
		driver.executeScript("arguments[0].click();", dd);
		
		//Select delete option from drop down
		WebElement delete = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@title='Delete']")));
		driver.executeScript("arguments[0].click();", delete);
		
		//Click on delete
		WebElement delete1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Delete']")));
		driver.executeScript("arguments[0].click();", delete1);
		
		//verify the tMsg
		String tMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='Success']"))).getText();
		System.out.println(tMsg);
		
		if(tMsg.contains("Success")) {
			System.out.println("File is deleted");
		}else {
			System.out.println("File is not deleted");

		}
		
		//Close the Browser
		driver.close();
		
		







}
}

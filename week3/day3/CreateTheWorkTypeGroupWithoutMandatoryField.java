package week3.day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateTheWorkTypeGroupWithoutMandatoryField {
	public static void main(String[] args) throws InterruptedException {
		
	    //Launch the Chromebrowser
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
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
		
		//click Work Type Groups from App Launcher
		WebElement wtg = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Work Type Groups']")));
		driver.executeScript("arguments[0].click();", wtg);
		
		//Click on the Dropdown icon in the Work Type Groups tab
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[name()='svg' and @data-key='chevrondown'])[6]"))).click();
		
		//Click on New Work Type Group
		WebElement nwt = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='New Work Type Group']")));
		driver.executeScript("arguments[0].click();", nwt);
		
		// Click save
		WebElement save = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Save']")));
		driver.executeScript("arguments[0].click();", save);
		
		//verify the error message
		String errormsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='fieldLevelErrors']"))).getText();
		System.out.println(errormsg);
		if(errormsg.contains("Name")) {
			System.out.println("we cannot create new work type group without mandatory field");
		}else {
			System.out.println("we can create new work type group without mandatory field");

		}
		
		//Close the Browser
		driver.close();

}
}

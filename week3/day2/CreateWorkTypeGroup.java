package week3.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateWorkTypeGroup {
	
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
	
	// Enter Work Type Group Name as 'Salesforce Automation by Your Prathibha'
	String search = "Salesforce Automation by Prathibha";
	WebElement search1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='Name']")));
	search1.sendKeys(search,Keys.ENTER);
	
	//Change grouptype to capacity
	WebElement dd1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Group Type, Default']")));
	driver.executeScript("arguments[0].click();", dd1);
	WebElement capacity = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//lightning-base-combobox-item[@data-value='Capacity']")));
	driver.executeScript("arguments[0].click();", capacity);
	
	// Click save
	WebElement save = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Save']")));
	driver.executeScript("arguments[0].click();", save);
	
	//verify Work Type Group Name
	String toastermsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='Success']"))).getText();
	System.out.println(toastermsg);
	if(toastermsg.contains(search)) {
		System.out.println("New work type group is created");
	}else {
		System.out.println("New work type group is not created");
		
	//close the browser
	driver.close();	

	}


	
	

}
}

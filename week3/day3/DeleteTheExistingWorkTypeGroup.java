package week3.day3;
//Login to Login | Salesforce 
//
//Click on the toggle menu button from the left corner
//
//Click View All and click Work Type Groups from App Launcher
//
//Click on the Work Type Group tab 
//
//Search the Work Type Group 'Salesforce Automation by Your Name'
//
//Click on the Dropdown icon and Select Delete
//
//Click on the Delete option in the displayed popup window.
//
//Verify Whether Work Type group is Deleted using Work Type Group Name

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteTheExistingWorkTypeGroup {
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
		
		//Click on the Work Type Group tab
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Work Type Groups']"))).click();
		
		//Search the Work Type Group 'Salesforce Automation by Your Prathibha'
		String search = "Prathibha";
		WebElement search1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search this list...']")));
		search1.sendKeys(search, Keys.ENTER);
		
		//Click on the Dropdown icon
		Thread.sleep(3000);
		WebElement dd = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-aura-class='forceVirtualAction']")));
		dd.click();
		
		//Select Delete
		WebElement delete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Delete']")));
		driver.executeScript("arguments[0].click();", delete);
		
		//Click on the Delete option in the displayed popup window.
		WebElement delete1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Delete']")));
		delete1.click();
		
		//Verify Whether Work Type group is Deleted using Work Type Group Name
        String toastermsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='Success']"))).getText();
        System.out.println(toastermsg);
        if(toastermsg.contains(search)) {
        	System.out.println("Work type group Prathibha is deleted");
        }else {
        	System.out.println("Work type group Prathibha is not deleted");
        
        //Close the browser
        driver.close();

        }
        	

}
}

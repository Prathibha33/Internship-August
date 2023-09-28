package week5.day3;

import java.io.IOException;
import java.time.Duration;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

public class CreateNewCase {
public static void main(String[] args) throws InterruptedException, IOException {
		
	    //Launch the Chrome browser
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		Faker faker = new Faker(new Locale("en","IN"));
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		
		//Maximise the window
		driver.manage().window().maximize();
		
		//Launch the "https://login.salesforce.com/ "
		driver.get("https://login.salesforce.com/ ");
		
		//enter the user name as "prathi@testleaf.com"
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
				
		//Click on new button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='New']"))).click();
		
		//Enter random campaign name
		String cName = faker.name().fullName();
		WebElement cName1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class=' input']")));
		cName1.sendKeys(cName);
		
		//Click on save
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Save'])[2]"))).click();
		
		//Click on new case
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='New Case']"))).click();
		
		//Click on search contacts
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='autocompleteWrapper slds-grow']"))).click();
		
		//Select New contact
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@title='New Contact']"))).click();
		
		
		//Choose the salutation as Mrs, from drop down
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@data-aura-class='uiPopupTrigger'])[6]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Mrs.']"))).click();
				
		//Enter the first name
		String fName = "Prathibha";
		WebElement fName1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='First Name']")));
		fName1.sendKeys(fName);
						
		//Enter the last name
		String lName = "K";
		WebElement lName1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Last Name']")));
		lName1.sendKeys(lName);
				
		//Click on save button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Save'])[4]"))).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@data-key='success']")));
		
		//Retrieve the status as new
		String status = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='select']"))).getText();
		System.out.println(status);
		
		//Enter description as "New case was created"
		WebElement description = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@role='textbox']")));
		description.sendKeys("New case was created");
		
		//click on save button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Save'])[3]"))).click();
		
		//Retrieve the case number from toaster message
		String caseNo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-key='success']"))).getText();
		System.out.println(caseNo);
		String caseNo1 = caseNo.replaceAll("[^0-9]", "");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@data-key='success']")));
		
		//Click on the toggle menu button from the left corner
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='slds-icon-waffle']"))).click();
				
		//Click View All
		WebElement viewall1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='View All']")));
		driver.executeScript("arguments[0].click();", viewall1);
				
		//Click on sales
		WebElement sales = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type='search'])[3]")));
		sales.sendKeys("cases", Keys.ENTER);
		
		//click on cases
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//mark[text()='Cases']"))).click();
		
		//search for case with case number
		WebElement caseNu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='Case-search-input']")));
		caseNu.sendKeys(caseNo1,Keys.ENTER);
		
		//Verify the new case was created
		String newCase = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-aura-class='forceInlineEditCell']"))).getText();
		System.out.println(newCase);
		if(newCase.contains(caseNo1)) {
			System.out.println("New case was created");
		}else {
			System.out.println("New case was not created");
			
		//Close the browser
		driver.close();	

		}
		
		








}
}

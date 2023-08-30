package week1.day2;

//Launch the app
//
//Click Login
//
//Login with the credentials
//
//Click on the App Laucher Icon left to Setup
//
//Click on Accounts
//
//Search for the Account Using the unique account name created by you 
//
//Click on the displayed Account Dropdown icon and select Edit
//
//Select Type as Technology Partner
//
//Select Industry as Healthcare
//10)Enter Billing Address
//11)Enter Shipping Address
//12)Select Customer Priority as Low
//13)Select SLA as Silver

//Select Active as NO 
//
//Enter Unique Number in Phone Field
//16)Select Upsell Oppurtunity as No
//17)Click on save and verfiy Phone number
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class EditTheExistingAccount {

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
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[@class='slds-truncate']")).click();
		WebElement accountTab  = driver.findElement(By.xpath("//span[text()='Accounts']/.."));
		driver.executeScript("arguments[0].click();", accountTab);
		driver.findElement(By.xpath("//input[@name=\"Account-search-input\"]")).sendKeys("Prathibha",Keys.ENTER);
		WebElement dropdown = driver.findElement(By.xpath("//div[@data-aura-class='forceVirtualAction']/*"));
		driver.executeScript("arguments[0].click();", dropdown);
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		WebElement dropdown1 = driver.findElement(By.xpath("(//div[@class=\"slds-combobox slds-dropdown-trigger slds-dropdown-trigger_click\"])[3]"));
		driver.executeScript("arguments[0].click();", dropdown1);
		driver.findElement(By.xpath("//span[@title=\"Technology Partner\"]")).click();
        WebElement dropdown2 = driver.findElement(By.xpath("//button[@id=\"combobox-button-207\"]"));
		driver.executeScript("arguments[0].click();", dropdown2);
		WebElement dropdown3 = driver.findElement(By.xpath("//span[@title=\"Healthcare\"]"));
		driver.executeScript("arguments[0].click();", dropdown3);
		driver.findElement(By.xpath("//textarea[@name=\"street\"]")).sendKeys("1,street");
		driver.findElement(By.xpath("//input[@autocomplete=\"address-level2\"]")).sendKeys("1, city");
		driver.findElement(By.xpath("//input[@autocomplete=\"address-level1\"]")).sendKeys("1, state");
		driver.findElement(By.xpath("//input[@autocomplete=\"postal-code\"]")).sendKeys("1, 1212");
		driver.findElement(By.xpath("//input[@autocomplete=\"country\"]")).sendKeys("1, country");
		
		driver.findElement(By.xpath("(//textarea[@name=\"street\"])[2]")).sendKeys("9, Downstreet");
		driver.findElement(By.xpath("(//input[@autocomplete=\"address-level2\"])[2]")).sendKeys("1, city");
		driver.findElement(By.xpath("(//input[@autocomplete=\"address-level1\"])[2]")).sendKeys("1, state");
		driver.findElement(By.xpath("(//input[@autocomplete=\"postal-code\"])[2]")).sendKeys("1, 1212");
		driver.findElement(By.xpath("(//input[@autocomplete=\"country\"])[2]")).sendKeys("1, country");
        WebElement dropdown4 = driver.findElement(By.xpath("//button[@id=\"combobox-button-244\"]"));
		driver.executeScript("arguments[0].click();", dropdown4);
		WebElement dropdown5 = driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value=\"Low\"]"));
		driver.executeScript("arguments[0].click();", dropdown5);
		WebElement dd6 = driver.findElement(By.xpath("//button[@id=\"combobox-button-252\"]"));
		driver.executeScript("arguments[0].click();", dd6);
		WebElement dd7 = driver.findElement(By.xpath("//lightning-base-combobox-item[@id=\"combobox-button-252-2-252\"]"));
		driver.executeScript("arguments[0].click();", dd7);
		WebElement dd8 = driver.findElement(By.xpath("//button[@id=\"combobox-button-281\"]"));
		driver.executeScript("arguments[0].click();", dd8);
		WebElement dd9 = driver.findElement(By.xpath("//lightning-base-combobox-item[@id=\"combobox-button-281-1-281\"]"));
		driver.executeScript("arguments[0].click();", dd9);
		WebElement phno = driver.findElement(By.xpath("//input[@id='input-165']"));
		phno.clear();
		phno.sendKeys("9988998898");
		WebElement dd10 = driver.findElement(By.xpath("//button[@id=\"combobox-button-272\"]"));
		driver.executeScript("arguments[0].click();", dd10);
		WebElement dd11 = driver.findElement(By.xpath("//lightning-base-combobox-item[@id=\"combobox-button-272-2-272\"]"));
		driver.executeScript("arguments[0].click();", dd11);
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		String text = driver.findElement(By.xpath("//span[@class=\"forceOutputPhone slds-truncate\"]")).getText();
		if(text.contains("9988998898")) {
			System.out.println("Phone number is updated");
		}
		else {
			System.out.println("Phone number is not updated");
		}
	}			
		







		

	}



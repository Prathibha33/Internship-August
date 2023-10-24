package day31ExcelIntegration;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class VerifyTheEmailTask extends BaseClassDay31{
	@BeforeTest
	public void setFile() {
		fileName="VerifyEmailTask";
	}
	
@Test(dataProvider = "fetchData")	
public void runVerifyTheEmailTask(String firstName, String lastName, String company ) throws InterruptedException, IOException {
		
	    
		
		//Click on the toggle menu button from the left corner
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='slds-icon-waffle']"))).click();
		
		//Click View All
		WebElement viewall = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='View All']")));
		driver.executeScript("arguments[0].click();", viewall);
		
		//Click on sales
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Sales']"))).click();
		
		//Click on leads
		WebElement leads = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Leads']")));
		driver.executeScript("arguments[0].click();", leads);
		
		//Click on new button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='New']"))).click();
		
		//click on salutation dropdown
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='slds-combobox__form-element slds-input-has-icon slds-input-has-icon_right']"))).click();
		
		//Select Mrs from dropdown
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Mrs.']"))).click();
		
		//Enter the last name
		WebElement firstName1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='First Name']")));
		firstName1.sendKeys(firstName);
		
		//Enter the last name
		WebElement lastName1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Last Name']")));
		lastName1.sendKeys(lastName);
		
		//Enter Company name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='Company']"))).sendKeys(company);
		
		//Click the save button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Save']"))).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[text()='Save']")));

		
		//Click on new task
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@value='NewTask']"))).click();
		
		//Click on Subject
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='slds-combobox__input slds-input']"))).click();
		
		//Select email from dropdown
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@title='Email'])[2]"))).click();
		
		//Click on due date
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@class='slds-input'])[2]"))).click();
		
		//Select today's date
		WebElement date = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='slds-is-today']")));
		driver.executeScript("arguments[0].click();", date);

		
		//Click save button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Save'])[3]"))).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//span[text()='Save'])[3]")));

		
		//Click on email
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@value='SendEmail']"))).click();
		
		//Click send button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@data-aura-class='uiButton'])[8]"))).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//button[@data-aura-class='uiButton'])[8]")));
		
		//Click on email drop down
		WebElement dd = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Show more actions'])[3]")));
		driver.executeScript("arguments[0].click();",dd);
		
		//Click on Email
		//WebElement email = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Email']")));
		//driver.executeScript("arguments[0].click();", email);
		
		//click create follow task drop down
		//WebElement dd1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[@data-aura-class='oneActionsDropDown'])[2]")));
		//driver.executeScript("arguments[0].click();", dd1);

		
		//Select Change status
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@title='Change Status'])[2]"))).click();
		
		//Select dd from status
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Not Started']"))).click();
		
		//Select completed option
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Completed']"))).click();
		
		//Click save button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Save'])[3]"))).click();
		
		//Verify the email task is completed
		String CompletedEmailTask = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='You had a task']"))).getText();
		
		System.out.println(CompletedEmailTask);
		if(CompletedEmailTask.contains("had a task")) {
			System.out.println("email task is completed");
		}else {
			System.out.println("email task is not completed");

		}
		
		//Get the Title
		System.out.println(driver.getTitle());;
		
		



}

}

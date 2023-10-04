package week6.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class CreateFollowUpEvent extends BaseClass {
	@Test(dependsOnMethods = "week6.day1.CreateANewTask.runCreateANewTask")
	public void runCreateFollowUpEvent() throws InterruptedException {
		
		//Click on drop down of first result
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-aura-class='forceVirtualAction']"))).click();
		
		//Click on create follow up event
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Create Follow-Up Event']"))).click();
		
		//Choose Subject as meeting
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-haspopup='listbox']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@title='Meeting']"))).click();
		
		//Choose start date as today's date
		WebElement startDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Select a date for Date']")));
		driver.executeScript("arguments[0].click();", startDate);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='slds-is-today slds-is-selected']"))).click();
		
		//Choose end date as 13 days after today
		WebElement endDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@title='Select a date for Date'])[2]")));
		driver.executeScript("arguments[0].click();", endDate);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td[@class='slds-is-today slds-is-selected']/following::td)[13]"))).click();
		Thread.sleep(2000);
		
		//Click on save button
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Save'])[2]"))).click();





		
	}

}

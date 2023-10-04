package week6.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class CreateFollowUpTask extends BaseClass{
	
	@Test(dependsOnMethods = "week6.day1.CreateANewTask.runCreateANewTask")
	public void runCreateFollowUpTask() {
		
		//Click on drop down of first result
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-aura-class='forceVirtualAction']"))).click();
		
		//Click on create follow up task
		WebElement createFUT = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-aura-class='forceActionLink']")));
		driver.executeScript("arguments[0].click();", createFUT);

		//Choose Subject as call
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-haspopup='listbox']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@title='Call']"))).click();
		
		//Choose priority as high
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='select'])[2]"))).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='High']"))).click();
	     
	    //Choose status as in progress
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='select']"))).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='In Progress']"))).click();
	    
	    //Choose status as in progress
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='select']"))).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='In Progress']"))).click();
	    
//	    //Select Contacts from name drop down
//	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='uiImage'])[6]"))).click();
//	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Contacts']"))).click();
//	     
//	    //Choose first displayed contact
//	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@title='Search Contacts']"))).click();
//	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@data-aura-class='uiAutocompleteOption forceSearchInputLookupDesktopOption']"))).click();
//	     
//	    //Select Products from related to drop down
//	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@data-aura-class='forceEntityIcon'])[44]"))).click();
//	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@title='Products']"))).click();
//	     
//	    //Choose first displayed product
//	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@title='Search Products']"))).click();
//	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@title='sample']"))).click();
	    
	    //Click on save button
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Save'])[2]"))).click();
	}

}

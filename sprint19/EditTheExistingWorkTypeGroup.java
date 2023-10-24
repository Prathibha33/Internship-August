package sprint19;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class EditTheExistingWorkTypeGroup extends BaseClassSp19{
	
	@Test(dependsOnMethods = "sprint19.CreateWorkTypeGroup.runCreateWorkTypeGroup")
	public void runEditTheExistingWorkTypeGroup() throws InterruptedException {
		
	    
		
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
		WebElement dd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='slds-icon_container slds-icon-utility-down']")));
		driver.executeScript("arguments[0].click();", dd);

		
		//Select Edit
		Thread.sleep(3000);
		WebElement edit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Edit']")));
		driver.executeScript("arguments[0].click();", edit);
		
		//Enter Description as 'Automation'
		WebElement des = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@class='slds-textarea']")));
		des.clear();
		des.sendKeys("Automation");
		
		//Change grouptype to capacity
		Thread.sleep(2000);
		WebElement dd1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='slds-combobox slds-dropdown-trigger slds-dropdown-trigger_click']")));
		driver.executeScript("arguments[0].click();", dd1);
		WebElement capacity = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//lightning-base-combobox-item[@data-value='Capacity']")));
		driver.executeScript("arguments[0].click();", capacity);
		
		//Click on Save
		WebElement save = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Save']")));
		save.click();
		
		//verify the toaster message
		String toastermsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='Success']"))).getText();
		System.out.println(toastermsg);
		if(toastermsg.contains(search)) {
			System.out.println("Existing work type group is edited");
		}else {
			System.out.println("Existing work type group is not edited");

		}

		



}
	
}

package sprint19;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class DeleteTheExistingWorkTypeGroup extends BaseClassSp19{
	
@Test(dependsOnMethods = "sprint19.EditTheExistingWorkTypeGroup.runEditTheExistingWorkTypeGroup")	
public void runDeleteTheExistingWorkTypeGroup() throws InterruptedException {
		
	    
		
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
		//Thread.sleep(3000);
		WebElement dd = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-aura-class='forceVirtualAction']")));
		wait.until(ExpectedConditions.stalenessOf(dd));
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
        
       

        }
        	

}
}

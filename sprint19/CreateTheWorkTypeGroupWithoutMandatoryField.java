package sprint19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class CreateTheWorkTypeGroupWithoutMandatoryField extends BaseClassSp19 {
	
	@Test
	public void runCreateTheWorkTypeGroupWithoutMandatoryField() throws InterruptedException {
		
	   
		
		//Click on the toggle menu button from the left corner
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='slds-icon-waffle']"))).click();
		
		//Click View All
		WebElement viewall = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='View All']")));
		driver.executeScript("arguments[0].click();", viewall);
		
		//click Work Type Groups from App Launcher
		WebElement wtg = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Work Type Groups']")));
		driver.executeScript("arguments[0].click();", wtg);
		
		//Click on the Dropdown icon in the Work Type Groups tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='slds-context-bar__label-action slds-p-left--none slds-p-right--x-small']"))).click();
		
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
		
		

}
}

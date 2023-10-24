package sprint19;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class DeleteTheAttachmentFromTheExistingCampaign extends BaseClassSp19{
	
@Test(dependsOnMethods = "sprint19.AttachFilesToTheExistingCampaign.runAttachFilesToTheExistingCampaign")	
public void runDeleteTheAttachmentFromTheExistingCampaign() throws InterruptedException, IOException {
		
	   
		
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
		
		//Click on August Automation link
		WebElement aA = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='August Automation']")));
		driver.executeScript("arguments[0].click();", aA);

		//Click on view all
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='view-all-label']"))).click();
		
		//Click on drop down for recently attached document
		WebElement dd = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h1[text()='Attachments']/following::div[@class='forceVirtualActionMarker forceVirtualAction']")));
		driver.executeScript("arguments[0].click();", dd);
		
		//Select delete option from drop down
		WebElement delete = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@title='Delete']")));
		driver.executeScript("arguments[0].click();", delete);
		
		//Click on delete
		WebElement delete1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Delete']")));
		driver.executeScript("arguments[0].click();", delete1);
		
		//verify the tMsg
		String tMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='Success']"))).getText();
		System.out.println(tMsg);
		
		if(tMsg.contains("Success")) {
			System.out.println("File is deleted");
		}else {
			System.out.println("File is not deleted");

		}
		
		
		
		







}
}

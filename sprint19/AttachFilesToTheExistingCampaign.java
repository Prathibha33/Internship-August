package sprint19;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class AttachFilesToTheExistingCampaign extends BaseClassSp19 {

@Test(dependsOnMethods = "sprint19.CreateANewCampaign.runCreateANewCampaign")	
public void runAttachFilesToTheExistingCampaign() throws InterruptedException, IOException {
	
		
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
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='August Automation']"))).click();
		
		//Click on upload file and upload file from local folder
		WebElement uLFile = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='file']")));
		uLFile.sendKeys("C:\\Prathibha\\TestLeaf\\WORK\\dummy.pdf");
		
		//Click on Done button
		WebElement done = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Done']")));
		done.click();
		
        //Verify the file name displayed as link
		String fName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'slds-show_inline-block')])[2]"))).getText();
        
        System.out.println(fName);
        
        if(fName.contains("dummy")) {
        	System.out.println("filename displayed as link");
        	
        }else {
        	System.out.println("filename not displayed as link");

        }
        
        

		
		
		



}
}

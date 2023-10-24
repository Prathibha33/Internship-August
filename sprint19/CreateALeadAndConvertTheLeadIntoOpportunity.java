package sprint19;


import java.io.File;

import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class CreateALeadAndConvertTheLeadIntoOpportunity extends BaseClassSp19 {
	
@Test	
public void runCreateALeadAndConvertTheLeadIntoOpportunity() throws InterruptedException, IOException {
	
	    //Click on the toggle menu button from the left corner
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='slds-icon-waffle']"))).click();
			
		//Click View All
		WebElement viewall = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='View All']")));
		driver.executeScript("arguments[0].click();", viewall);
		
		
		//Click on the marketing
		WebElement marketing = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Marketing']")));
		marketing.click();
		
		//Click on the leads dropdown
		WebElement dd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[name()='svg' and @data-key='chevrondown'])[2]")));
		dd.click();
		
		//Click on Newlead
		WebElement newlead = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='New Lead']")));
		driver.executeScript("arguments[0].click();", newlead);
		
		//Click on Salutation dropdown
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='slds-combobox slds-dropdown-trigger slds-dropdown-trigger_click']"))).click();
		
		//Select Mrs. from dropdown
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Mrs.']"))).click();
		
		//Enter firstname
		String name = "Prathibha";
		WebElement fn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='First Name']")));
		fn.sendKeys(name,Keys.ENTER);
		
		//Enter lastname
		WebElement ln = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Last Name']")));
		ln.sendKeys("K",Keys.ENTER);
		
		//Enter company name
		WebElement company = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='Company']")));
		company.sendKeys("Testleaf", Keys.ENTER);
		
		//Click the save button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Save']"))).click();
		
		//click on submit for approval dropdown
		WebElement dd2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='slds-button slds-button_icon-border-filled']")));
		driver.executeScript("arguments[0].click();", dd2);
		
		//Select convert from dropdown
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Convert']"))).click();
		
		//Click on radio button near opportunity name
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Create New'])[3]"))).click();
		
		//Click on opportunity name input field
		String opname = "Kottapalli";
		WebElement opportunityname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Opportunity Name']/following::input")));
		opportunityname.click();
		opportunityname.clear();
		opportunityname.sendKeys(opname,Keys.ENTER);
		
		//Click on convert button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Convert']"))).click();
		
		//click on go to leads button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Go to Leads']"))).click();
		
		//Search the verified lead name in the Search box
		WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search this list...']")));
		search.sendKeys(name,Keys.ENTER);
		
		//verify the text ‘No items to display’
		String text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='No items to display.']"))).getText();
		System.out.println(text);
		if(text.contains("No items")) {
			System.out.println("Text is verified");
		}else {
			System.out.println("Text is not verified");

		}
		
		//Navigate to the Opportunities tab
		WebElement opportunity = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Opportunities']")));
		driver.executeScript("arguments[0].click();", opportunity);
		
		//Search the opportunity name created
		WebElement search1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search this list...']")));
		search1.sendKeys(opname,Keys.ENTER);
		
		//click on the created opportunity name
		WebElement opname1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Kottapalli']")));
		driver.executeScript("arguments[0].click();", opname1);
		
		
		//Take a snap of the web page
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Testleaf']")));
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
        File destination = new File("./Snapshot/img1.jpg");
        FileUtils.copyFile(screenshotAs, destination);
        
        System.out.println("snapshot saved successfully");
        
        
       


		

}
}

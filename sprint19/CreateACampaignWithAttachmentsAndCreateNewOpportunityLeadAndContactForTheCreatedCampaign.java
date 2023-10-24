package sprint19;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class CreateACampaignWithAttachmentsAndCreateNewOpportunityLeadAndContactForTheCreatedCampaign extends BaseClassSp19{
	
@Test	
public void runCreateACampaignWithAttachmentsAndCreateNewOpportunityLeadAndContactForTheCreatedCampaign() throws InterruptedException, IOException {
		
	    
		
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
				
		//Click on new button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='New']"))).click();
		
		//Enter random campaign name
		String cName = faker.name().fullName();
		WebElement cName1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class=' input']")));
		cName1.sendKeys(cName);
		
		//Click on Start date
		WebElement sDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Date Picker']")));
		driver.executeScript("arguments[0].click();", sDate);
				
		//Choose tomorrow date
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(@class, 'is-today')]/following-sibling::td"))).click();
				
		//Click on end date
		WebElement eDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Date Picker'])[2]")));
		driver.executeScript("arguments[0].click();", eDate);
						
		//Choose day after tomorrow date
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td[contains(@class, 'is-today')]/following-sibling::td)[2]"))).click();
		
		//Click on save
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Save'])[2]"))).click();
		
		//Click on upload file and upload file from local folder
		WebElement uLFile = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='file']")));
		uLFile.sendKeys("C:\\Prathibha\\TestLeaf\\WORK\\dummy.pdf");
				
		//Click on Done button
		WebElement done = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Done']")));
		done.click();
		
		//Click on New button, near opportunities
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@title='New'])[2]"))).click();
        
        //Enter random opportunity name
        String oName = faker.name().fullName();
        WebElement oName1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='Name']")));
        oName1.sendKeys(oName);
        
        //Click on close date
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span//input[@name='CloseDate']"))).click();
        
        //Choose tomorrow date
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(@class, 'is-today')]/following-sibling::td"))).click();

        //Click on stage drop down
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class, 'slds-combobox__input')]"))).click();
        
        //Choose need analysis from drop down
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@title='Needs Analysis']"))).click();
        
        //click on save button
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@name='SaveEdit']"))).click();
        
        //Click on opportunities tab
        WebElement opportunities = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Opportunities']")));
        driver.executeScript("arguments[0].click();", opportunities);
        
        //Search Opportunity name
        WebElement randomOpName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='Opportunity-search-input']")));
        randomOpName.sendKeys(oName,Keys.ENTER);
        
        //Verify the Opportunity name 
        Thread.sleep(2000);
        String opName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-aura-class='forceOutputLookup']"))).getText();
        System.out.println(opName);
        if(opName.contains(oName)) {
        	System.out.println("New opportunity is created for the campaign");
        }else {
        	System.out.println("New opportunity is not created for the campaign");
        	
        }
        
        //Click on Campaigns
      	WebElement campaigns1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Campaigns']")));
      	driver.executeScript("arguments[0].click();", campaigns1);
      	
      	//Click on newly created campaign link
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-aura-class='forceOutputLookup']"))).click();
		
		//Click on add leads near campaign members
		Thread.sleep(2000);
		WebElement addLeads = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Add Leads']")));
      	driver.executeScript("arguments[0].click();", addLeads);
      	
      	//Click on search leads
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@title='Search Leads']"))).click();
		
		//Click on new lead
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@title='New Lead']"))).click();
		
		//Choose the salutation as Mrs, from drop down
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@data-aura-class='uiPopupTrigger'])[5]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Mrs.']"))).click();
		
		//Enter the first name
		String fName = faker.name().firstName();
		WebElement fName1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='First Name']")));
		fName1.sendKeys(fName);
		
		//Enter the last name
		String lName = faker.name().firstName();
		WebElement lName1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Last Name']")));
		lName1.sendKeys(lName);
		
		//Enter company name Test leaf
		WebElement cName2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type='text'])[4]")));
		cName2.sendKeys("Testleaf");
		
		//Click on save button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Save'])[3]"))).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@aria-label='Success']")));
		
		
		//Click on next button
		Thread.sleep(2000);
		WebElement next = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Next']")));
      	driver.executeScript("arguments[0].click();", next);
      	
      	//Click on submit
      	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Submit']"))).click();
      	 
      	 
        //Click on leads tab
      	WebElement leads = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Leads']")));
      	driver.executeScript("arguments[0].click();", leads);
      	
      	//Search lead name by first name
      	WebElement lName2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='Lead-search-input']")));
        lName2.sendKeys(fName,Keys.ENTER);
        
        //Verify the lead name
        String lName3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-aura-class='forceOutputLookup']"))).getText();
        System.out.println(lName3);
        
        if(lName3.contains(fName)) {
           System.out.println("New lead is created for the campaign");
        }else {
           System.out.println("New lead is not created for the campaign");

        }
        
        //Click on Campaigns
      	WebElement campaigns2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Campaigns']")));
      	driver.executeScript("arguments[0].click();", campaigns2);
      	
      	//Click on newly created campaign link
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//th[@data-aura-class='forceInlineEditCell']"))).click();
		
		//Click on add contacts near campaign members
		WebElement addContacts = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li/a[@title='Add Contacts']")));
		  driver.executeScript("arguments[0].click();",addContacts);
		
		//Click on search contacts
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@title='Search Contacts']"))).click();
		
		//Click on new contact
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@title='New Contact']"))).click();
		
		//Choose the salutation as Mrs, from drop down
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@data-aura-class='uiPopupTrigger'])[5]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Mrs.']"))).click();
		
		//Enter the first name
		String fName3 = faker.name().firstName();
		WebElement fName4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='First Name']")));
		fName4.sendKeys(fName3);
				
		//Enter the last name
		String lName4 = faker.name().firstName();
		WebElement lName5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Last Name']")));
		lName5.sendKeys(lName4);
		
		//Click on save button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Save'])[3]"))).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@aria-label='Success']")));
		
		//Click on next button
		Thread.sleep(2000);
		WebElement next1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Next']")));
		driver.executeScript("arguments[0].click();", next1);
		
		//Click on submit
      	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Submit']"))).click();
      	
        //Click on contacts tab
        WebElement contacts = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Contacts']")));
        driver.executeScript("arguments[0].click();", contacts);
      
        //Search contact name by first name
        WebElement contact = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='Contact-search-input']")));
        contact.sendKeys(fName3,Keys.ENTER);
        
        //Verify the contact name
        String contacts1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-aura-class='forceOutputLookup']"))).getText();
        System.out.println(contacts1);
        
        if(contacts1.contains(fName3)) {
           System.out.println("New contact is created for the campaign");
        }else {
           System.out.println("New contact is not created for the campaign");

        }
        
        
		      	
       	 


		



		



		

        
        
        

        


}
}

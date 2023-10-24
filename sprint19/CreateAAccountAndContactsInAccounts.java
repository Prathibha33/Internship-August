package sprint19;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class CreateAAccountAndContactsInAccounts extends BaseClassSp19 {
	
@Test	
public void runCreateAAccountAndContactsInAccounts() throws InterruptedException {
	    

	    //Click on the toggle menu button from the left corner
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='slds-icon-waffle']"))).click();
			
		//Click View All
		WebElement viewall = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='View All']")));
		driver.executeScript("arguments[0].click();", viewall);
	   
		//Click on Accounts
		WebElement accounts = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Accounts']")));
		driver.executeScript("arguments[0].click();", accounts);
		
		//Click on New button
		WebElement New = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='New']")));
		driver.executeScript("arguments[0].click();", New);
		
		//Enter Account name
		String accname = faker.name().fullName();
		WebElement accname1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class='slds-input'])[2]")));
		accname1.sendKeys(accname);
		
		//Click save button
		Thread.sleep(2000);
		WebElement save = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Save']")));
		try {
			save.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			driver.executeScript("arguments[0].click();", save);
		}
		
		//Verifying the account
		String toastermsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='Success']"))).getText();
		System.out.println(toastermsg);
		if(toastermsg.contains(accname)){
			System.out.println("new account is created");
		}else {
			System.out.println("new account is not created");

		}
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@aria-label='Success']")));
		
		//Click on New contact
		WebElement newcontact = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='New Contact']")));
		driver.executeScript("arguments[0].click();", newcontact);
		
		//Enter salutation
		WebElement dd = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Salutation']/following::a")));
		driver.executeScript("arguments[0].click();", dd);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Mrs.']"))).click();
		
		//Enter first name
		String firstname = faker.name().firstName();
	    WebElement fn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='First Name']")));
        fn.sendKeys(firstname);
		
		
		//Enter last name
		String lastnameFaker = faker.name().lastName();
		
		String lastName = lastnameFaker.toLowerCase().replaceAll("[^a-z]", "");
	    WebElement ln = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Last Name']")));
	    ln.sendKeys(lastName);
	    
	    //Enter email
	    WebElement email1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@inputmode='email']")));
	    email1.sendKeys(lastName+"@gmail.com");
	    
	    //Enter Phone number
	    String phno = faker.phoneNumber().phoneNumber();
	    WebElement pn1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='tel']")));
	    pn1.sendKeys(phno);
	    
	    //Enter title
	    WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type='text'])[5]")));
	    title.sendKeys("SDET");
	    
	    //Click Save
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Save'])[3]"))).click();
	    
	    //Verify toaster message
	    String toastermsg1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-key='success']"))).getText();
	    System.out.println(toastermsg1);
	    if(toastermsg1.contains(firstname)) {
	    	   System.out.println("New contact is created");
	     
	    }else {
		    	System.out.println("New contact is not created");

	    }
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@data-key='success']")));
	    
	    //Click on Contacts tab
	    WebElement contacts = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Contacts']")));
		driver.executeScript("arguments[0].click();", contacts);
		
		//search contact with last name
		WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search this list...']")));
		search.sendKeys(lastName);
		search.sendKeys(Keys.ENTER);
		
		//verify the contact
		String name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-aura-class='forceInlineEditCell']"))).getText();
		System.out.println(name);
		if(name.contains(lastName)) {
			System.out.println("contact is created");
		}else {
			System.out.println("contact is not created");

		}
		 //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@data-aura-class='forceInlineEditCell']")));
		
		//Go to accounts tab
		WebElement accountstab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/lightning/o/Account/home']")));
		driver.executeScript("arguments[0].click();", accountstab);
		
		//search the account
		WebElement search2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='Account-search-input']")));
		search2.sendKeys(accname);
		search2.sendKeys(Keys.ENTER);

	   //Click the drop down of the displayed account name
		Thread.sleep(2000);
		WebElement dd1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@data-aura-class='forceVirtualAction'])[2]")));
		wait.until(ExpectedConditions.elementToBeClickable(dd1));
		driver.executeScript("arguments[0].click();", dd1);
		
		//Click on the delete option
		Thread.sleep(2000);
		WebElement delete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Delete']")));
		driver.executeScript("arguments[0].click();", delete);

		
        //Click on the delete button
		WebElement delete1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Delete']")));
		driver.executeScript("arguments[0].click();", delete1);
		
		//verify the toaster message
		String toastermsg2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-aura-class='forceActionsText']"))).getText();
		System.out.println(toastermsg2);
		if(toastermsg2.contains(accname)) {
			System.out.println("Contact is deleted");
		}else {
			System.out.println("Contact is not deleted");

		}
		 //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@data-aura-class='forceActionsText']")));

		//Click on Contacts tab
	    WebElement contacts1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Contacts']")));
		driver.executeScript("arguments[0].click();", contacts1);
		
		//search contact with last name
		WebElement search1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search this list...']")));
		search1.sendKeys(lastName, Keys.ENTER);
		
		//verifying that there are no items to display
		String displaymsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='No items to display.']"))).getText();
		System.out.println(displaymsg);
		if(displaymsg.contains("No items")) {
			System.out.println("there are no contacts to display");
		}else {
			System.out.println("there are contacts to display");

		}
		
		
		
		

		

	    
		
		







}
}

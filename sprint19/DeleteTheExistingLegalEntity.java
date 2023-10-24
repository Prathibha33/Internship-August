package sprint19;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DeleteTheExistingLegalEntity extends BaseClassSp19{
	
	
    @Test(dependsOnMethods = "sprint19.EditTheExistingLegalEntity.runEditTheExistingLegalEntity")
	public void runDeleteTheExistingLegalEntity() throws InterruptedException {
		
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		WebElement viewall = driver.findElement(By.xpath("//button[text()='View All']"));
		driver.executeScript("arguments[0].click();", viewall);
		WebElement le = driver.findElement(By.xpath("//p[text()='Legal Entities']"));
		driver.executeScript("arguments[0].click();", le);
		WebElement le1 = driver.findElement(By.xpath("//span[text()='Legal Entities']"));
		driver.executeScript("arguments[0].click();", le1);
		String name ="Salesforce Automation by Prathibha";
		WebElement searchname = driver.findElement(By.xpath("//input[@name='LegalEntity-search-input']"));
		searchname.sendKeys(name,Keys.ENTER);
		Thread.sleep(2000);
		WebElement dd = driver.findElement(By.xpath("//div[@class='forceVirtualActionMarker forceVirtualAction']/a[@role='button']"));
        driver.executeScript("arguments[0].click();", dd);
        WebElement delete = driver.findElement(By.xpath("//a[@data-target-selection-name='sfdc:StandardButton.LegalEntity.Delete']"));
        driver.executeScript("arguments[0].click();", delete);
        WebElement delete1 = driver.findElement(By.xpath("//span[text()='Delete']"));
        driver.executeScript("arguments[0].click();", delete1);
//        String toastermessage = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
//        System.out.println(toastermessage);
//        if(toastermessage.equals(searchname)) {
//        	System.out.println("legal entity is deleted");
//        }else {
//        	System.out.println("legal entity is not deleted");
//        }
        searchname.sendKeys("Salesforce Automation by Prathibha",Keys.ENTER);
        String deletemessage = driver.findElement(By.xpath("//lightning-formatted-rich-text[@class='slds-rich-text-editor__output']")).getText();
        System.out.println(deletemessage);
        if(deletemessage.equals(name)) {
        	System.out.println("legal entity is not deleted");
        }else {
        	System.out.println("legal entity is deleted");
        }
        
        
        



	}

}

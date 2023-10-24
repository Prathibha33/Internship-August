package sprint19;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class EditTheExistingLegalEntity extends BaseClassSp19{

	@Test(dependsOnMethods = "sprint19.CreateLegalEntity.runCreateLegalEntity")
	public void runEditTheExistingLegalEntity() throws InterruptedException {
		
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		WebElement viewall = driver.findElement(By.xpath("//button[text()='View All']"));
		driver.executeScript("arguments[0].click();", viewall);
		WebElement le = driver.findElement(By.xpath("//p[text()='Legal Entities']"));
		driver.executeScript("arguments[0].click();", le);
		WebElement le1 = driver.findElement(By.xpath("//span[text()='Legal Entities']"));
		driver.executeScript("arguments[0].click();", le1);
		WebElement searchname = driver.findElement(By.xpath("//input[@name='LegalEntity-search-input']"));
		searchname.sendKeys("Salesforce Automation by Prathibha",Keys.ENTER);
		Thread.sleep(2000);
		WebElement dd = driver.findElement(By.xpath("//div[@class='forceVirtualActionMarker forceVirtualAction']/a[@role='button']"));
        driver.executeScript("arguments[0].click();", dd);
		WebElement edit = driver.findElement(By.xpath("//a[@data-target-selection-name='sfdc:StandardButton.LegalEntity.Edit']"));
		driver.executeScript("arguments[0].click();", edit);
		WebElement cn = driver.findElement(By.xpath("//input[@name='CompanyName']"));
		cn.clear();
		cn.sendKeys("Testleaf");
		WebElement dp = driver.findElement(By.xpath("(//textarea[@class='slds-textarea'])[2]"));
		dp.clear();
		dp.sendKeys("SalesForce");
		WebElement statusdd = driver.findElement(By.xpath("//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value']"));
		driver.executeScript("arguments[0].click();", statusdd);
		WebElement status= driver.findElement(By.xpath("//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value']"));
		driver.executeScript("arguments[0].click();", status);
		WebElement save = driver.findElement(By.xpath("//button[@name='SaveEdit']"));
		driver.executeScript("arguments[0].click();", save);
		
//		String text = driver.findElement(By.xpath("//span[@data-aura-class='forceActionsText']")).getText();
//		System.out.println(text);
//		if(text.contains("Prathibha")) {
//			System.out.println("Salesforce automation by Prathibha was saved");
//		}else {
//			System.out.println("Salesforce automation by Prathibha was not saved");
//		}
		searchname.sendKeys("Salesforce Automation by Prathibha",Keys.ENTER);
		WebElement firstaccount = driver.findElement(By.xpath("//a[@title='Salesforce Automation by Prathibha']"));
		driver.executeScript("arguments[0].click();", firstaccount);
		String status1= driver.findElement(By.xpath("(//div[@class='slds-form-element__control'])[5]")).getText();
		System.out.println(status1);
		if(status1.contains("Active")) {
			System.out.println("status is active");
		}else {
			System.out.println("status is not active");
		}
		



		

		



	
}}

package sprint19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;


public class CreateLegalEntity extends BaseClassSp19 {
	
    @Test
	public void runCreateLegalEntity() throws InterruptedException {
		
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='slds-icon-waffle']"))).click();
		WebElement viewall = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='View All']")));
		driver.executeScript("arguments[0].click();", viewall);
		Thread.sleep(2000);
		WebElement le = driver.findElement(By.xpath("//p[text()='Legal Entities']"));
		driver.executeScript("arguments[0].click();", le);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[name()='svg' and @data-key='chevrondown'])[15]")).click();
		WebElement Newlegal = driver.findElement(By.xpath("//span[text()='New Legal Entity']"));
		driver.executeScript("arguments[0].click();", Newlegal);
		driver.findElement(By.xpath("//input[@name=\"Name\"]")).sendKeys("Salesforce Automation by Prathibha");
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		String text = driver.findElement(By.xpath("//div[@data-aura-class=\"forceToastMessage\"]")).getText();
		if(text.contains("Salesforce Automation by Prathibha")) {
			System.out.println("New Legal Entity is created ");
		}
		else {
			System.out.println("New Legal Entity is not created");
			
		}

		

	}
	

}

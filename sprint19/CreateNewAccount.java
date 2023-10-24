package sprint19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CreateNewAccount extends BaseClassSp19{
	
	@Test
	public void runCreateNewAccount() throws InterruptedException {
		
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
//		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		WebElement account = driver.findElement(By.xpath("//p[text()='Accounts']"));
		driver.executeScript("arguments[0].click();", account);
		WebElement accountTab  = driver.findElement(By.xpath("//span[text()='Accounts']/.."));
		driver.executeScript("arguments[0].click();", accountTab);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@title='New']")).click();
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Prathibha");
		WebElement ownership = driver.findElement(By.xpath("//button[contains(@aria-label,'Ownership')]"));
		driver.executeScript("arguments[0].click();", ownership);
		driver.findElement(By.xpath("//*[@data-value='Public']")).click();
		driver.findElement(By.xpath("//button[text()='Save']")).click();
	    String text= driver.findElement(By.xpath("//div[@data-aura-class=\"forceToastMessage\"]")).getText();
		if(text.contains("Prathibha")) {
			System.out.println("Account Prathibha was created");
		}
		else {
			System.out.println("Account Prathibha was not created");
		}
	}

	
}

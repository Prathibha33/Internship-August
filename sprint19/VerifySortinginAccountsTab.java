package sprint19;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class VerifySortinginAccountsTab extends BaseClassSp19{

	@Test(dependsOnMethods = "sprint19.CreateNewAccount.runCreateNewAccount")
	public void runVerifySortinginAccountsTab() {
		
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[@class='slds-truncate']")).click();
		WebElement accountTab  = driver.findElement(By.xpath("//span[text()='Accounts']/.."));
		driver.executeScript("arguments[0].click();", accountTab);
		WebElement sortarrow = driver.findElement(By.xpath("//a[@class=\"toggle slds-th__action slds-text-link--reset \"]"));
		driver.executeScript("arguments[0].click();", sortarrow);


	}

	
}

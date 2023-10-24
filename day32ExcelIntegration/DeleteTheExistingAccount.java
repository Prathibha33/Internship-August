package day32ExcelIntegration;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DeleteTheExistingAccount extends BaseClassDay32{
	@BeforeTest
	public void setFile() {
		fileName=" DeleteTheExistingAccount";
	}

    @Test
    (dataProvider = "fetchData")	
	public void runDeleteTheExistingAccount(String name) {
		
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[@class='slds-truncate']")).click();
		WebElement accountTab  = driver.findElement(By.xpath("//span[text()='Accounts']/.."));
		driver.executeScript("arguments[0].click();", accountTab);
		driver.findElement(By.xpath("//input[@name=\"Account-search-input\"]")).sendKeys(name,Keys.ENTER);
		WebElement dropdown = driver.findElement(By.xpath("//div[@data-aura-class='forceVirtualAction']/*"));
		driver.executeScript("arguments[0].click();", dropdown);
		WebElement del = driver.findElement(By.xpath("//a[@title='Delete']"));
		driver.executeScript("arguments[0].click();", del);
		driver.findElement(By.xpath("//button[@title=\"Delete\"]")).click();
		String text = driver.findElement(By.xpath("//div[@data-aura-class=\"forceToastMessage\"]")).getText();
		if(text.contains(name)) {
			System.out.println(name + " account is deleted");
		}
		else {
			System.out.println(name + " account is not deleted");
		}
	}
	

}

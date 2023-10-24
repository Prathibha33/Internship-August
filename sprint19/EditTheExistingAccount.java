package sprint19;




import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class EditTheExistingAccount extends BaseClassSp19{
	
    @Test(dependsOnMethods = "sprint19.CreateNewAccount.runCreateNewAccount")
//	@Test
	public void runEditTheExistingAccount() throws InterruptedException {
		
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[@class='slds-truncate']")).click();
		WebElement accountTab  = driver.findElement(By.xpath("//span[text()='Accounts']/.."));
		driver.executeScript("arguments[0].click();", accountTab);
		driver.findElement(By.xpath("//input[@name='Account-search-input']")).sendKeys("Prathibha",Keys.ENTER);
		WebElement dropdown = driver.findElement(By.xpath("//div[@data-aura-class='forceVirtualAction']/*"));
		Thread.sleep(2000);
		try {
			dropdown.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Thread.sleep(2000);
			WebElement dd = driver.findElement(By.xpath("//div[@data-aura-class='forceVirtualAction']/*"));
			driver.executeScript("arguments[0].click();", dd);
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		WebElement dropdown1 = driver.findElement(By.xpath("(//div[@class='slds-combobox slds-dropdown-trigger slds-dropdown-trigger_click'])[3]"));
		driver.executeScript("arguments[0].click();", dropdown1);
		driver.findElement(By.xpath("//span[@title='Technology Partner']")).click();
        WebElement dropdown2 = driver.findElement(By.xpath("//button[@aria-label='Industry, --None--']"));
		driver.executeScript("arguments[0].click();", dropdown2);
		WebElement dropdown3 = driver.findElement(By.xpath("//span[@title='Healthcare']"));
		driver.executeScript("arguments[0].click();", dropdown3);
		WebElement street1 = driver.findElement(By.xpath("//textarea[@name='street']"));
		street1.clear();
		street1.sendKeys("1,street");
		WebElement city1 = driver.findElement(By.xpath("//input[@autocomplete='address-level2']"));
		city1.clear();
		city1.sendKeys("1, city");
		WebElement state1 = driver.findElement(By.xpath("//input[@autocomplete='address-level1']"));
		state1.clear();
		state1.sendKeys("1, state");
		WebElement postalcode1 = driver.findElement(By.xpath("//input[@autocomplete='postal-code']"));
		postalcode1.clear();
		postalcode1.sendKeys("1, 1212");
		WebElement country1 = driver.findElement(By.xpath("//input[@autocomplete='country']"));
		country1.clear();
		country1.sendKeys("1, country");
		WebElement street = driver.findElement(By.xpath("(//textarea[@name='street'])[2]"));
		street.clear();
		street.sendKeys("1,street");
		WebElement city = driver.findElement(By.xpath("(//input[@autocomplete='address-level2'])[2]"));
		city.clear();
		city.sendKeys("1, city");
		WebElement state = driver.findElement(By.xpath("(//input[@autocomplete='address-level1'])[2]"));
		state.clear();
		state.sendKeys("1, state");
		WebElement postalcode = driver.findElement(By.xpath("(//input[@autocomplete='postal-code'])[2]"));
		postalcode.clear();
		postalcode.sendKeys("1, 1212");
		WebElement country = driver.findElement(By.xpath("(//input[@autocomplete='country'])[2]"));
		country.clear();
		country.sendKeys("1, country");
        WebElement dropdown4 = driver.findElement(By.xpath("//button[@aria-label='Customer Priority, --None--']"));
		driver.executeScript("arguments[0].click();", dropdown4);
		WebElement dropdown5 = driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Low']"));
		driver.executeScript("arguments[0].click();", dropdown5);
		WebElement dd6 = driver.findElement(By.xpath("//button[@aria-label='Active, --None--']"));
		driver.executeScript("arguments[0].click();", dd6);
		WebElement dd7 = driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Yes']"));
		driver.executeScript("arguments[0].click();", dd7);
		WebElement dd8 = driver.findElement(By.xpath("//button[@aria-label='Rating, --None--']"));
		driver.executeScript("arguments[0].click();", dd8);
		WebElement dd9 = driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Hot']"));
		driver.executeScript("arguments[0].click();", dd9);
		WebElement phno = driver.findElement(By.xpath("//input[@name='Phone']"));
		phno.clear();
		phno.sendKeys("9988998898");
		WebElement dd10 = driver.findElement(By.xpath("//button[@aria-label='Ownership, Public']"));
		driver.executeScript("arguments[0].click();", dd10);
		WebElement dd11 = driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Private']"));
		driver.executeScript("arguments[0].click();", dd11);
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		//String text = driver.findElement(By.xpath("//span[text()='9988998898']")).getText();
		boolean displayed = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='9988998898']"))).isDisplayed();
		if(displayed) {
			System.out.println("Phone number is updated");
		}
		else {
			System.out.println("Phone number is not updated");
		}
	}			
		







		

	}



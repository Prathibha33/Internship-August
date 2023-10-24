package sprint19;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CreateLegalEntitywithoutMandatoryFields extends BaseClassSp19 {

	@Test
	public void runCreateLegalEntitywithoutMandatoryFields() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		WebElement viewall = driver.findElement(By.xpath("//button[text()='View All']"));
		driver.executeScript("arguments[0].click();", viewall);
		WebElement le = driver.findElement(By.xpath("//p[text()='Legal Entities']"));
		driver.executeScript("arguments[0].click();", le);
		driver.findElement(By.xpath("(//*[name()='svg' and @data-key=\"chevrondown\"])[15]")).click();
		WebElement Newlegal = driver.findElement(By.xpath("//span[text()='New Legal Entity']"));
		driver.executeScript("arguments[0].click();", Newlegal);
		driver.findElement(By.xpath("//input[@name='CompanyName']")).sendKeys("Testleaf");
		driver.findElement(By.xpath("(//textarea[@class=\"slds-textarea\"])[2]")).sendKeys("SalesForce");
		WebElement statusdd = driver.findElement(By.xpath("//button[@data-value=\"--None--\"]"));
		driver.executeScript("arguments[0]. click();",statusdd);
        WebElement status = driver.findElement(By.xpath("//span[text()='Active']"));
        driver.executeScript("arguments[0].click();", status);
        driver.findElement(By.xpath("//button[text()='Save']")).click();
        String text = driver.findElement(By.xpath("//ul[@class=\"errorsList slds-list_dotted slds-m-left_medium\"]//a")).getText();
        if(text.contains("Name")) {
			System.out.println("New Legal Entity is not created ");
		}
		else {
			System.out.println("New Legal Entity is created");
		}


	}

}

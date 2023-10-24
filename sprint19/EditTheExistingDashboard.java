package sprint19;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class EditTheExistingDashboard extends BaseClassSp19{

	@Test(dependsOnMethods = "sprint19.CreateANewDashboard.runCreateANewDashboard")
	public void runEditTheExistingDashboard() throws InterruptedException {
		
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		WebElement viewall = driver.findElement(By.xpath("//button[text()='View All']"));
		driver.executeScript("arguments[0].click();", viewall);
		WebElement dashboards = driver.findElement(By.xpath("//p[text()='Dashboards']"));
		driver.executeScript("arguments[0].click();", dashboards);
		String search1 ="Prathibha";
		WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search recent dashboards...']"));
		search.sendKeys(search1,Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='slds-button slds-button_icon-border slds-button_icon-x-small']")).click();
		WebElement edit = driver.findElement(By.xpath("//span[text()='Edit']"));
		driver.executeScript("arguments[0].click();", edit);
		WebElement frame = driver.findElement(By.xpath("//iframe[@title='dashboard']"));
		driver.switchTo().frame(frame);
		WebElement properties = driver.findElement(By.xpath("//span[text()='Edit Dashboard Properties']"));
		driver.executeScript("arguments[0].click();", properties);
		String name="Salesforce Automation by Prathibha";
		WebElement name1 = driver.findElement(By.xpath("//input[@id='dashboardNameInput']"));
		//name1.clear();
		name1.sendKeys(name,Keys.ENTER);
		String des = "SalesForce";
		WebElement description = driver.findElement(By.xpath("//input[@id='dashboardDescriptionInput']"));
		description.sendKeys(des);
		WebElement me = driver.findElement(By.xpath("//label[@class='slds-radio__label']"));
		driver.executeScript("arguments[0].click();", me);
		WebElement anotherperson = driver.findElement(By.xpath("//span[text()='Another person']"));
		driver.executeScript("arguments[0].click();", anotherperson);
		WebElement save = driver.findElement(By.xpath("(//button[text()='Save'])[2]"));
		driver.executeScript("arguments[0].click();", save);
		WebElement done = driver.findElement(By.xpath("//button[text()='Done']"));
		driver.executeScript("arguments[0].click();", done);
		WebElement save1 = driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand modalBtn2']"));
		driver.executeScript("arguments[0].click();", save1);
		String des1 = driver.findElement(By.xpath("//div[@class='slds-col slds-align-bottom']")).getText();
		System.out.println(des1);
		if(des1.equals(des)) {
			System.out.println("Description is edited");
		}else {
			System.out.println("Description is not edited");
		}

        

	

		

		



	}
	

}

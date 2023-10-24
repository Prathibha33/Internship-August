package sprint19;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class CreateANewDashboard extends BaseClassSp19{
	
    @Test
	public void runCreateANewDashboard() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='slds-icon-waffle']"))).click();
		WebElement viewall = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='View All']")));
		driver.executeScript("arguments[0].click();", viewall);
		Thread.sleep(2000);
		WebElement dashboards = driver.findElement(By.xpath("//p[text()='Dashboards']"));
		driver.executeScript("arguments[0].click();", dashboards);
		WebElement newdashboard = driver.findElement(By.xpath("//div[text()='New Dashboard']"));
		driver.executeScript("arguments[0].click();", newdashboard);
		WebElement frame = driver.findElement(By.xpath("//iframe[@title='dashboard']"));
		driver.switchTo().frame(frame);
		String name="Salesforce Automation by Prathibha";
		WebElement name1 = driver.findElement(By.xpath("//input[@aria-describedby='help-name-error']"));
		name1.sendKeys(name,Keys.ENTER);
		WebElement create = driver.findElement(By.xpath("//button[text()='Create']"));
		driver.executeScript("arguments[0].click();", create);
		WebElement frame1 = driver.findElement(By.xpath("//iframe[@title='dashboard']"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("//button[text()='Done']")).click();
		String dashboardname = driver.findElement(By.xpath("//span[@title='Salesforce Automation by Prathibha']")).getText();
		System.out.println(dashboardname);
		if(dashboardname.contains(name)){
			System.out.println("New Dashboard is created");
		}else {
			System.out.println("New Dashboard is not created");
		
		}
		
		

		

		



	}

}

package sprint19;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class DeleteTheExistingDashboard extends BaseClassSp19{
	
	@Test(dependsOnMethods = "sprint19.EditTheExistingDashboard.runEditTheExistingDashboard")
	public void runDeleteTheExistingDashboard() throws InterruptedException {
		        
				
				//Click on the toggle menu button from the left corner
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='slds-icon-waffle']"))).click();
				//driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
				
				//Click View All
				WebElement viewall = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='View All']")));
				//WebElement viewall = driver.findElement(By.xpath("//button[text()='View All']"));
				driver.executeScript("arguments[0].click();", viewall);
				
				//click Dashboards from App Launcher
				WebElement dashboards = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Dashboards']")));
				//WebElement dashboards = driver.findElement(By.xpath("//p[text()='Dashboards']"));
				driver.executeScript("arguments[0].click();", dashboards);
				
				//Click on the Dashboards tab 
				WebElement dashboardstab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Dashboards']")));
				//WebElement dashboardstab = driver.findElement(By.xpath("//span[text()='Dashboards']"));
				driver.executeScript("arguments[0].click();", dashboardstab);
				
		        //Search the Dashboard 'Salesforce Automation by Your Name'
				String search1 ="Prathibha";
				WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search recent dashboards...']")));
				//WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search recent dashboards...']"));
				search.sendKeys(search1,Keys.ENTER);
				//Thread.sleep(2000);
				
				//Click on the Dropdown icon
				WebElement dd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='slds-button slds-button_icon-border slds-button_icon-x-small']")));
		        //driver.findElement(By.xpath("//button[@class='slds-button slds-button_icon-border slds-button_icon-x-small']")).click();
				driver.executeScript("arguments[0].click();", dd);
				
		       //Select Delete
			   WebElement delete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Delete']")));
               //WebElement delete = driver.findElement(By.xpath("//span[text()='Delete']"));
               driver.executeScript("arguments[0].click();", delete);
               
               //Click on the Delete option in the displayed popup window
               wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Delete'])[2]"))).click();
               //WebElement delete1 = driver.findElement(By.xpath("(//span[text()='Delete'])[2]"));
               //driver.executeScript("arguments[0].click();", delete1);
              
               //Verify Whether Dashboard is Deleted using Dashboard Name
               String toastermsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-key='success']"))).getText();
               // String toastermsg = driver.findElement(By.xpath("//div[@data-key='success']")).getText();
               System.out.println(toastermsg);
               if(toastermsg.contains("Success")) {
        	   System.out.println("Dashboard was deleted");
               }else {
        	   System.out.println("Dashboard was not deleted");
               }
               
        
}
}

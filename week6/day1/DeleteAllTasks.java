package week6.day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class DeleteAllTasks extends BaseClass {
	@Test(dependsOnMethods = {"week6.day1.CreateFollowUpEvent.runCreateFollowUpEvent","week6.day1.CreateFollowUpTask.runCreateFollowUpTask"})
	public void runDeleteAllTasks() throws InterruptedException {
    	
    	Thread.sleep(2000);
    	//Get the count of the tasks
    	List<WebElement> countOfTheTasks = driver.findElements(By.xpath("//span[@class='slds-truncate uiOutputText']"));
    	System.out.println("Count of tasks " +  countOfTheTasks.size());
    	for(int i=0;i<countOfTheTasks.size();i++) {
    		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-aura-class='forceVirtualAction']"))).click();
   		    WebElement delete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@data-aura-class='forceActionLink'])[3]")));
   		    driver.executeScript("arguments[0].click();", delete);
        	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Delete']"))).click();
        	Thread.sleep(2000);
    	}
    	
    	
    	
    	//Delete all of the tasks
//    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-aura-class='forceVirtualAction']"))).click();
//		WebElement delete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@data-aura-class='forceActionLink'])[3]")));
//        driver.executeScript("arguments[0].click();", delete);
//    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Delete']"))).click();
//    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@data-aura-class='forceVirtualAction'])[2]"))).click();
//        WebElement delete1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@data-aura-class='forceActionLink'])[7]")));
//	    driver.executeScript("arguments[0].click();", delete1);
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Delete']"))).click();
    	


    	
    	
		
	}
}

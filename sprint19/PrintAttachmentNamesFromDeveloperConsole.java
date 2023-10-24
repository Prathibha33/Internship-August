package sprint19;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class PrintAttachmentNamesFromDeveloperConsole extends BaseClassSp19{
	
@Test	
public void runPrintAttachmentNamesFromDeveloperConsole() throws InterruptedException {
		
	    
		
		
		//Click on view profile
		WebElement vP = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='uiImage']")));
		driver.executeScript("arguments[0].click();", vP);
		
		//Click on Switch to Sales force Classic
		WebElement switchTo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Switch to Salesforce Classic']")));
		driver.executeScript("arguments[0].click();", switchTo);
		
		//Click on account name drop down
		WebElement dd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='userNav-arrow']")));
		driver.executeScript("arguments[0].click();", dd);
		
		//Click on developer console
		WebElement devConsole = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Developer Console']")));
		driver.executeScript("arguments[0].click();", devConsole);
		
		//Window handling
	    Set<String> windowHs = driver.getWindowHandles();
	    List<String> whs=new ArrayList<String>(windowHs);
	    
	    //Switch to child window
	    driver.switchTo().window(whs.get(1));
	    
		//Click on file
		WebElement file = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//em[@id='editorMenuEntry-btnWrap']")));
		driver.executeScript("arguments[0].click();", file);
		
		//Click on open
		WebElement open = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Open']")));
		driver.executeScript("arguments[0].click();", open);
		
		//Click on objects
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Objects']"))).click();
		
		
		//Enter Attachment in filter
		WebElement filter = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='textfield-1193-inputEl']")));
		driver.executeScript("arguments[0].click();", filter);
		filter.sendKeys("Attachment",Keys.ENTER);
		
		//Click on Attachment
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Attachment']"))).click();
		
		//Click on open
		WebElement open1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Open'])[2]")));
		driver.executeScript("arguments[0].click();", open1);
		
		//Print names in Attachment
		Thread.sleep(2000);
		List<WebElement>names = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='x-grid-cell-inner ']")));
		for(WebElement a: names) {
			System.out.println(a.getText());
		}
		
		//close the current window
		driver.close();
		
		//Switch to parent window
		driver.switchTo().window(whs.get(0));
		
		//click on the 'Switch to Lighting Experience
		WebElement SwitcToLight = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='switch-to-lightning']")));
		driver.executeScript("arguments[0].click();", SwitcToLight);
		
		

		
				





		



}
}

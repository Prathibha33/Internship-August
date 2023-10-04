package week6.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class CreateANewTask extends BaseClass{
	
	
@Test
public void runCreateANewTask() {
	
	 //Click on new Task
     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@title='New Task']"))).click();
     
     //Choose subject as Email
     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='slds-combobox__input slds-input']"))).click();
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@title='Email']"))).click();
     
     //Choose priority as high
     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='select'])[2]"))).click();
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='High']"))).click();
     
     //Choose status as in progress
     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='select']"))).click();
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='In Progress']"))).click();
     
     //Select Contacts from name drop down
     // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Name'])[2]/following::span"))).click();
     WebElement contacts = driver.findElement(By.xpath("(//a[contains(@class,'entityMenuTrigger ')])[2]"));
	 driver.executeScript("arguments[0].click();", contacts);
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Contacts']"))).click();
     
     //Choose first displayed contact
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@title='Search Contacts']"))).click();
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@data-aura-class='uiAutocompleteOption forceSearchInputLookupDesktopOption']"))).click();
     
     //Select Products from related to drop down
     WebElement relatedTo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(@class,'entityMenuTrigger ')])[3]")));
     relatedTo.click();     
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@title='Products']"))).click();
     
     //Choose first displayed product
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@title='Search Products']"))).click();
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@title='sample']"))).click();

     //Click on save button
     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Save'])[2]"))).click();





     


     




}}





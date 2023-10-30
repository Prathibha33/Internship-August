package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import base.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CommonWebElements extends BaseClass{
	
	@Given("Enter {string} as {string}")
    public void enterName(String field, String name) {
		driver.findElement(By.xpath("//span[text()='"+field+"']/following::input")).sendKeys(name);
    }
    @When("Click on save")
    public void clickOnSave() {
		driver.findElement(By.xpath("//button[text()='Save']")).click();
    }
    @Then("Verify the toaster message is {string} for {string}")
    public void verifyLegalEntity(String scenario, String module) {
    	String text = driver.findElement(By.xpath("//div[@data-aura-class=\"forceToastMessage\"]")).getText();
		if(text.contains("successfully")) {
			System.out.println(module + " is "+scenario+" successfully");
		}
		else {
			System.out.println(module + " is not "+scenario+" successfully");
    }
    }
    @Given("Enter name in the search bar as {string}")
    public void searchForLegalEntity(String name) throws InterruptedException {
    	WebElement searchname = driver.findElement(By.xpath("//input[@aria-label='Search Recently Viewed list view.']"));
		searchname.sendKeys(name,Keys.ENTER);
		Thread.sleep(2000);
    }
    @When("Click on the dropdown")
	public void clickOnTheDropDown() {
		WebElement dd = driver.findElement(By.xpath("//div[@class='forceVirtualActionMarker forceVirtualAction']/a[@role='button']"));
        driver.executeScript("arguments[0].click();", dd);
    }
	@And("Click on edit option")
	public void clickOnEditOption() {
		WebElement edit = driver.findElement(By.xpath("//a[@title='Edit']"));
		driver.executeScript("arguments[0].click();", edit);
	}
	@And("Click on save button")
	public void saveButton() {
		WebElement save = driver.findElement(By.xpath("//button[@name='SaveEdit']"));
		driver.executeScript("arguments[0].click();", save);
	}
	
}

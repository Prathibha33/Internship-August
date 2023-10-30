package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import base.ProjectSpecificMethod;

public class AccountsPage extends ProjectSpecificMethod{
	
	public AccountsPage(RemoteWebDriver driver) {
		this.driver=driver;
	}

	public AccountsPage clickAccountsTab() throws InterruptedException {
		WebElement accountTab  = getDriver().findElement(By.xpath("//span[text()='Accounts']/.."));
		getDriver().executeScript("arguments[0].click();", accountTab);
		Thread.sleep(2000);
		return this;
		}
	
	public CreateAccountPage clickNew() {
		getDriver().findElement(By.xpath("//div[@title='New']")).click();
		return new CreateAccountPage(driver);
	    }
	
	
	public AccountsPage verifyToasterMsg() {
		String text= getDriver().findElement(By.xpath("//div[@data-aura-class='forceToastMessage']")).getText();
		if(text.contains("Prathibha")) {
			System.out.println("Account Prathibha was created");
		}
		else {
			System.out.println("Account Prathibha was not created");
		}
		return this;
	}
	
	public AccountsPage searchAccount() {
		getDriver().findElement(By.xpath("//input[@name='Account-search-input']")).sendKeys("Prathibha",Keys.ENTER);
		return this;
	}
	
	public AccountsPage clickDropDown() throws InterruptedException{
		WebElement dropdown = getDriver().findElement(By.xpath("//div[@data-aura-class='forceVirtualAction']/*"));
		Thread.sleep(2000);
		try {
			dropdown.click();
		} catch (Exception e) {
			
			Thread.sleep(2000);
			WebElement dd = getDriver().findElement(By.xpath("//div[@data-aura-class='forceVirtualAction']/*"));
			getDriver().executeScript("arguments[0].click();", dd);
		}
		return this;
	}
	
	public EditAccountPage chooseEdit() throws InterruptedException {
		Thread.sleep(2000);
		getDriver().findElement(By.xpath("//a[@title='Edit']")).click();
		return new EditAccountPage(driver);
	}
	
	public AccountsPage verifyPhNo() {
		boolean displayed = getDriver().findElement(By.xpath("//span[text()='9988998898']")).isDisplayed();
		if(displayed) {
			System.out.println("Phone number is updated");
		}
		else {
			System.out.println("Phone number is not updated");
		}
		return this;
	}
	
	public DeleteAccountPage chooseDelete() {
		WebElement del = getDriver().findElement(By.xpath("//a[@title='Delete']"));
		getDriver().executeScript("arguments[0].click();", del);
		return new DeleteAccountPage(driver);
	}
	
	public AccountsPage verifyTM() {
		String text = getDriver().findElement(By.xpath("//div[@data-aura-class='forceToastMessage']")).getText();
		if(text.contains("Prathibha")) {
			System.out.println("Account Prathibha is deleted");
		}
		else {
			System.out.println("Account Prathibha is not deleted");
		}
		return this;
	}
	
	
	

}

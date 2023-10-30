package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import base.ProjectSpecificMethod;

public class CreateAccountPage extends ProjectSpecificMethod{
	
	public CreateAccountPage(RemoteWebDriver driver) {
		this.driver=driver;
	}

	public CreateAccountPage enterName() {
		getDriver().findElement(By.xpath("//input[@name='Name']")).sendKeys("Prathibha");
		return this;
	}
	
	public CreateAccountPage clickOwnerShip() {
		WebElement ownership = getDriver().findElement(By.xpath("//button[contains(@aria-label,'Ownership')]"));
		getDriver().executeScript("arguments[0].click();", ownership);
		return this;
	}
	
	public CreateAccountPage choosePublic() {
		getDriver().findElement(By.xpath("//*[@data-value='Public']")).click();
		return this;
	}
	
	public AccountsPage clickSave() {
		getDriver().findElement(By.xpath("//button[text()='Save']")).click();
		return new AccountsPage(driver);
	}

	public CreateAccountPage enterName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}

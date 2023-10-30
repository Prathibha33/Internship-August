package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import base.ProjectSpecificMethod;

public class DeleteAccountPage extends ProjectSpecificMethod {
	
	public DeleteAccountPage(RemoteWebDriver driver) {
		this.driver=driver;
	}

	public AccountsPage clickDelete() {
		getDriver().findElement(By.xpath("//button[@title='Delete']")).click();
		return new AccountsPage(driver);
	}

}

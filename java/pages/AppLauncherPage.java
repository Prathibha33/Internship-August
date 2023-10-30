package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import base.ProjectSpecificMethod;

public class AppLauncherPage extends ProjectSpecificMethod{
	
	public AppLauncherPage(RemoteWebDriver driver) {
		this.driver=driver;
	}

	public AccountsPage clickAccounts() {
		WebElement account = getDriver().findElement(By.xpath("//p[text()='Accounts']"));
		getDriver().executeScript("arguments[0].click();", account);
		return new AccountsPage(driver);
		
	}

}

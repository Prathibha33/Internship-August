package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import base.ProjectSpecificMethod;

public class HomePage extends ProjectSpecificMethod{
	public HomePage(RemoteWebDriver driver) {
		this.driver=driver;
	}
	public HomePage clickToggleMenu() {
		getDriver().findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		return this;

	}
	
    public AppLauncherPage clickViewAll() {
    	getDriver().findElement(By.xpath("//button[text()='View All']")).click();
		return new AppLauncherPage(driver);
		
	}

     

}

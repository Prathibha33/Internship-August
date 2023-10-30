package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import base.ProjectSpecificMethod;

public class LoginPage extends ProjectSpecificMethod{
	public LoginPage(RemoteWebDriver driver) {
		this.driver=driver;
	}
	public LoginPage enterUsername() {       
	//enter the user name as"prathi@testleaf.com"
	getDriver().findElement(By.id("username")).sendKeys("prathi@testleaf.com");
	return this;
	}
	
	public LoginPage enterPassword() {		
	//enter the password as "Supradi3149"
	getDriver().findElement(By.id("password")).sendKeys("Supradi3149");
	return this;
	}
	
	public HomePage clickLogin() {
	//click login
	getDriver().findElement(By.id("Login")).click();
	return new HomePage(driver);
	}

}

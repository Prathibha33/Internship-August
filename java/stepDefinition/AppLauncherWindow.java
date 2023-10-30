package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BaseClass;
import io.cucumber.java.en.And;

public class AppLauncherWindow extends BaseClass {

	@And("Click on {string}")
	public void clickFromAppLauncher(String items) {
		WebElement element = driver.findElement(By.xpath("//p[text()='"+items+"']"));
		driver.executeScript("arguments[0].click();", element);
}
}

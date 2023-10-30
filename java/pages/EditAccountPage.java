package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import base.ProjectSpecificMethod;

public class EditAccountPage extends ProjectSpecificMethod {

	
	public EditAccountPage(RemoteWebDriver driver) {
		this.driver=driver;
	}

	public EditAccountPage chooseType() {
		WebElement type = getDriver().findElement(By.xpath("(//div[@class='slds-combobox slds-dropdown-trigger slds-dropdown-trigger_click'])[3]"));
		getDriver().executeScript("arguments[0].click();", type);
		getDriver().findElement(By.xpath("//span[@title='Technology Partner']")).click();
		return this;
	}
	
	public EditAccountPage chooseIndustry() {
		WebElement industry = getDriver().findElement(By.xpath("(//div[@class='slds-combobox slds-dropdown-trigger slds-dropdown-trigger_click'])[5]"));
		getDriver().executeScript("arguments[0].click();", industry);
		WebElement healthCare = getDriver().findElement(By.xpath("//span[@title='Healthcare']"));
		getDriver().executeScript("arguments[0].click();", healthCare);
	    return this;
	}
	
	public EditAccountPage enterStreet() {
		WebElement street1 = getDriver().findElement(By.xpath("//textarea[@name='street']"));
		street1.clear();
		street1.sendKeys("1,street");
		return this;
		
	}
	
	public EditAccountPage enterCity() {
		WebElement city1 = getDriver().findElement(By.xpath("//input[@autocomplete='address-level2']"));
		city1.clear();
		city1.sendKeys("1, city");
		return this;
	}
	
	public EditAccountPage enterState() {
		WebElement state1 = getDriver().findElement(By.xpath("//input[@autocomplete='address-level1']"));
		state1.clear();
		state1.sendKeys("1, state");
		return this;
	}
	
	public EditAccountPage enterPostalCode() {
		WebElement postalcode1 = getDriver().findElement(By.xpath("//input[@autocomplete='postal-code']"));
		postalcode1.clear();
		postalcode1.sendKeys("1, 1212");
		return this;
	}
	
	public EditAccountPage enterCountry() {
		WebElement country1 = getDriver().findElement(By.xpath("//input[@autocomplete='country']"));
		country1.clear();
		country1.sendKeys("1, country");
		return this;
	}
	
	public EditAccountPage enterStreet1() {
		WebElement street = getDriver().findElement(By.xpath("(//textarea[@name='street'])[2]"));
		street.clear();
		street.sendKeys("1,street");
		return this;
	}
	
	public EditAccountPage enterCity1() {
		WebElement city = getDriver().findElement(By.xpath("(//input[@autocomplete='address-level2'])[2]"));
		city.clear();
		city.sendKeys("1, city");
		return this;
	}
	
	public EditAccountPage enterState1() {
		WebElement state = getDriver().findElement(By.xpath("(//input[@autocomplete='address-level1'])[2]"));
		state.clear();
		state.sendKeys("1, state");
		return this;
	}
	
	public EditAccountPage enterPostalCode1() {
		WebElement postalcode = getDriver().findElement(By.xpath("(//input[@autocomplete='postal-code'])[2]"));
		postalcode.clear();
		postalcode.sendKeys("1, 1212");
		return this;
	}
	
	public EditAccountPage entryCountry1() {
		WebElement country = getDriver().findElement(By.xpath("(//input[@autocomplete='country'])[2]"));
		country.clear();
		country.sendKeys("1, country");
		return this;
	}
	
	public EditAccountPage chooseCustomerPriority() {
		WebElement customerPriority = getDriver().findElement(By.xpath("(//div[@class='slds-combobox slds-dropdown-trigger slds-dropdown-trigger_click'])[6]"));
		getDriver().executeScript("arguments[0].click();", customerPriority);
		WebElement low = getDriver().findElement(By.xpath("//lightning-base-combobox-item[@data-value='Low']"));
		getDriver().executeScript("arguments[0].click();", low);
		return this;
	}
	
	public EditAccountPage chooseActive() {
		WebElement active = getDriver().findElement(By.xpath("(//div[@class='slds-combobox slds-dropdown-trigger slds-dropdown-trigger_click'])[9]"));
		getDriver().executeScript("arguments[0].click();", active);
		WebElement yes = getDriver().findElement(By.xpath("//lightning-base-combobox-item[@data-value='Yes']"));
		getDriver().executeScript("arguments[0].click();", yes);
		return this;
	}
	
	public EditAccountPage chooseRating() {
		WebElement rating = getDriver().findElement(By.xpath("//div[@class='slds-combobox slds-dropdown-trigger slds-dropdown-trigger_click']"));
		getDriver().executeScript("arguments[0].click();", rating);
		WebElement hot = getDriver().findElement(By.xpath("//lightning-base-combobox-item[@data-value='Hot']"));
		getDriver().executeScript("arguments[0].click();", hot);
		return this;
	}
	
	public EditAccountPage enterPhNo() {
		WebElement phno = getDriver().findElement(By.xpath("//input[@name='Phone']"));
		phno.clear();
		phno.sendKeys("9988998898");
		return this;
	}
	
	public EditAccountPage chooseOwnerShip() {
		WebElement ownerShip = getDriver().findElement(By.xpath("(//div[@class='slds-combobox slds-dropdown-trigger slds-dropdown-trigger_click'])[4]"));
		getDriver().executeScript("arguments[0].click();", ownerShip);
		WebElement Private = getDriver().findElement(By.xpath("//lightning-base-combobox-item[@data-value='Private']"));
		getDriver().executeScript("arguments[0].click();", Private);
		return this;
	}
	
	public AccountsPage clickSave() {
		getDriver().findElement(By.xpath("//button[text()='Save']")).click();
		return new AccountsPage(driver);
	}
}

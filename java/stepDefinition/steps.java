package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import base.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class steps extends BaseClass{
	
	
	
	
	@Given("Enter the username as {string}")
	public void enterUsername(String uName) {
		driver.findElement(By.id("username")).sendKeys(uName);

	}
	@Given("Enter the password as {string}")
	public void enterPassword(String pWord) {
		driver.findElement(By.id("password")).sendKeys(pWord);

	}
	@When("Click on the login button")
	public void clickLoginButton() {
		driver.findElement(By.id("Login")).click();
		
	}
	@Then("Verify the login")
	public void verifyLogin() {
		System.out.println(driver.getTitle());
	}
	@When("Click on toggle menu")
	public void clickToggleMenu() {
	    driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
	}
	@When("Click on view all")
	public void clickOnViewAll() {
	    WebElement viewall = driver.findElement(By.xpath("//button[text()='View All']"));
	    driver.executeScript("arguments[0].click();", viewall);
	}
	@When("Click on legal entities")
	public void clickOnLegalEntities() {
		WebElement le = driver.findElement(By.xpath("//p[text()='Legal Entities']"));
		driver.executeScript("arguments[0].click();", le);
	}
    @When("Click on dropdown")
	public void clickOnDropdown() {
		driver.findElement(By.xpath("(//*[name()='svg' and @data-key='chevrondown'])[6]")).click();
    }
    @When("Click on new legal entity")
    public void clickOnNewLegalEntity() {
    	WebElement Newlegal = driver.findElement(By.xpath("//span[text()='New Legal Entity']"));
		driver.executeScript("arguments[0].click();", Newlegal);
    }
    @Given("Enter name")
    public void enterName() {
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Salesforce Automation by Prathibha");
    }
    @When("Click on save")
    public void clickOnSave() {
		driver.findElement(By.xpath("//button[text()='Save']")).click();
    }
    @Then("Verify legal entity is created")
    public void verifyLegalEntity() {
    	String text = driver.findElement(By.xpath("//div[@data-aura-class=\"forceToastMessage\"]")).getText();
		if(text.contains("Salesforce Automation by Prathibha")) {
			System.out.println("New Legal Entity is created ");
		}
		else {
			System.out.println("New Legal Entity is not created");
    }
	
    }
    @When("Click on legal entities tab")
    public void clickOnLegalEntitiesTab() {
    	WebElement le1 = driver.findElement(By.xpath("//span[text()='Legal Entities']"));
		driver.executeScript("arguments[0].click();", le1);
    }
    @Given("Search for the legal entity")
    public void searchForLegalEntity() throws InterruptedException {
    	WebElement searchname = driver.findElement(By.xpath("//input[@name='LegalEntity-search-input']"));
		searchname.sendKeys("Salesforce Automation by Prathibha",Keys.ENTER);
		Thread.sleep(2000);
    }
	@When("Click on legal entity dropdown")
	public void clickOnLegalEntityDropDown() {
		WebElement dd = driver.findElement(By.xpath("//div[@class='forceVirtualActionMarker forceVirtualAction']/a[@role='button']"));
        driver.executeScript("arguments[0].click();", dd);
    }
	@When("Click on edit option")
	public void clickOnEditOption() {
		WebElement edit = driver.findElement(By.xpath("//a[@data-target-selection-name='sfdc:StandardButton.LegalEntity.Edit']"));
		driver.executeScript("arguments[0].click();", edit);
	}
	@When("Clear the company name and enter Testleaf")
	public void clearTheCompanyNameAndEnterTestleaf() {
		WebElement cn = driver.findElement(By.xpath("//input[@name='CompanyName']"));
		cn.clear();
		cn.sendKeys("Testleaf");
	}
	@When("Clear the description and enter SalesForce")
	public void clearTheDescriptionAndEnterSalesForce() {
		WebElement dp = driver.findElement(By.xpath("(//textarea[@class='slds-textarea'])[2]"));
		dp.clear();
		dp.sendKeys("SalesForce");
	}
	@When("Click on status dropdown")
	public void clickOnStatusDropDown() {
		WebElement statusdd = driver.findElement(By.xpath("//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value']"));
		driver.executeScript("arguments[0].click();", statusdd);	
	}
	@When("Choose the status as Active")
	public void chooseStatusAsActive() {
		WebElement status= driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Active']"));
		driver.executeScript("arguments[0].click();", status);
	}
	@When("Click on save button")
	public void saveButton() {
		WebElement save = driver.findElement(By.xpath("//button[@name='SaveEdit']"));
		driver.executeScript("arguments[0].click();", save);
	}
	@Given("search for the legal entity")
	public void searchForTheLegalEntity() {
		WebElement searchname = driver.findElement(By.xpath("//input[@name='LegalEntity-search-input']"));
        searchname.sendKeys("Salesforce Automation by Prathibha",Keys.ENTER);
	}
	@When("Click on first displayed legal entity")
	public void clickOnFirstDisplayedLegalEntity() {
		WebElement firstaccount = driver.findElement(By.xpath("//a[@title='Salesforce Automation by Prathibha']"));
		driver.executeScript("arguments[0].click();", firstaccount);
	}
	@Then("Verify the status as Active")
	public void VerifyStatusAsActive() {
		String status1= driver.findElement(By.xpath("(//div[@class='slds-form-element__control'])[5]")).getText();
		System.out.println(status1);
		if(status1.contains("Active")) {
			System.out.println("status is active");
		}else {
			System.out.println("status is not active");
		}
	}
	@When("Click on sales")
	public void clickOnSales() {
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
	}
	@When("Click on opportunity tab")
	public void clickOnOpportunityTab() {
		WebElement opportunity = driver.findElement(By.xpath("//span[text()='Opportunities']"));

		try {
			opportunity.click();
		} catch (Exception e) {
			
			driver.executeScript("arguments[0].click();", opportunity);
		}
	}
	@When("Click on new")
	public void clickOnNew() {
		driver.findElement(By.xpath("//div[text()='New']")).click();
	}
	@Given("Enter name and get text and store it")
	public void enterNameAndGetText() {
		String name = "Salesforce Automation by Prathibha";
		WebElement opName = driver.findElement(By.xpath("//input[@name='Name']"));
		opName.sendKeys(name);
		opName.getText();
		System.out.println(opName);
	}
	@When("Choose close date as today")
	public void chooseCloseDateAsToday(){
		driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
		driver.findElement(By.xpath("//td[@class='slds-is-today']")).click();
	}
	@When("Select stage as need analysis")
	public void selectStageAsNeedAnalysis() {
		driver.findElement(By.xpath("//button[@aria-haspopup='listbox']")).click();
		driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Needs Analysis']")).click();
	}
	
	@Then("Verify opportunity is created")
	public void verifyTheOpportunity() {
		String toasterMsg = driver.findElement(By.xpath("//span[@data-aura-class='forceActionsText']")).getText();
		System.out.println(toasterMsg);
		if(toasterMsg.contains("Prathibha")){
			System.out.println("Opportunity is created");
		}else {
			System.out.println("Opportunity is not created");
        }
	
			
	}
	@Given("Search for the opportunity")
	public void searchOpportunity() {
		String name = "Salesforce Automation by Prathibha";
		WebElement searchOp = driver.findElement(By.xpath("//input[@name='Opportunity-search-input']"));
		searchOp.sendKeys(name,Keys.ENTER);
	}
	@When("Click on opportunity dropdown")
	public void clickOnOpportunityDropdown() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@data-aura-class='forceVirtualAction']")).click();
	}
	@When("Click on edit")
	public void clickOnEdit() {
		WebElement edit = driver.findElement(By.xpath("//a[@data-target-selection-name='sfdc:StandardButton.Opportunity.Edit']"));
		driver.executeScript("arguments[0].click();", edit);
	}
	
	@When("Choose close date as tomorrow date")
	public void ChooseCloseDate() {
		WebElement closeDate = driver.findElement(By.xpath("//input[@name='CloseDate']"));
		closeDate.clear();
		closeDate.click();
		driver.findElement(By.xpath("//td[@class='slds-is-today']/following::td")).click();
	}
	@When("Select stage as perception analysis")
	public void selectStage() {
		driver.findElement(By.xpath("(//button[@aria-haspopup='listbox'])[2]")).click();
		driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Perception Analysis']")).click();
	}
	@Given("Enter the description as SalesForce")
	public void enterDescription() {
		
		
		WebElement des = driver.findElement(By.xpath("//div/textarea[@class='slds-textarea']"));
		driver.executeScript("arguments[0].click();", des);
		at.scrollToElement(des).perform();
		des.sendKeys("SalesForce");
	}
	@Then("Verify the stage as perception analysis")
	public void verifyStage() throws InterruptedException {
		Thread.sleep(2000);
		WebElement stage= driver.findElement(By.xpath("//span[text()='Perception Analysis']"));
		
		
		if(stage.getText().equals("Perception Analysis")) {
			System.out.println("stage is in Perception Analysis");
		}else {
			System.out.println("stage is not in Perception Analysis");
		}
	}
	@When("Choose delete option")
	public void chooseDelete() {
		WebElement delete = driver.findElement(By.xpath("//a[@data-target-selection-name='sfdc:StandardButton.Opportunity.Delete']"));
		driver.executeScript("arguments[0].click();", delete);
	}
	@When("Click on delete")
	public void clickDelete() {
		driver.findElement(By.xpath("//button[@title='Delete']")).click();
	}
	@Then("Verify the opportunity is deleted")
	public void verifyOpportunityIsDeleted() {
		WebElement delete = driver.findElement(By.xpath("//div[@data-key='success']"));
		if(delete.getText().contains("Prathibha")) {
			System.out.println("Opportunity is deleted");
		}else {
			System.out.println("Opportunity is not deleted");
		}
	}
	@And("Click on service territories")
	public void clickOnServiceTerritories() {
		WebElement sT = driver.findElement(By.xpath("//p[text()='Service Territories']"));
		driver.executeScript("arguments[0].click();", sT);
	}
	@Given("Enter the name")
	public void enterTheName() {
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Prathibha");
		
    }
	@When("Click on operating hours")
	public void clickOnOperatingHours() {
		driver.findElement(By.xpath("//input[@placeholder='Search Operating Hours...']")).click();
    }
	@And("Choose the first option")
	public void chooseTheFirstOption() {
		driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='0OH8d0000009pE1GAI']")).click();
    }
	@When("Check active field")
	public void checkActiveField() {
		WebElement activeField = driver.findElement(By.xpath("//span[@part='input-checkbox']/span"));
		driver.executeScript("arguments[0].click();", activeField);
    }
	@Given("Enter the city")
	public void enterTheCity() {
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys("City");
    }
	@And("Enter the state")
	public void enterTheState() {
		driver.findElement(By.xpath("//input[@name='province']")).sendKeys("State");
    }
	@And("Enter the country")
	public void enterTheCountry() {
		driver.findElement(By.xpath("//input[@name='country']")).sendKeys("Country");
	}
	@And("Enter Postal zip code")
	public void enterPostalZipCode() {
		driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys("123456");
	}
	@Then("Verify service territory is created")
	public void verifyServiceTerritoryIsCreated() {
		WebElement toasterMsg = driver.findElement(By.xpath("//div[@data-key='success']"));
		if(toasterMsg.getText().contains("Prathibha")) {
			System.out.println("Service territory is created");
		}else {
			System.out.println("Service territory is not created");
		}
	}
	@And("Click on service territory dropdown")
	public void clickOnServiceTerritoryDropdown() {
		driver.findElement(By.xpath("//span[@class='slds-icon_container slds-icon-utility-down']")).click();
	}
	@And("Choose edit")
	public void chooseEdit() {
		WebElement edit = driver.findElement(By.xpath("//a[@data-target-selection-name='sfdc:StandardButton.ServiceTerritory.Edit']"));
		driver.executeScript("arguments[0].click();", edit);
	}
	@And("Get the name alone from created by")
	public void getTheNameFromCreatedBy() {
		createdBy = driver.findElement(By.xpath("//span[text()='Created By']/following::span[@class='displayLabel']/slot")).getText();
		System.out.println(createdBy);
		String nameAlone = createdBy.replaceAll("[^a-zA-Z]+", "");
		System.out.println("name from created by : " + nameAlone);
		
	}
	@And("Get the name alone from modified by")
	public void getTheNameFromModifiedBy() {
		modifiedBy = driver.findElement(By.xpath("(//span[text()='Last Modified By']/following::span[@class='displayLabel']/slot)[3]")).getText();
		System.out.println(modifiedBy);
		String nameAlone = modifiedBy.replaceAll("[^a-zA-Z]+", "");
		System.out.println("name from modified by : " + nameAlone);
	}
	@And("Get the text of the owner")
	public void getTextOfTheTheOwner() {
		owner = driver.findElement(By.xpath("//span[text()='Owner']/following::span[@class='displayLabel']/slot")).getText();
		System.out.println("ownerName : " + owner);
	}
	@Then("Verify owner that matching created by and modified by")
	public void verifyOwner() {
		
        if(owner.matches(createdBy=modifiedBy)) {
        	System.out.println("owner is verified");
        }else {
        	System.out.println("owner is not verified");

        }
	}
	@Given("Change country name to North America")
	public void changeCountryName() {
		WebElement countryName = driver.findElement(By.xpath("//input[@name='country']"));
		countryName.clear();
		countryName.sendKeys("North America");
	}
	@Then("Verify last modified date")
	public void verifyLastModifiedDate() {
		String lMD = driver.findElement(By.xpath("//span[@data-aura-class='uiOutputDateTime']")).getText();
		System.out.println(lMD);
		if(lMD.contains("2023")) {
			System.out.println("last modified date is verified");
		}else {
			System.out.println("last modified date is not verified");

		}
	}
	
	
    }

